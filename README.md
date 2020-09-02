# Overview 
## Task 1 - Website automation - amazon.com 

### *Pattern*
Page object 
- easy to maintain, reusability of code, reliability , easy readable
- makes the automation framework more robust and reusable 
- easy to add any number of pages as the site grows and access methods 
- when a page property is changed it needs to be refactored only in the page class which makes it visible for all the test classes using that page 

### *Frameworks used*
*Selenium*  
- supports Java, Python, C# 
- portable and reliable for testing web applications 

*TestNG*
- Used in order to cover wider range of test categories 
- Supports annotations and dataproviders making the framework robust and easily expandable to handle many test cases and suites.
- Provides test reports to get an view of the passed and failed test cases 

*Log4j*
- Logging framework used to get the logs of successful and failed tests 
- Supports user defined messages 

### *Build Management / Project Management* 
*Maven* 
- Acts as central repository to get the dependancies of the project
- Dependancies easily handled through the pom.xml for any user

### *Test cases Scenarios* 

#### *HomePageTest* 
tests the translation of the site from German to English - inspects and asserts the translation of a specific element after clicking the English language option.
#### *SignInPageTest*
tests the sign in page with random username and password taken from the data provider annotation - validates and asserts the messages displayed on Login failed situation.
#### *ForgotPageTest*
tests the forgot password page with an email id to recover the password - validates and asserts the messages when the email id to recover password is not valid. 

### Installation & Execution 
*Method1* 
- Download / clone the project from Git 
- Open command prompt - change directory to the project path on your machine 
- mvn compile 
- mvn test 

#### Method2 
- Download / clone the project from Git 
- Import project in IDE of your choice 
- Open testng.xml -> Run as TestNG Suite 
- Open test output folder -> index.html -> to view the Test Results in consolidated manner 

## Task 2 - Android app automation - QA 
### *Pattern*
*Page object* 
- makes the automation framework more robust and reusable
- when a page property is changed it needs to be refactored only in the page class which makes it visible for all the test classes using that page 

### *Frameworks used*
*Appium* 
- for testing mobile and hybrid applications 
*TestNG*
- Used in order to cover wider range of test categories 
- Supports annotations and dataproviders making the framework robust and easily expandable to handle many test cases and suites.
*Log4j*
- Logging framework used to get the logs of successful and failed tests
*Extentreports* 
- reporting library integratable with TestNG and other testing frameworks 
- provides enriched and crisp content of reports in form of charts and dashboard 

### *Build Management / Project Management* 
*Maven* 
- Acts as central repository to get the dependancies of the project
- Dependancies easily handled through the pom.xml for any user

### *Test cases Scenarios* 
#### *LoginPageTest* 
tests the successful login of valid user with a valid password 
#### *HomePageTest*
tests the navigation from login page to home page - asserts by identifying the home image displayed in the page 
#### *WelcomePageTest*
validates Welcome toast message on Welcome page that is visible on clicking the button Click Me 

### Installation & Execution 
*Method1* 
- Download / clone the project from Git 
- invoke appium from the command prompt
- Open command prompt - change directory to the project path on your machine 
- Create an emulator in Android Studio - Refer data.properties file in the project under src/main/java/resources -Rename the deviceName(BabbelEmulator) to your deviceName(...)
- invoke the emulator using command - emulator -avd youremulatorname
- mvn compile 
- mvn test 

*Method2* 
- Download / clone the project from Git 
- Import project in IDE of your choice 
- Open testng.xml -> Run as TestNG Suite 
- Open reports folder to view the report generated on test execution and % of tests passed  

#Note
- Both the automation projects will execute 9 test cases in total (5 web - 4 mobile) 
- The test cases i have formulated are quite simple and focused mainly on page navigations and assertions of validation messages as nothing in specific was mentioned regarding the test scenarios
- I have made sure all the tests have passed in my execution run and if a test case fails in your execution run kindly go for a rerun
- In case of any issues/ questions with implementing or executing the test cases in your machine kindly let me know we shall have it fixed 
