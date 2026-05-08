package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;

    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup() {

        String browser = config.getBrowser();

        if ("chrome".equalsIgnoreCase(browser)) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if ("firefox".equalsIgnoreCase(browser)) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}