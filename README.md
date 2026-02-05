# REST_API_TAF_1

Automated **REST API Testing Framework (TAF)** built in **Java** using **BDD with Cucumber (Gherkin)** and **REST‑Assured** to validate RESTful services.

---

## 🚀 Overview

This project is a reusable test automation framework designed to perform end-to-end REST API testing. It applies **Behavior-Driven Development (BDD)** principles, allowing tests to be described in plain language using **Gherkin feature files** and executed via Java.

---

## 📌 Assumptions & Requirements

- **Java version:** 17
- **Build tool:** Maven 
- **IDE:** IntelliJ IDEA, Eclipse, or any Java IDE that supports Maven and Cucumber
- **Environment:** API endpoints should be reachable; base URL set in `application.yaml` or configuration file

> Note: The framework assumes a working REST API environment. No mock servers are included by default.

---

## 🛠️ Build Instructions

### Build & Run All Tests

```bash
mvn clean test
```
This will compile the project, execute all tests, and generate default reports (target/testReports/*).
### Run Only Cucumber Tests

You can run specific tests via **runner class** or Maven command:

#### Using Maven and test class:
```bash
mvn -Dtest=TestRunner test
```
You can also use Test Runner classes under **src/test/java/cucumber/runner** to run Cucumber tests.
#### Running tests with a specific tag:
In the Test Runner classes you can run tests with a specific tag.

For example with a @smoke tag:

```
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@smoke")
```
## 📁 Project Structure
```bash
├── src/
│   ├── main/
│   │   └──  java/             # Core Java code (helpers, main app)
│   └── test/
│       ├── java/              # Step definitions,test runners & test config
│       └── resources/         # Gherkin feature files
├── pom.xml                    # Maven configuration
└── README.md                  # Project documentation
```
## ✍️ Writing Tests (BDD)
Feature files are located under:
```
src/test/resources/features/*
```
Example feature:
```
Feature: Random Joke

    Scenario: Get a random joke
    Given Official Joke API is available
    When user gets a random joke
    Then response status code should be "OK"
```

## 🔧 Core Technologies

| Technology         | Purpose                            |
| ------------------ | ---------------------------------- |
| Java               | Automation language                |
| Maven              | Build & dependency management      |
| Cucumber (Gherkin) | BDD test definition                |
| REST‑Assured       | HTTP request handling & validation |
| JUnit              | Test execution                     |
## 📊 Reporting
Cucumber HTML reports are available under **target/testReports** folder

## 📌 AI Usage Disclosure
Portions of this README were generated with the assistance of AI tools to standardize formatting and content.