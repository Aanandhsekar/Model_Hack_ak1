package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrdersPage;
import utils.ConfigReader;

public class OrderTest extends BaseTest {

    ConfigReader config = new ConfigReader();

    @Test
    public void verifyOrdersPage() {

        LoginPage login = new LoginPage(driver);

        login.login(config.getEmail(),
                config.getPassword());

        OrdersPage orders =
                new OrdersPage(driver);

        orders.clickOrders();

        Assert.assertTrue(
                orders.isOrderDisplayed());
    }
}