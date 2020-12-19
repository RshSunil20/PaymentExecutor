#Feature File
#Step definitions aren't created for cucumber steps in this feature file.

@FunctionalTests
Feature: Any system fails to rollback the Transaction status should rollback the transaction to maintain tx consistency.
  
  @FunctionalTests
  @RegressionTests
  Scenario: Payment transfer request is rolleded back when SystemB fails to respond for debit request after account credit.
    Given a payment request of amount "90.000" is received via messaging services
    When the payment details are inserted in the database
    Then success message and response is received
    When the systemA is queried for the debitor and creditor account status and available balance
    Then success response is received for account with active status
    When payment request is send to systemB
    And no response received from SystemB
    Then Tx is rolledback
    And Balance in SystemA should be same as before for both accounts
    And the payment status is updated to rolledback in the database
    

	@FunctionalTests
  @RegressionTests
  Scenario: Payment transfer request is rolleded back when Payment Executor database update fails.
    Given a payment request of amount "10.000" is received via messaging services
    When the payment details are inserted in the database
    Then success message and response is received
    When the systemA is queried for the debitor and creditor account status and available balance
    Then success response is received for account with active status
    When payment request is send to systemB
    And the payment status is update fails in the database
    Then Tx is rolledback