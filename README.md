# Onliner-AutomationTests-TatevikHarutyunyan
# Project Structure
* Java
* Maven
* Selenide + selenium + TestNG
* Cucumber 
* Rest assure Api
* Realization PageObject, Page Factory,UserBuilder,Value object patterns
* Building the project through mvn commands + testng.xml
* Allure reports are connected
* Ci/Cd Jenkins
# Driver Implementation

Driver implemented in a `src/main/java/Driver`
* which contains selenide and selenium baseTest classes
* also driver creation class for the selenium 
* Selenide config class

SelenideConfigurations - contains configurations browserSize, headless ,baseUrl,timeout, pageLoadTimeout

BaseTestSelenide - contains driver creation configuration for the selenide tests

BaseTestSelenium- contains driver creation configuration for the selenium tests

ListenerSelenide and ListenerSelenium , these 2 classes contains methods on the test starts and fail, also have method for taking a screensjot 

Selenide and selenium Basetest class use appropriate listener class
properties file contains url,and some configs , which are using by the xml file, for running tests, also for some configuration

Retry Analyzer, which can be used for the retry some tests, which can be unstable

# Tests
Test are in a `src/test` Directory , every test Suite in separate package

For every test suite there is xml file created 

Test are configures for cross browser, parallel testing ,

Test are in smoke and regression levels , which are configured by annotations and properties , and added 
in a xml file

# Test running 

* Test can be ran manual , by xml file 
* Can be ran my mvn command line 
* Can't be run by class, if the Xml file, environment and url are setup in a property file , which is reading 
by xml file

