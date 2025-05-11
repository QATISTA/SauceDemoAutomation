package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankyouPage {
    WebDriver driver;

    public ThankyouPage(WebDriver driver) {
        this.driver = driver;
    }

    private By FinishButton = By.id("finish");
    private By thankYouMessage = By.className("complete-header");

    public void clickthank() {
        driver.findElement(FinishButton).click();
    }

    public boolean isFinishButtonVisible() {
        return driver.findElement(FinishButton).isDisplayed();
    }

    public boolean isThankYouMessageVisible() {
        return driver.findElement(thankYouMessage).isDisplayed();
    }
}
