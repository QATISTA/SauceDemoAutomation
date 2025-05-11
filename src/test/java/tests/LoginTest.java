package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.BaseTest;

public class LoginTest extends BaseTest {

    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setUpReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Checkout Flow Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Test
    public void testCheckoutFlow() {
        test = extent.createTest("Checkout Flow Test");

        try {
            LoginPage login = new LoginPage(driver);
            login.login("standard_user", "secret_sauce");

            HomePage home = new HomePage(driver);
            Assert.assertTrue(home.isOnHomePage(), "Login failed or user not redirected to home page.");
            test.pass("Login successful and home page loaded.");

            home.addSauceLabsBackpackToCart();
            Assert.assertTrue(home.isCartItemCountVisible(), "Item count not visible in cart after adding product.");
            test.pass("Item added to cart and cart count is visible.");
            home.clickCartIcon();

            CartPage cart = new CartPage(driver);
            Assert.assertTrue(cart.isItemInCart("Sauce Labs Backpack"), "Expected item not found in cart.");
            test.pass("Correct item found in cart.");
            cart.clickCheckout();

            Checkout checkout = new Checkout(driver);
            Assert.assertTrue(checkout.isCheckoutPageVisible(), "Not on checkout page.");
            test.pass("Checkout page loaded successfully.");
            checkout.enterCheckoutInfo("John", "Doe", "12345");

            ThankyouPage thankyou = new ThankyouPage(driver);
            Assert.assertTrue(thankyou.isFinishButtonVisible(), "Finish button not visible.");
            thankyou.clickthank();

            Assert.assertTrue(thankyou.isThankYouMessageVisible(), "Thank you message not displayed.");
            test.pass("Order placed successfully and thank you message displayed.");

        } catch (AssertionError | Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}