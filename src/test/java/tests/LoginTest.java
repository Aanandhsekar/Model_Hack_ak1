package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

@Listeners(listeners.TestListener.class)

public class LoginTest extends BaseTest {

    ConfigReader config = new ConfigReader();

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][]{

                {config.getEmail(), config.getPassword()},
                {config.getEmail(), "wrongpass"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String pass) {

        LoginPage login = new LoginPage(driver);

        login.login(email, pass);

        if(pass.equals(config.getPassword())) {

            Assert.assertTrue(
                    driver.getCurrentUrl()
                            .contains("dashboard"));

        } else {

            Assert.assertTrue(login.getErrorMessage()
                    .contains("Incorrect"));
        }
    }
}