package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    WebDriver driver;

    By cartProducts = By.cssSelector(".cartSection h3");
    By deleteBtn = By.cssSelector(".btn-danger");
    By checkoutBtn = By.cssSelector(".totalRow button");

    public CartPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public int getCartProductsCount() {

        return driver.findElements(cartProducts).size();
    }

    public void deleteProduct() {

        driver.findElement(deleteBtn).click();
    }

    public void clickCheckout() {

        driver.findElement(checkoutBtn).click();
    }
}