package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.payments.handler.PaymentExecHandler;
import nl.payments.model.AccountInfo;
import nl.payments.model.PaymentInfo;
import nl.payments.repo.AccountInfoRepo;
import nl.payments.repo.PaymentRepo;
import nl.payments.systema.BalanceCheck;

public class PaymentSuccess {
	
	private String debitorAccountId = "A234Dwe";
	private String creditorAccountId = "B3434We";
	private String paymentStatus = "Initiated";
	private String paymentRefID = "Ref18192020";
	private Double payment;
	
	private PaymentInfo paymentinfo = new PaymentInfo();
	
	private PaymentRepo paymentRepo = PaymentRepo.getInstance();
	private AccountInfoRepo accountInfoRepo = AccountInfoRepo.getInstance();
	
	@Given("^Debitor & Creditor account exist$")
	public void Debitor_Creditor_account_exist() {
		// Hard codeing the account details
		AccountInfo debitorAccount = new AccountInfo();
		debitorAccount.setId(debitorAccountId);
		debitorAccount.setAccountStatus("active");
		debitorAccount.setBalance(Double.parseDouble("1000000"));
		
		AccountInfo creditorAccount = new AccountInfo();
		creditorAccount.setId(creditorAccountId);
		creditorAccount.setAccountStatus("active");
		creditorAccount.setBalance(Double.parseDouble("50000"));
		
		accountInfoRepo.save(debitorAccount);
		accountInfoRepo.save(creditorAccount);

	}
	
	@And("^a payment request of amount \"([^\"]*)\" is received via messaging services$")
	public void a_payment_request_of_amount_is_received_via_messaging_services(String amount) throws Exception {
		
		payment = Double.parseDouble(amount);
		//initializing tx details from xml
		paymentinfo.setCreditorid(creditorAccountId);
		paymentinfo.setDebitorid(debitorAccountId);
		paymentinfo.setPaymentStatus(paymentStatus);
		paymentinfo.setPaymentRefId(paymentRefID);
		paymentinfo.setPayment(payment);
		
	}

	@When("^the payment details are inserted in the database$")
	public void the_payment_details_are_inserted_in_the_database() throws Exception {
		//Create a record in DB
		paymentRepo.save(paymentinfo);
		
	}

	@Then("^success message and response is received$")
	public void success_message_and_response_is_received() throws Exception {
	    // assertion
		assertEquals(paymentinfo, paymentRepo.find(paymentRefID));
	}

	@When("^the systemA is queried for the debitor and creditor account status and available balance$")
	public void the_systemA_is_queried_for_the_debitor_account_status_and_available_balance() throws Exception {
	    // assert response
		assertTrue(BalanceCheck.checkBalance(debitorAccountId, payment));
	}

	@Then("^success response is received for account with active status$")
	public void success_response_is_recived_for_account_with_open_status() throws Exception {
		
		// debitor and creditor account details are validated
		assertEquals("active", accountInfoRepo.find(debitorAccountId).getAccountStatus());
		assertEquals("active", accountInfoRepo.find(creditorAccountId).getAccountStatus());
	}

	@And("^payment request is send to systemB$")
	public void payment_request_is_send_to_systemB() throws Exception {
		 PaymentExecHandler.paymentTransfer(debitorAccountId, creditorAccountId, payment);
	}

	@And("^the payment status is updated to done in the database$")
	public void the_payment_status_is_updated_to_done_in_the_database() throws Exception {
	    paymentinfo.setPaymentStatus("success");
	    PaymentExecHandler.updatePaymentStatus(paymentinfo);
	    
	    assertEquals("success", paymentRepo.find(paymentinfo.getPaymentRefId()).getPaymentStatus());
   }

}
