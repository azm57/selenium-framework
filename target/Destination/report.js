$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyApp.feature");
formatter.feature({
  "line": 1,
  "name": "Creaftsvilla Application",
  "description": "",
  "id": "creaftsvilla-application",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#Scenario: User Registration"
    },
    {
      "line": 5,
      "value": "#Given Launch Browser and navigate to application"
    },
    {
      "line": 6,
      "value": "#And Read Test Data"
    },
    {
      "line": 7,
      "value": "#When Go to registration and enter all the data and click register"
    },
    {
      "line": 8,
      "value": "#Then Verify successful registration"
    }
  ],
  "line": 11,
  "name": "Add Products To Cart and Verify",
  "description": "",
  "id": "creaftsvilla-application;add-products-to-cart-and-verify",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "Launch Browser and navigate to application",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "Read Test Data",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "User Login to Application with valid Credentials",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "User navigates to Watchlist Page and Verifies the rows",
  "keyword": "And "
});
formatter.match({
  "location": "MyAppStepDefinitions.Launch_Browser_and_navigate_to_application()"
});
formatter.result({
  "duration": 31165043200,
  "status": "passed"
});
formatter.match({
  "location": "MyAppStepDefinitions.Read_Test_Data()"
});
formatter.result({
  "duration": 190710000,
  "status": "passed"
});
formatter.match({
  "location": "MyAppStepDefinitions.User_Login_to_Application_with_valid_Credentials()"
});
formatter.result({
  "duration": 6534066600,
  "status": "passed"
});
formatter.match({
  "location": "MyAppStepDefinitions.User_navigates_to_Product_Category_Page()"
});
formatter.result({
  "duration": 2612100500,
  "status": "passed"
});
});