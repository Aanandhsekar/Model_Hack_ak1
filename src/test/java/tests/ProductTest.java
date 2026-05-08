package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class ProductTest extends BaseTest {

    ConfigReader config;

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
    }

    @Test
    public void verifyProducts() {

        LoginPage login = new LoginPage(driver);

        login.login(config.getEmail(),
                config.getPassword());

        DashboardPage dashboard =
                new DashboardPage(driver);

        Assert.assertTrue(
                dashboard.getProductCount() > 0);
    }

    @Test
    public void addProductToCart() {

        LoginPage login = new LoginPage(driver);

        login.login(config.getEmail(),
                config.getPassword());

        DashboardPage dashboard =
                new DashboardPage(driver);

        dashboard.addFirstProductToCart();

        Assert.assertEquals(
                dashboard.getCartCount(), "1");
    }
}