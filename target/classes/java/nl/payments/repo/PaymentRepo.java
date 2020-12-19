package nl.payments.repo;

import nl.payments.model.PaymentInfo;
import java.util.Map;
import java.util.Hashtable;

public class PaymentRepo{
	
	Map<String, PaymentInfo> dbTable = new Hashtable<String, PaymentInfo> ();
	
	private PaymentRepo() {
	}
	
	private static PaymentRepo paymentRepo;
	
	public static PaymentRepo getInstance() {
		if(paymentRepo == null) {
			paymentRepo = new PaymentRepo();
		}
		return paymentRepo;
	}
	
	public void save(PaymentInfo paymentInfo) {
		dbTable.put(paymentInfo.getPaymentRefId(), paymentInfo);
	}
	
	public PaymentInfo update(PaymentInfo paymentInfo) {
		if(dbTable.containsKey(paymentInfo.getPaymentRefId())) {
			return dbTable.replace(paymentInfo.getPaymentRefId(), paymentInfo);
		}
		return null;
	}
	
	public PaymentInfo find (String paymentRefID) {
		if(dbTable.containsKey(paymentRefID)) {
			return dbTable.get(paymentRefID);
		}
		return null;
	}
}


