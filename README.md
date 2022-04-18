## CucumberTests 

Cucumber Test framework and reporting. 
 
## Introduction:- 

-This is a maven arch type project build for paymentexecutor application testing.
-This is build using the BDD approach.
-Implemented using Cucumber, Java and Serenity for reports. 
-This includes defined functional, end to end and regression tests. 


## Steps for Execution:- 
 

The designed feature files are under src/test/resources/featurefiles 
Since it follows BDD the individual features or scenarios can be run from any IDE’s where cucumber for java plugin is enabled and all project dependencies are installed (mvn clean install). 
To run the tests from terminal, navigate to the location in project structure where pom.xml is available and type 

`mvn clean verify –Dcucumber.options=”—tags @FunctionalTests` 


-After completion the cucumber reports are available in : 

/target/site/serenity/index.html

 

 

 
