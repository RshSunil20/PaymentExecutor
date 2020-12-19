package nl.payments.model;

public class PaymentInfo {

	private String paymentRefId;
	
    private String Debitorid;

    private String Creditorid;

    private Double payment;

    private String paymentStatus;

	public String getDebitorid() {
		return Debitorid;
	}

	public void setDebitorid(String debitorid) {
		Debitorid = debitorid;
	}

	public String getCreditorid() {
		return Creditorid;
	}

	public void setCreditorid(String creditorid) {
		Creditorid = creditorid;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentRefId() {
		return paymentRefId;
	}

	public void setPaymentRefId(String paymentRefId) {
		this.paymentRefId = paymentRefId;
	}
    
}