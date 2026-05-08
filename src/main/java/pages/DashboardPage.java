package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage extends BasePage {

    WebDriver driver;

    By products = By.cssSelector(".mb-3");
    By addToCartBtn = By.cssSelector(".card-body button:last-of-type");
    By cartBtn = By.cssSelector("[routerlink='/dashboard/cart']");
    By cartCount = By.cssSelector(".cartCount");

    public DashboardPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public int getProductCount() {

        return driver.findElements(products).size();
    }

    public void addFirstProductToCart() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        List<WebElement> buttons =
                wait.until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(addToCartBtn));

        buttons.get(0).click();
    }

    public void addTwoProducts() {

        List<WebElement> list = driver.findElements(addToCartBtn);

        list.get(0).click();
        list.get(1).click();
    }

    public String getCartCount() {

        return driver.findElement(cartCount).getText();
    }

    public void clickCart() {

        driver.findElement(cartBtn).click();
    }
}