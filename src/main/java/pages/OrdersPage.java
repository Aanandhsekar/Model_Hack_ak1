package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage extends BasePage {

    WebDriver driver;

    By ordersBtn = By.cssSelector("[routerlink='/dashboard/myorders']");
    By orderTable = By.tagName("tbody");

    public OrdersPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public void clickOrders() {

        driver.findElement(ordersBtn).click();
    }

    public boolean isOrderDisplayed() {

        return driver.findElement(orderTable).isDisplayed();
    }
}