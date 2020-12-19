package nl.payments.systema;

import nl.payments.model.AccountInfo;
import nl.payments.repo.AccountInfoRepo;

public class BalanceCheck {

    private static AccountInfoRepo accountInfoRepo = AccountInfoRepo.getInstance();

    public static Boolean checkBalance(String accountid, Double balance) throws Exception {

        AccountInfo accountInfo = accountInfoRepo.find(accountid);

        if (accountInfo!=null && accountInfo.getBalance() >= balance) {
            return true;
        }

        return false;

    }

}
