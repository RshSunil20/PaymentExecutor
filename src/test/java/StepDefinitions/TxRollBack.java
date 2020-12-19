package StepDefinitions;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TxRollBack {
	
	@Autowired
	@When("^no response received from SystemB$")
	public void no_response_received_from_SystemB() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Tx is rolledback$")
	public void tx_is_rolledback() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Balance in SystemA should be same as before for both accounts$")
	public void balance_in_SystemA_should_be_same_as_before_for_both_accounts() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the payment status is updated to rolledback in the database$")
	public void the_payment_status_is_updated_to_rolledback_in_the_database() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the payment status is update fails in the database$")
	public void the_payment_status_is_update_fails_in_the_database() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
	

}
