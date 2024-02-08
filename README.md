test-library project


Selenium-Cucumber-Spring Framework
Overview

This project is a framework for automated testing using Selenium WebDriver, Cucumber in Spring Boot.
It facilitates the implementation of behavior-driven development (BDD) practices in testing web applications.
The goal of this framework is a main project which could be developed as TaaS(Test Automation As a Service) 

Features
Integration of Selenium WebDriver for web automation testing.
Utilization of Cucumber for behavior-driven development (BDD) testing.
Integration with Spring for dependency injection and test configuration management.
Support for writing test scenarios in Gherkin syntax.
Modular structure for better organization and maintainability of tests.
Easily extensible and customizable for specific project requirements.


Prerequisites
Before running the tests using this framework, ensure you have the following prerequisites installed:
Java 21
Maven 3.x
Selenium WebDriver 4.x
Cucumber 7.x
Spring Framework 3.x
JUnit 5.x


Getting Started
Clone this repository to your local machine:
https://github.com/emreceva/testlibrary.git
Git Clone Command
git clone <https://github.com/emreceva/testlibrary.git>

Navigate to the project directory:
cd <project-directory>

Build the project using Maven:
mvn clean install

Run the tests:
mvn -Dtest="com.example.testlibrary.cucumber.CucumberSuiteRun" test

Configuration

cucumber.properties

cucumber.glue=com.example.testlibrary.cucumber
cucumber.features=src/test/resources/features
cucumber.plugin=pretty, html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml

junit-platform.properties
cucumber.glue=com.example.testlibrary.cucumber
cucumber.plugin=pretty, html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml

application.properties
browser=chrome
web.implicitlyWait.timeout=1000
web.pageLoad.Timeout=40
web.wait.timeout=5
web.script.timeout=15
application.url=https://qa-test.pensa.app/

Writing Tests
The test scenarios and test cases are written using Cucumber and Gherkin syntax.

Reporting
Cucumber report is integrated in this project as reporting tool. 
The cucumber report could be  viewed under target files.

License
All software tools used in this project are open-source.