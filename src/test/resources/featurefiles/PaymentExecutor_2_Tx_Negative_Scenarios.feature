#Feature File
#Step definitions aren't created for cucumber steps in this feature file.

@FunctionalTests
Feature: Payment transfer request rejection for the amount which is missing transaction input criteria.
  
  @FunctionalTests 
  @RegressionTests
  Scenario Outline: Payment transfer request for invalid amount and amount greater than or equal to 1,000,000 euro is rejected
    Given a payment request of invalid <"amount"> is received via messaging services
    When the payment details are inserted in the database
    Then error <response code> and <"response message"> is created
    And the payment status is updated to invalid in the database
    
    Examples: 
      | amount  	| response code | response message  		|
      | 0.00			|     400				| Invalid amount				|
      | -1.000 		|     400				| Negative Tx Amount    |
			| -1.000.000|     400				| Negative Tx Amount		|
      | 1.000.000	|     400				| Amount exceeds limit  |
      | 1.000.001 |     400				| Amount exceeds limit	|
      | 1.00.00 	|     400				| Invalid amount        |