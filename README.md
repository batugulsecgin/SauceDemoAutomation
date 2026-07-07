# SauceDemo E2E Test Automation Framework

## 🎯 Overview
This repository contains a robust, automated End-to-End (E2E) testing framework built for the [SauceDemo](https://www.saucedemo.com/) e-commerce web application. The project is designed using a **Behavior-Driven Development (BDD)** approach, ensuring that test scenarios are readable, maintainable, and aligned with real-world business requirements.

![Görüntülenme Sayısı](https://komarev.com/ghpvc/?username=SENIN_KULLANICI_ADIN&color=blue)

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

### Core Features (Temel Özellikler)

| Tag | Feature | Description |
|-----|---------|-------------|
| `@smoke` | **Smoke Test** (login.feature) | Validates successful login with valid credentials. |
| `@negative` | **Negative Login Tests** (negative_login.feature) | Tests invalid login scenarios (locked user, wrong password, empty fields) with specific error message validation. |
| `@cart` | **Cart Management** (cart_management.feature) | Validates adding/removing items, cart badge synchronization, and navigation. |
| `@e2e` | **End-to-End Purchase** (e2e_purchase.feature) | Complete purchase flow: login → add items → checkout → order confirmation. |
| `@edge` | **Edge Cases** (edge_cases.feature) | Edge case scenarios like adding and immediately removing items. |

### Extended Features (Genişletilmiş Özellikler)

| Tag | Feature | Description |
|-----|---------|-------------|
| `@sorting` | **Product Sorting** (product_sorting.feature) | Tests all sorting options: A-Z, Z-A, Price (low to high), Price (high to low). |
| `@detail` | **Product Details** (product_detail.feature) | Validates product detail page: product name, price, description, image, and detail page actions. |
| `@bulk` | **Bulk Cart Operations** (bulk_cart.feature) | Tests adding/removing all products at once and completing bulk purchases. |
| `@coupon` | **Coupon & Discount** (coupon_discount.feature) | Validates absence of coupon field (negative test) and correct price calculations (Item Total + Tax). |

### Feature Files Summary
- **login.feature**: Basic authentication tests
- **negative_login.feature**: Error handling and validation
- **cart_management.feature**: Shopping cart operations
- **e2e_purchase.feature**: Complete purchase workflow
- **edge_cases.feature**: Boundary condition testing
- **product_sorting.feature**: Product list filtering and sorting (4 scenarios)
- **product_detail.feature**: Individual product page verification (3 scenarios)
- **bulk_cart.feature**: Batch operations on cartitems (3 scenarios)
- **coupon_discount.feature**: Discount functionality and price calculation (3 scenarios)
## ⚙️ Configuration

The `configuration.properties` file contains environment-specific settings:

```properties
browser=chrome              # Supported: chrome, firefox, edge, safari
url=https://www.saucedemo.com/  # Base URL of the application
username=standard_user      # Test user credentials
password=secret_sauce       # Default test password
```

### Available Test Users on SauceDemo
- **standard_user** / secret_sauce → Standard user (all features available)
- **locked_out_user** / secret_sauce → Locked account (used for negative tests)
- **performance_glitch_user** / secret_sauce → Slow page loads (performance testing)

## 🌐 Supported Browsers

The framework supports multiple browsers via configuration:

| Browser | Configuration Value | Requirements |
|---------|-------------------|---------------|
| Chrome | `chrome` | ChromeDriver (auto-managed by Selenium WebDriver) |
| Firefox | `firefox` | GeckoDriver installed |
| Edge | `edge` | EdgeDriver (auto-managed by Selenium WebDriver) |
| Safari | `safari` | Only on macOS, no driver required |

**Note:** By default, Chrome runs in **Incognito Mode** to avoid session caching. This can be modified in `Driver.java`.

## ⚙️ Setup and Execution

### Prerequisites
- **JDK 21** installed and configured
- **Maven 3.8+** installed
- **Java IDE** (IntelliJ IDEA or Eclipse recommended)
- **ChromeDriver/GeckoDriver/EdgeDriver** (auto-downloaded by Selenium 4.x)

### How to Run Locally
1. **Clone the repository:**
   ```bash
   git clone <your-github-repository-url>
   cd SauceDemoAutomation
   ```

2. **Load Dependencies:**
   Open the project in your IDE and reload the `pom.xml` to download all Maven dependencies:
   ```bash
   mvn clean install
   ```

3. **Configure Browser and URL (Optional):**
   Edit `configuration.properties` if needed:
   ```properties
   browser=chrome
   url=https://www.saucedemo.com/
   username=standard_user
   password=secret_sauce
   ```

4. **Run Tests via IDE:**
   - Locate `src/test/java/runners/Runner.java`
   - Modify the `tags` parameter in `@CucumberOptions` to select which tests to run
   - Right-click and select **Run 'Runner'** or press `Ctrl+Shift+F10` (IntelliJ)

5. **Run Tests via Maven Command Line:**
   ```bash
   # Run all tests
   mvn test
   
   # Run specific tag
   mvn test -Dcucumber.filter.tags="@smoke"
   
   # Run multiple tags
   mvn test -Dcucumber.filter.tags="@smoke or @cart"
   ```

### Test Execution Examples

**Run only Smoke Tests:**
```java
tags = "@smoke"
```

**Run Cart and E2E Tests:**
```java
tags = "@cart or @e2e"
```

**Run All Tests EXCEPT Negative Tests:**
```java
tags = "not @negative"
```

**Run Bulk Operations and Sorting:**
```java
tags = "@bulk and @sorting"
```

**Dry Run (Check for missing step definitions):**
```java
dryRun = true  // Change to true to validate without executing
```

⚠️ **Important Note for Turkish Locale Users:**
If your operating system is in Turkish, FreeMarker (used by ExtentReports) might encounter a locale-based character conversion issue (the "I-ı" bug). To fix this, add the following VM Options to your run configuration:
```
-Duser.language=en -Duser.country=US
```

In IntelliJ:
1. Click **Run** → **Edit Configurations**
2. Select **Runner**
3. In **VM options**, paste the above line
4. Click **Apply** and **OK**

📊 **Test Reporting**
This project is integrated with ExtentReports. Upon successful execution of the test suite, an interactive and detailed HTML report is automatically generated.

**Navigate to the test-output/SparkReport/ directory and open Spark.html in any web browser to view:**
- Test results summary (passed, failed, skipped)
- Step-by-step execution details
- Screenshots (on failure)
- Execution time graphics
- Browser and environment information

## 📚 Gherkin Scenarios and Best Practices

### Gherkin Syntax Used

All feature files follow **BDD Gherkin** format with Turkish language for readability:

```gherkin
Feature: Feature Name (What functionality is being tested)

  Background:           # Shared preconditions for all scenarios
    Given step...
    When step...

  @tag1 @tag2          # Tags for filtering execution
  Scenario: Scenario Name
    Given a precondition
    When an action occurs
    Then verify the outcome
```

### Key Gherkin Keywords
- **Feature**: Describes the feature being tested
- **Background**: Common setup steps executed before each scenario
- **Scenario**: A single test case
- **Scenario Outline**: Parameterized test with multiple data sets
- **Given**: Precondition / Setup
- **When**: Action / Event
- **Then**: Expected outcome / Assertion
- **And/But**: Additional steps

### Tagging Convention
- `@smoke` - Quick sanity checks (smoke tests)
- `@negative` - Error handling and edge cases
- `@cart` - Shopping cart related tests
- `@e2e` - End-to-end workflows
- `@edge` - Boundary conditions
- `@sorting` - Product sorting and filtering
- `@detail` - Product detail page
- `@bulk` - Batch operations
- `@coupon` - Discount and pricing logic

## 🏗️ Code Architecture Details

### Page Object Model (POM)
Each page class encapsulates:
- Web element locators using `@FindBy` annotations
- Page-specific business methods
- No test logic or assertions

Example structure:
```java
@PageFactoryConfig(driverName = "driver")
public class LoginPage {
    @FindBy(id = "user-name")
    private WebElement usernameField;
    
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
}
```

### Step Definitions
- Located in `src/test/java/stepdefinitions/`
- Implements Gherkin steps using `@Given`, `@When`, `@Then` annotations
- Communicates with Page classes to interact with UI

### Utilities
- **Driver.java** - Singleton WebDriver management with Incognito mode
- **ConfigReader.java** - Reads properties from `configuration.properties`

## ⚠️ Troubleshooting Guide

### Common Issues and Solutions

| Issue | Cause | Solution |
|-------|-------|----------|
| **WebDriver not found** | ChromeDriver/GeckoDriver missing | Update Chrome browser or use Selenium 4.x (auto-downloads drivers) |
| **Tests fail with locale errors** | Turkish OS locale conflicts | Add VM Options: `-Duser.language=en -Duser.country=US` |
| **Element not found exception** | Element not yet visible/loaded | Increase implicit wait in `Driver.java` (default: 15 seconds) |
| **Report not generated** | ExtentReports configuration issue | Verify `extent.properties` exists in `src/test/resources/` |
| **No step definitions found** | Glue path misconfigured | Ensure `glue = "stepdefinitions"` in Runner.java |
| **Tests hang indefinitely** | Incognito mode or site interaction issues | Check browser console for errors or disable incognito in `Driver.java` |

### Debugging Tips
1. **Enable verbose logging:** Add `System.out.println()` in step definitions
2. **Use breakpoints:** Debug mode in IDE to pause execution
3. **Check browser history:** Incognito mode clears cookies between runs
4. **Validate selectors:** Use browser DevTools to inspect elements
5. **Review error screenshots**: Check ExtentReport for failure screenshots

## 🔧 Customization Guide

### Change Browser
Edit `configuration.properties`:
```properties
browser=firefox  # or edge, safari
```

### Customize Wait Time
Edit `Driver.java` (line 49):
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Change 20 to desired seconds
```

### Disable Incognito Mode
Edit `Driver.java` (lines 27-31):
```java
// Comment out or remove the incognito line:
// chromeOptions.addArguments("--incognito");
```

### Add New Test Scenarios
1. Create a `.feature` file in `src/test/resources/features/`
2. Define steps with `@Given`, `@When`, `@Then` annotations
3. Update `Runner.java` tags to include new scenarios
4. Run via Maven or IDE

## 📊 Test Data & Test Users

The framework uses predefined test users from SauceDemo:

| Username | Password | Use Case |
|----------|----------|----------|
| `standard_user` | `secret_sauce` | Normal workflow testing |
| `locked_out_user` | `secret_sauce` | Negative login tests |
| `performance_glitch_user` | `secret_sauce` | Performance testing (slow pages) |

**Test Data Location**: `configuration.properties`

## 📦 Dependencies & Versions

| Dependency | Version | Purpose |
|-----------|---------|---------|
| Selenium WebDriver | 4.20.0 | Browser automation |
| Cucumber Java | 7.16.1 | BDD framework |
| Cucumber JUnit | 7.16.1 | Test runner integration |
| ExtentReports Adapter | 1.14.0 | HTML test reporting |
| JDK | 21 | Java runtime |

All dependencies are managed via Maven. Update versions in `pom.xml` as needed.

## 🎨 Report Customization

The report appearance can be customized via `src/test/resources/extent.properties`:

```properties
extent.reporter.spark.start=true
extent.reporter.spark.out=test-output/SparkReport/Spark.html
extent.reporter.spark.config=src/test/resources/extent-config.xml
```

## 📞 Support & Contribution

For issues, improvements, or contributions:
1. Create an Issue describing the problem
2. Fork the repository
3. Create a feature branch (`git checkout -b feature/improvement`)
4. Commit changes (`git commit -am 'Add improvement'`)
5. Push to branch (`git push origin feature/improvement`)
6. Create a Pull Request

## 📄 License

This project is open source and available under the MIT License.

---

**Happy Testing! 🚀**
