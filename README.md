# SauceDemo E2E Test Automation Framework

## 🎯 Overview
This repository contains a robust, automated End-to-End (E2E) testing framework built for the [SauceDemo](https://www.saucedemo.com/) e-commerce web application. The project is designed using a **Behavior-Driven Development (BDD)** approach, ensuring that test scenarios are readable, maintainable, and aligned with real-world business requirements.

## 🛠️ Tech Stack & Tools
- **Programming Language:** Java 21
- **Browser Automation:** Selenium WebDriver (v4.20.0)
- **BDD Framework:** Cucumber (v7.16.1)
- **Test Runner:** JUnit 4
- **Build Management:** Maven
- **Design Pattern:** Page Object Model (POM) & Singleton Driver
- **Reporting:** ExtentReports (Spark HTML Reporter)

## 🏗️ Project Architecture
The framework strictly adheres to the **Page Object Model (POM)** design pattern to separate test logic from web element locators, significantly reducing code duplication and improving maintainability.

- `src/test/resources/features`: Contains Gherkin scenarios (`.feature` files) written in plain language.
- `src/test/java/pages`: Contains Page classes (e.g., `LoginPage`, `InventoryPage`) where WebElements are located using `@FindBy` annotations.
- `src/test/java/stepdefinitions`: Contains the Java implementation of the steps defined in the feature files.
- `src/test/java/utilities`: Contains core utility classes:
  - `Driver.java`: Manages WebDriver instances using the Singleton pattern (includes Incognito mode setup).
  - `ConfigReader.java`: Dynamically reads test data and environment variables from `configuration.properties`.
- `src/test/java/runners`: Contains the `Runner` class to execute tests and trigger the reporting engine.

## 🚀 Test Scenarios Covered
1. **Smoke Test (`@smoke`):** Verifies basic login functionality with valid credentials.
2. **E2E Purchase Flow (`@e2e`):** Simulates a complete customer journey from logging in, adding multiple items to the cart, filling out checkout information, and verifying the order completion message.
3. **Cart Management (`@cart`):** Validates dynamic cart updates by adding items, navigating to the cart, removing specific items, and ensuring the cart badge synchronizes correctly.
4. **Data-Driven Negative Login (`@negative`):** Uses Cucumber `Scenario Outline` and `Examples` tables to execute multiple negative login attempts (locked-out user, wrong password, empty fields) and asserts the specific error messages for each case.
5. **Edge-Case (`@edge`):** Contains an edge case that adds and then deletes an item from the cart.
## ⚙️ Setup and Execution

### Prerequisites
- JDK 21 installed and configured.
- Maven installed.
- A Java IDE (IntelliJ IDEA recommended).

### How to Run Locally
1. **Clone the repository:**
   ```bash
   git clone <your-github-repository-url>

2. Load Dependencies:
Open the project in your IDE and reload the pom.xml to download all Maven dependencies.

3. Execute Tests:
Navigate to src/test/java/runners/Runner.java and run the class. By changing the "tags" parameter, you can run different cases.

⚠️ Important Note for Turkish Locale Users:
If your operating system is in Turkish, FreeMarker (used by ExtentReports) might encounter a locale-based character conversion issue (the "I-ı" bug). To fix this, add the following VM Options to your run configuration before executing:
-Duser.language=en -Duser.country=US

📊 Test Reporting
This project is integrated with ExtentReports. Upon successful execution of the test suite, an interactive and detailed HTML report is automatically generated.

Navigate to the test-output/SparkReport/ directory.

Open Spark.html in any web browser to view the test results, step-by-step execution details, and execution time graphics.
