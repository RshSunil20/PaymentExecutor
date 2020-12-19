package StepDefinitions;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PaymentReject {

	@Autowired
	@Given("^a payment request of invalid (.*) is received via messaging services$")
	public void a_payment_request_of_invalid_is_received_via_messaging_services(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^error (\\d+) and (.*) is created$")
	public void error_and_is_created(int arg1, String arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the payment status is updated to invalid in the database$")
	public void the_payment_status_is_updated_to_invalid_in_the_database() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^failure response for balance query is received when the account balance is lesser than the transaction amount$")
	public void failure_response_for_balance_query_is_received_when_the_account_balance_is_lesser_than_the_transaction_amount() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the payment status is updated to failed in the database$")
	public void the_payment_status_is_updated_to_failed_in_the_database() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	
	@Then("^failure response is received for account with inactive status$")
	public void failure_response_is_received_for_account_with_inactive_status() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
