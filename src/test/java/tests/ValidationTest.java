package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ValidationTest extends BaseTest {

    @Test
    public void emptyLoginValidation() {

        LoginPage login = new LoginPage(driver);

        login.clickLogin();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Email is required"));
    }
}