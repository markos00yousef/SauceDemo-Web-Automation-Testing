package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)

public class BaseTest {

    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}