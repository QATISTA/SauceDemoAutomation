package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public void addSauceLabsBackpackToCart() {
        driver.findElement(addToCartBackpack).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public boolean isOnHomePage() {
        return driver.getCurrentUrl().contains("inventory");
    }

    public boolean isCartItemCountVisible() {
        return !driver.findElements(By.className("shopping_cart_badge")).isEmpty();
    }
}