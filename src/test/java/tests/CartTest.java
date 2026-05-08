package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    ConfigReader config = new ConfigReader();

    @Test
    public void verifyCartProducts() {

        LoginPage login = new LoginPage(driver);

        login.login(config.getEmail(),
                config.getPassword());

        DashboardPage dashboard =
                new DashboardPage(driver);

        dashboard.addFirstProductToCart();

        dashboard.clickCart();

        CartPage cart = new CartPage(driver);

        Assert.assertTrue(
                cart.getCartProductsCount() > 0);
    }

    @Test
    public void placeOrderTest() {

        LoginPage login = new LoginPage(driver);

        login.login(config.getEmail(),
                config.getPassword());

        DashboardPage dashboard =
                new DashboardPage(driver);

        dashboard.addFirstProductToCart();

        dashboard.clickCart();

        CartPage cart = new CartPage(driver);

        cart.clickCheckout();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        checkout.placeOrder();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Thankyou"));
    }
}