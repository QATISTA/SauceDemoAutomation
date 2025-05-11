package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutButton = By.id("checkout");

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public boolean isItemInCart(String itemName) {
        return driver.getPageSource().contains(itemName);
    }
}
