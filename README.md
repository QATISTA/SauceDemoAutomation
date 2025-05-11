
# SauceDemoAutomation

This is a Selenium automation framework developed in Java using TestNG and ExtentReports. The project automates the end-to-end flow of the [SauceDemo website](https://www.saucedemo.com/), from user login to placing an order.

## ✅ Features Automated

- Login with valid credentials
- Adding products to the cart
- Viewing the cart with selected items
- Proceeding to the checkout page
- Filling in user information
- Verifying the total product price
- Completing the order and reaching the confirmation page

## 🧰 Technologies Used

- **Java 21**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **ExtentReports**
- **Assertions**
- **JavaScriptExecutor**
- **Firefox Browser**

## 🗂️ Project Structure

```
SauceDemoAutomation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/              # Page classes using Page Object Model
│   │           ├── CartPage.java
│   │           ├── Checkout.java
│   │           ├── HomePage.java
│   │           ├── LoginPage.java
│   │           └── ThankyouPage.java
│   │
│   └── test/
│       └── java/
│           ├── tests/              # Test classes
│           │   └── LoginTest.java
│           └── utilities/          # Test base and reusable logic
│               └── BaseTest.java
│
├── test-output/                    # TestNG and ExtentReport output
│   ├── SauceDemo Suite/
│   └── ExtentReport.html          # View this in any browser
│
├── pom.xml                         # Maven configuration
└── testng.xml                      # TestNG suite file
```

## 🔐 Test Credentials

- **Username**: `standard_user`  
- **Password**: `secret_sauce`

## 🚀 How to Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/SauceDemoAutomation.git
   cd SauceDemoAutomation
   ```

2. Make sure all dependencies are installed (Maven will handle this automatically):
   ```bash
   mvn clean install
   ```

3. Run the tests using TestNG:
   ```bash
   mvn test
   ```

## 📊 Test Reports

After the test execution:

- Navigate to the `test-output/` folder.
- Open `ExtentReport.html` with any web browser to view the detailed Extent Report.

## 🌐 Browser

- Tests are executed on **Firefox Browser**.
- Ensure Firefox is installed and WebDriver is set up correctly.

## 📌 Notes

- The project uses the **Page Object Model (POM)** for better maintainability and readability.
- ExtentReports are used for visually appealing, interactive test reports.
- Assertions and JavaScriptExecutor are used for validation and interaction enhancements.
 
