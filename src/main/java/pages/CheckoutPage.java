package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    WebDriver driver;

    By country = By.cssSelector("[placeholder='Select Country']");
    By india = By.xpath("(//button[contains(@class,'ta-item')])[2]");
    By placeOrder = By.cssSelector(".action__submit");

    public CheckoutPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public void placeOrder() {

        driver.findElement(country).sendKeys("India");

        waitForElement(driver.findElement(india));

        driver.findElement(india).click();

        driver.findElement(placeOrder).click();
    }
}