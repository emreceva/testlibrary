<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>test-library project</title>
</head>
<body>

  <h1>Selenium-Cucumber-Spring Framework</h1>
  <p align="left" <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="50" height=50"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer" <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> <p href="https://www.selenium.dev" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/detain/svg-logos/780f25886640cef088af994181646db2f6b1a3f8/svg/selenium-logo.svg" alt="selenium" width="50" height="50"/> <a href="https://spring.io" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="50" height="50"/> </a> <a href="https://cucumer.io" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/cucumberio/cucumberio-ar21.svg" alt="spring" width="50" height="50"/> </a> </p>

<h2>Overview</h2>
  <p>
    This project is a framework for automated testing using Selenium WebDriver, Cucumber in Spring Boot.
    It facilitates the implementation of behavior-driven development (BDD) practices in testing web applications.
    The goal of this framework is a main project which could be developed as TaaS(Test Automation As a Service).
  </p>

<h2>Features</h2>
  <ul>
    <li>Integration of Selenium WebDriver for web automation testing.</li>
    <li>Utilization of Cucumber for behavior-driven development (BDD) testing.</li>
    <li>Integration with Spring for dependency injection and test configuration management.</li>
    <li>Support for writing test scenarios in Gherkin syntax.</li>
    <li>Modular structure for better organization and maintainability of tests.</li>
  </ul>

<h2>Prerequisites</h2>
  <p>Before running the tests using this framework, ensure you have the following prerequisites installed:</p>
  <ul>
    <li>Java 21</li>
    <li>Maven 3.x</li>
    <li>Selenium WebDriver 4.x</li>
    <li>Cucumber 7.x</li>
    <li>Spring Framework 3.x</li>
    <li>JUnit 5.x</li>
  </ul>

<h2>Getting Started</h2>
  <ol>
    <li>Clone this repository to your local machine:</li>
    <p><code>git clone https://github.com/emreceva/testlibrary.git</code></p>
    <li>Navigate to the project directory:</li>
    <p><code>cd &lt;project-directory&gt;</code></p>
    <li>Build the project using Maven:</li>
    <p><code>mvn clean install</code></p>
    <li>Run the tests:</li>
    <p><code>mvn -Dtest="com.example.testlibrary.cucumber.CucumberSuiteRun" test</code></p>
  </ol>

<h2>Configuration</h2>
  <p><strong>cucumber.properties</strong></p>
  <pre>
    cucumber.glue=com.example.testlibrary.cucumber
    cucumber.features=src/test/resources/features
    cucumber.plugin=pretty, html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml
  </pre>

  <p><strong>junit-platform.properties</strong></p>
  <pre>
    cucumber.glue=com.example.testlibrary.cucumber
    cucumber.plugin=pretty, html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml
  </pre>

  <p><strong>application.properties</strong></p>
  <pre>
    browser=chrome
    web.implicitlyWait.timeout=1000
    web.pageLoad.Timeout=40
    web.wait.timeout=5
    web.script.timeout=15
    application.url=https://qa-test.pensa.app/
  </pre>

<h2>Writing Tests</h2>
  <p>The test scenarios and test cases are written using Cucumber and Gherkin syntax.</p>

<h2>Reporting</h2>
  <p>Cucumber report is integrated in this project as reporting tool. 
  The cucumber report could be  viewed under target files.</p>

<h2>License</h2>
  <p>All software tools used in this project are open-source.</p>

</body>
</html>
