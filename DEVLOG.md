# DEVLOG

This document describes the development process and key technical decisions made while working on this assignment.

---

## Step 1 – Project Initialization

- Created Maven project with Java 17
- Added core dependencies: Cucumber, JUnit 5, RestAssured
- Prepared basic project structure separating framework code and test code

**Goal:** build a framework, not just a set of single tests.

---

## Step 2 – Cucumber & API Setup

- Added first feature file for Official Joke API
- Implemented basic step definitions for GET requests
- Validated HTTP status codes and basic response structure

**Challenge:** correct configuration of Cucumber with JUnit Platform  
**Solution:** use `cucumber-junit-platform-engine` and proper resource structure

---

## Step 3 – Applying Different Cucumber Techniques

- Added scenarios using:
    - plain Scenario
    - Scenario Outline with Examples
    - DataTable
- Refactored steps to keep them reusable and readable

**Goal:** demonstrate understanding of different BDD techniques, not only API checks.

---

## Step 4 – Configuration & Maintainability

- Moved API base URL to `application.yml`
- Integrated Spring context with Cucumber
- Ensured configuration is not hardcoded in step definitions

---

## Step 5 – Reporting & Cleanup

- Configured Cucumber HTML reports
- Verified test execution from command line
- Cleaned up naming and package structure

---

## Step 6 – Upgrade

- Improved README and DEVLOG files, by adding some new topics
- Added new layer Functions for better readability and scalability

## Summary & Next Steps

This project focuses on clarity, correctness, and demonstrating core QA Automation skills.

Possible future improvements:
- CI integration (GitHub Actions)
- Allure reporting
- More negative and edge-case scenarios
