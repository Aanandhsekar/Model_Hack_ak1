package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriver driver;

    By email = By.id("userEmail");
    By password = By.id("userPassword");
    By loginBtn = By.id("login");
    By errorMsg = By.cssSelector(".toast-error");

    public LoginPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public void enterEmail(String mail) {

        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {

        driver.findElement(loginBtn).click();
    }

    public void login(String mail, String pass) {

        enterEmail(mail);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement errorMessage =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.cssSelector(".toast-error")));

        return errorMessage.getText();
    }
}