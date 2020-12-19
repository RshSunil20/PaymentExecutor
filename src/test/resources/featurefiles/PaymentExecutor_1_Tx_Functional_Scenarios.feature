#Feature File
#The step definitions are created for the first scenario in the feature file.

@FunctionalTests
Feature: Payment transfer request scenarios for amount less than 1.000.000 euro, meeting transaction limit criteria.

  @FunctionalTests
  @E2E
  Scenario: Payment transfer request for amount less than 1.000.000 euro is completed successfully
    Given Debitor & Creditor account exist
    And a payment request of amount "50.000" is received via messaging services
    When the payment details are inserted in the database
    Then success message and response is received
    When the systemA is queried for the debitor and creditor account status and available balance
    Then success response is received for account with active status
    And payment request is send to systemB
    And the payment status is updated to done in the database

  @FunctionalTests
  Scenario: Payment transfer request meeting limit criteria but lesser available balance on debitor account is rejected.
    Given a payment request of amount "90.000" is received via messaging services
    When the payment details are inserted in the database
    Then success message and response is received
    When the systemA is queried for the debitor and creditor account status and available balance
    Then success response is received for account with active status
    But failure response for balance query is received when the account balance is lesser than the transaction amount
    And the payment status is updated to failed in the database

	@FunctionalTests
  Scenario: Payment transfer request meeting limit criteria but debitor account is inactive.
    Given a payment request of amount "100" is received via messaging services
    When the payment details are inserted in the database
    Then success message and response is received
    When the systemA is queried for the debitor and creditor account status and available balance
    Then failure response is received for account with inactive status
    And the payment status is updated to failed in the database

	@FunctionalTests
  Scenario: Payment transfer request meeting limit criteria but creditor account is inactive.
    Given a payment request of amount "100.000" is received via messaging services
    When the payment details are inserted in the database
    Then success message and response is received
    When the systemA is queried for the debitor and creditor account status and available balance
    Then failure response is received for account with inactive status
    And the payment status is updated to failed in the database