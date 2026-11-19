package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // WebDriver instance used to interact with the browser
    private WebDriver driver;

    // Constructor receives the WebDriver from BaseTest
    // so this page uses the same browser session
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the username input field
    private By usernameField = By.id("user-name");
    // Locator for the password input field
    private By passwordField = By.id("password");
    // Locator for the Login button
    private By loginButton = By.id("login-button");
    // Locator for the Products page container
    private By productsContainer = By.id("inventory_container");
    // Locator for the Login error message
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Enter the username into the username field Method
    public void enterUsername(String username) {

        driver.findElement(usernameField).sendKeys(username);
    }

    // Enter the password into the password field
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Click the Login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Check if the Products page is displayed
    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsContainer).isDisplayed();
    }

    // Get the text of the Login error message
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}