package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    // @Test tells TestNG that this method is a test case
    // Test Case 1: Verify login with valid credentials
    @Test
    public void validLoginTest() {

        // Create LoginPage object and pass the existing WebDriver to it
        LoginPage loginPage = new LoginPage(driver);

        // Enter valid username
        loginPage.enterUsername("standard_user");

        // Enter valid password
        loginPage.enterPassword("secret_sauce");

        // Click the Login button
        loginPage.clickLogin();
        // Verify that the Products page is displayed
        Assert.assertTrue(
                loginPage.isProductsPageDisplayed(),
                "Login failed: Products page was not displayed"
        );
        System.out.println("Login test passed successfully!");

    }

    // Test Case 2: Verify login with invalid credentials
    @Test
    public void invalidLoginTest() {

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Enter invalid username
        loginPage.enterUsername("wrong_user");

        // Enter invalid password
        loginPage.enterPassword("wrong_password");

        // Click Login button
        loginPage.clickLogin();

        // Get the actual error message displayed by the website
        String actualMessage = loginPage.getErrorMessage();

        // Expected error message
        String expectedMessage =
                "Epic sadface: Username and password do not match any user in this service";

        // Verify that the actual error message matches the expected message
        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Error message does not match the expected result"
        );
    }
    // TC-03 :Verify login with invalid username
    @Test
    public void invalidUserName(){
        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Enter invalid Username
        loginPage.enterUsername("new_user");

        // Enter valid password
        loginPage.enterPassword("secret_sauce");

        // Click login
        loginPage.clickLogin();
        // Get the actual error message displayed by the website
        String actualMessage = loginPage.getErrorMessage();
        // Expected error message
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        // Verify that the actual error message matches the expected message
        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Error message does not match the expected result"
        );


    }
    //TC-04: Verify login with invalid Password
    @Test
    public void invalidPassword(){
        // Create LoginPage object
        LoginPage loginpage = new LoginPage(driver);
        // Enter valid Username
        loginpage.enterUsername("standard_user");
        // Enter invalid password
        loginpage.enterPassword("wrong_password");
        // Click login
        loginpage.clickLogin();
        // Get the actual error message displayed by the website
        String actualMessage = loginpage.getErrorMessage();
        // Expected error message
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        // Verify that the actual error message matches the expected message
        Assert.assertEquals(actualMessage,expectedMessage,"Error message does not match the expected result");
    }

    // TC-05: Verify login with empty username
    @Test
    public void emptyUsernameTest() {

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Leave username empty
        // Enter valid password
        loginPage.enterPassword("secret_sauce");

        // Click Login button
        loginPage.clickLogin();

        // Get actual error message
        String actualMessage = loginPage.getErrorMessage();

        // Expected error message
        String expectedMessage = "Epic sadface: Username is required";

        // Verify actual and expected messages
        Assert.assertEquals(actualMessage, expectedMessage,
                "Incorrect error message for empty username");
    }

    // TC-06: Verify login with empty password
    @Test
    public void emptyPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        // Enter valid username
        // Leave password empty
        loginPage.enterUsername("standard_user");

        // Click Login button
        loginPage.clickLogin();

        String actualMessage = loginPage.getErrorMessage();

        String expectedMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualMessage, expectedMessage,
                "Incorrect error message for empty password");
    }

    // TC-07: Verify login with both fields empty
    @Test
    public void emptyCredentialsTest() {

        LoginPage loginPage = new LoginPage(driver);

        // Leave both username and password empty
        // Click Login button
        loginPage.clickLogin();

        String actualMessage = loginPage.getErrorMessage();

        String expectedMessage = "Epic sadface: Username is required";

        Assert.assertEquals(actualMessage, expectedMessage,
                "Incorrect error message when both fields are empty");
    }

}



