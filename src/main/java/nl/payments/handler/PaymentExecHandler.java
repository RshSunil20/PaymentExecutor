package nl.payments.handler;

import nl.payments.model.AccountInfo;
import nl.payments.model.PaymentInfo;
import nl.payments.repo.AccountInfoRepo;
import nl.payments.repo.PaymentRepo;
import nl.payments.systema.BalanceCheck;

public class PaymentExecHandler {
	
    private static AccountInfoRepo accountInfoRepo = AccountInfoRepo.getInstance();
    
    private static PaymentRepo paymentRepo = PaymentRepo.getInstance();
    
	public static Boolean paymentTransfer(String debitorId, String creditorId, Double payment) {
		AccountInfo debitorAccountInfo = accountInfoRepo.find(debitorId);
		AccountInfo creditorAccountInfo = accountInfoRepo.find(creditorId);
		
		try {
			if (BalanceCheck.checkBalance(debitorId, payment)) {

				Double debitorAccountBalance  = debitorAccountInfo.getBalance();
				Double debitorAccountCurrentBalance = debitorAccountBalance - payment;
				
				debitorAccountInfo.setBalance(debitorAccountCurrentBalance);
				accountInfoRepo.update(debitorAccountInfo);
				
				Double creditorAccountBalance  = creditorAccountInfo.getBalance();
				Double creditorAccountCurrentBalance = creditorAccountBalance + payment;
				
				creditorAccountInfo.setBalance(creditorAccountCurrentBalance);
				accountInfoRepo.update(creditorAccountInfo);
				
				return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Boolean updatePaymentStatus(PaymentInfo paymentInfo) {
		return !(paymentRepo.update(paymentInfo) == null);
	}
}
