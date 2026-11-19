# SauceDemo Automation Project

## Project Overview

This project is an end-to-end test automation project for the [SauceDemo](https://www.saucedemo.com/) web application.

The project focuses on automating key e-commerce workflows, including user authentication, product management, shopping cart operations, and checkout functionality.

The test scenarios were designed from a QA perspective, starting with understanding the application features, identifying test scenarios, preparing test cases and expected results, and then implementing automation scripts using Selenium WebDriver.

## Technologies & Tools

- Java 20
- Selenium WebDriver 4.51.0
- TestNG 7.12.0
- Maven
- Page Object Model (POM)
- IntelliJ IDEA

## Project Structure

```text
SauceDemoAutomation/
│
├── src/
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java
│           │
│           ├── pages/
│           │   ├── LoginPage.java
│           │   ├── ProductsPage.java
│           │   ├── CartPage.java
│           │   └── CheckoutPage.java
│           │
│           └── tests/
│               ├── LoginTest.java
│               ├── ProductsTest.java
│               ├── CartTest.java
│               └── CheckoutTest.java
│
├── reports/
├── testng.xml
├── pom.xml
└── README.md
```

## Test Coverage

The project includes 28 automated test methods covering the following features:

### 1. Login
- Valid login
- Invalid username
- Invalid password
- Empty username and password validation

### 2. Products
- Products page verification
- Product details
- Adding single and multiple products to the cart
- Product price verification

### 3. Shopping Cart
- Opening the shopping cart
- Verifying added products
- Removing products
- Continuing shopping
- Empty cart checkout validation

### 4. Checkout
- Customer information validation
- Required field validation
- Checkout overview
- Item total, tax, and total price verification
- Cancel checkout
- Completing a purchase
- Order confirmation

### 5. Additional Validation
- First name containing numbers
- Last name containing special characters
- Postal code containing letters


## Framework Design

The project follows the **Page Object Model (POM)** design pattern.

- **BaseTest:** Handles WebDriver setup and teardown.
- **Pages:** Contains page locators and reusable page actions.
- **Tests:** Contains test methods and assertions.
- **TestNG:** Manages test execution, assertions, and test lifecycle.
- **TestNG Listeners:** Tracks test execution status (Passed, Failed, and Skipped).
- **Screenshot:** on Failure: Automatically captures screenshots when a test fails.
- **Log4j2:** Records test execution events, failure reasons, and screenshot paths.
- **Maven:** Manages project dependencies and test execution.

## Test Execution
| Result | Count |
|---|---:|
| Total Tests | 28 |
| Passed | 24 |
| Failed | 4 |
| Skipped | 0 |
## Execution Monitoring & Reporting
- **TestNG HTML Report:**  Provides a detailed summary of test execution results.
- **Execution Logs:** Stores execution details in logs/test-execution.log.
- **Failure Screenshots:** Automatically saves screenshots in screenshots/failed/ for debugging and evidence purposes.
### Prerequisites
- Java JDK 20
- Maven
- IntelliJ IDEA
- Google Chrome

### Run the tests

Execute the following command from the project root directory:

```bash
mvn clean test
```

The TestNG suite is configured through `testng.xml`.

## Test Reports

Test execution reports are generated under:

```text
SauceDemoAutomation/reports/
```

Open `TestNG-Report.html` in a browser to view the TestNG HTML report.

A copy of the report is also maintained in the project's `reports/` directory.


## 🐞 Bug Reports & Defect Documentation

During testing, 4 defects were identified and documented with reproduction steps, expected results, actual results, and screenshot evidence.

| Bug ID | Description | Test Case | Severity |
|---|---|---|---|
| BUG-001 | Checkout allowed with empty cart | TC-19 | Major |
| BUG-002 | First Name accepts numeric values | TC-35 | Medium |
| BUG-003 | Last Name accepts special characters | TC-36 | Medium |
| BUG-004 | Postal Code accepts alphabetic characters | TC-37 | Medium |

### Bug Report Details

- [BUG-001: Empty Cart Checkout](bug-reports/BUG-001-Empty-Cart-Checkout.md)
- [BUG-002: First Name Accepts Numbers](bug-reports/BUG-002-First-Name-Numbers.md)
- [BUG-003: Last Name Accepts Special Characters](bug-reports/BUG-003-Last-Name-Special-Characters.md)
- [BUG-004: Postal Code Accepts Letters](bug-reports/BUG-004-Postal-Code-Letters.md)

These findings highlight validation and business-logic issues identified during testing.

## Author

**Markos Youssef**

Software Tester | ISTQB® Certified Tester (CTFL v4.0)
