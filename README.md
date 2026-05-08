ShopPractice – Selenium Java Automation Framework
Design Document

This project is developed as part of a hackathon to automate an E-Commerce practice web application using Selenium WebDriver with Java.

The framework is designed using the Page Object Model (POM) architecture to keep the code reusable, maintainable, and easy to understand. The project covers major functionalities like login, product handling, cart operations, checkout flow, and validations.

# Project Objective

The main goal of this project is to build a proper automation framework instead of writing standalone Selenium scripts.

This framework focuses on:

- Reusable automation structure
- Clean code organization
- Data-driven testing
- Reporting and screenshots
- External configuration management
- Industry-standard Selenium framework practices

# Application Under Test

Application Name: ShopPractice  
Application URL: https://rahulshettyacademy.com/client

Modules available in the application:

- User Authentication
- Product Listing
- Shopping Cart
- Checkout
- Order History
- Form Validation

# Technologies Used

| Technology | Purpose |

| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG | Test Framework |
| Maven | Build Management |
| WebDriverManager | Driver Management |
| ExtentReports | HTML Reporting |
| Git & GitHub | Version Control |

# Framework Design

The framework follows the Page Object Model (POM) design pattern.

Each page in the application has a separate Page class where all locators and reusable methods are maintained.

The test classes only contain test logic and validations.

This structure helps in:
- Reducing duplicate code
- Improving readability
- Easy maintenance
- Better scalability

# Project Structure

```text
ShopPracticeFramework/
│
├── src/test/java
│   ├── base
│   │   └── BaseTest.java
│   │
│   ├── pages
│   │   ├── BasePage.java
│   │   ├── LoginPage.java
│   │   ├── DashboardPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │   └── OrderPage.java
│   │
│   ├── tests
│   │   ├── LoginTest.java
│   │   ├── ProductTest.java
│   │   ├── CartTest.java
│   │   └── OrderTest.java
│   │
│   ├── utilities
│   │   ├── ConfigReader.java
│   │   ├── DriverFactory.java
│   │   ├── WaitUtils.java
│   │   ├── ScreenshotUtil.java
│   │   └── ExtentManager.java
│   │
│   └── listeners
│       └── TestListener.java
│
├── src/test/resources
│   ├── config.properties
│   ├── testng.xml
│   └── testdata.json
│
├── reports/
├── screenshots/
└── pom.xml
```

# Modules Covered

## 1. User Authentication

- Login with valid credentials
- Login with invalid credentials
- Empty field validation
- Logout functionality

## 2. Product Listing

- Verify products are displayed
- Verify product name and price
- Add product to cart
- Verify cart count update

## 3. Shopping Cart

- Verify products added to cart
- Remove product from cart
- Verify total amount
- Place order successfully

## 4. Order History (Optional)

- Verify latest order
- Verify order details
- Verify order ID and date

## 5. Form Validation (Optional)

- Empty field validation
- Duplicate email validation
- Password validation

# Wait Strategy

Explicit waits are used throughout the framework using:

- WebDriverWait
- ExpectedConditions

`Thread.sleep()` is completely avoided in the project.

# Reporting

ExtentReports is integrated to generate HTML execution reports.

The report contains:
- Test execution summary
- Pass/Fail status
- Failure screenshots
- Execution timestamps

Report Location:

```text
/reports/
```

# Screenshot on Failure

Screenshots are captured automatically whenever a test case fails.

Implementation is done using:
- TestNG ITestListener
- onTestFailure()

Screenshot Location:

```text
/screenshots/
```

# Data Driven Testing

TestNG DataProvider is used for executing test cases with multiple sets of data.

Used for:
- Valid login
- Invalid login
- Empty credentials

Future enhancement:
- Reading data from Excel or JSON files

# Important Framework Rules Followed

- No hardcoded URLs
- No hardcoded credentials
- No Thread.sleep()
- Proper POM implementation
- Reusable utility methods
- Browser setup using WebDriverManager
- Configurable browser execution

# Future Improvements

Some additional features planned for future implementation:

- Parallel execution
- Jenkins integration
- Docker support
- Cross-browser testing
- Retry analyzer
- Headless execution
- Excel data handling

# Final Outcome

This project helped in understanding how a real-time Selenium automation framework is designed and maintained using industry practices.

The framework is scalable, reusable, and structured properly for automation testing of web applications.
