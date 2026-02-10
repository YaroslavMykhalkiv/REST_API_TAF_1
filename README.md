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
## ✅ Assignment Coverage

This project was created as a solution for a **Junior QA Automation Take-home Assignment**.

Below is a mapping between the assignment requirements and their implementation in this repository.

### Implemented Cucumber Scenarios

| Requirement                                                              | Implementation                                                                                                                                                |
|--------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Scenario A – Get a random joke and verify response structure             | `GetRandomJoke.feature` – uses a plain **Scenario** to validate HTTP status code and required response fields defined in **DataTable**                        |
| Scenario B – Retrieve multiple random jokes using different input values | `GetFewJokes.feature` – uses **Scenario Outline with Examples** to verify different numbers of jokes and **DataTable** to verify all required response fields |
| Scenario C – Get specific joke and validate all fields                   | `GetSpecificJoke.feature` – uses **Scenario Outline with Examples** to verify different jokes and **DataTable** to validate expected response fields          |

### Used Cucumber Techniques

The following Cucumber techniques are intentionally used to demonstrate BDD knowledge:

- **Scenario** – for simple, single-case API validation
- **Scenario Outline + Examples** – for parameterized API testing
- **DataTable** – to validate expected response fields in a readable way
- **Tags** – to allow selective test execution


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
## 🧱 Project Design

- Step definitions are kept thin and focus only on BDD intent
- All API interaction logic and assertions are encapsulated in a separate `Functions` layer
- This separation improves readability, reuse, and maintainability of test code
- The Functions layer is documented using JavaDoc to clearly describe
  responsibilities and expected behavior of each operation.


## 🤖 AI Usage Declaration

AI tools were used in a limited and supportive manner during development.

- AI was used mainly to clarify specific technical questions (e.g. Cucumber + JUnit 5 configuration, Spring integration concepts).
- AI also helped me write readable and easy-to-understand README and DEVLOG files.
- All JAVADoc that are present in the project is generated by AI.
- All code structure, test scenarios, and final implementations were reviewed, adapted, and written manually.
- The overall design decisions and test logic reflect my own understanding and learning process.


No code was blindly copied without understanding or verification.
