package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    //TC-20,21,31,32,33
    @Test
    public void verifyCheckoutWithValidCustomerInformationTest() {

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product to Cart
        productsPage.addFirstProductToCart();

        // Open Shopping Cart
        productsPage.clickShoppingCart();

        // Verify Cart contains at least one product
        Assert.assertTrue(cartPage.getCartItemsCount() > 0,
                "Cart should contain at least one product.");

        // Click Checkout
        cartPage.clickCheckout();

        // Verify Checkout Information Page
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "Checkout: Your Information page should be displayed.");

        // Enter Valid Customer Information
        checkoutPage.enterCustomerInformation(
                "Markos",
                "Youssef",
                "12345"
        );

        // Click Continue
        checkoutPage.clickContinue();

        // Verify Checkout Overview Page
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPageDisplayed(),
                "User should proceed to Checkout: Overview page.");

        checkoutPage.clickFinsh();

        Assert.assertTrue(checkoutPage.isfinshOverviewPageDisplayed(),
                "Thank you for your order ");
        checkoutPage.clickBackHome();
        Assert.assertTrue(checkoutPage.isBackToHome(),
                "Products Page");

    }

    //TC-22
    @Test
    public void verifyCheckoutWithCustomerInformationEmptyFirstNameTest() {

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product and Open Cart
        System.out.println("Step 1: Adding product...");
        productsPage.addFirstProductToCart();

        System.out.println("Step 2: Opening Cart...");
        productsPage.clickShoppingCart();

        System.out.println("Step 3: Cart opened successfully.");

        // Proceed to Checkout
        System.out.println("Step 4: Clicking Checkout...");
        cartPage.clickCheckout();

        System.out.println("Step 5: Checkout button clicked.");

        // Verify Checkout Information
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "Checkout Information page should be displayed.");

        System.out.println("Step 6: Checkout Information opened.");

        // Enter Valid Customer Information
        checkoutPage.enterCustomerInformation(
                "",
                "Youssef",
                "12345"
        );

        // Click Continue
        checkoutPage.clickContinue();
        // Get actual error message
        String actualMessage = checkoutPage.getErrorMessage();

        // Expected error message
        String expectedMessage = "Error: First Name is required";

        // Verify actual and expected messages
        Assert.assertEquals(actualMessage, expectedMessage,
                "Incorrect error message for empty PostalCode");


    }

    //TC-23
    @Test
    public void verifyCheckoutWithCustomerInformationEmptyLastNameTest() {

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product and Open Cart
        System.out.println("Step 1: Adding product...");
        productsPage.addFirstProductToCart();

        System.out.println("Step 2: Opening Cart...");
        productsPage.clickShoppingCart();

        System.out.println("Step 3: Cart opened successfully.");

        // Proceed to Checkout
        System.out.println("Step 4: Clicking Checkout...");
        cartPage.clickCheckout();

        System.out.println("Step 5: Checkout button clicked.");

        // Verify Checkout Information
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "Checkout Information page should be displayed.");

        System.out.println("Step 6: Checkout Information opened.");

        // Enter Valid Customer Information
        checkoutPage.enterCustomerInformation(
                "Markos",
                "",
                "12345"
        );

        // Click Continue
        checkoutPage.clickContinue();
        // Get actual error message
        String actualMessage = checkoutPage.getErrorMessage();

        // Expected error message
        String expectedMessage = "Error: Last Name is required";

        // Verify actual and expected messages
        Assert.assertEquals(actualMessage, expectedMessage,
                "Incorrect error message for empty PostalCode");


    }

    //TC-24
    @Test
    public void verifyCheckoutWithCustomerInformationEmptyPostalCodeTest() {

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product and Open Cart
        System.out.println("Step 1: Adding product...");
        productsPage.addFirstProductToCart();

        System.out.println("Step 2: Opening Cart...");
        productsPage.clickShoppingCart();

        System.out.println("Step 3: Cart opened successfully.");

        // Proceed to Checkout
        System.out.println("Step 4: Clicking Checkout...");
        cartPage.clickCheckout();

        System.out.println("Step 5: Checkout button clicked.");

        // Verify Checkout Information
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "Checkout Information page should be displayed.");

        System.out.println("Step 6: Checkout Information opened.");

        // Enter Valid Customer Information
        checkoutPage.enterCustomerInformation(
                "Markos",
                "Youssef",
                ""
        );

        // Click Continue
        checkoutPage.clickContinue();
        // Get actual error message
        String actualMessage = checkoutPage.getErrorMessage();

        // Expected error message
        String expectedMessage = "Error: Postal Code is required";

        // Verify actual and expected messages
        Assert.assertEquals(actualMessage, expectedMessage,
                "Incorrect error message for empty PostalCode");


    }

    //TC-25
    @Test
    public void verifyCheckoutWithCustomerInformationEmptyTest() {

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product and Open Cart
        System.out.println("Step 1: Adding product...");
        productsPage.addFirstProductToCart();

        System.out.println("Step 2: Opening Cart...");
        productsPage.clickShoppingCart();

        System.out.println("Step 3: Cart opened successfully.");

        // Proceed to Checkout
        System.out.println("Step 4: Clicking Checkout...");
        cartPage.clickCheckout();

        System.out.println("Step 5: Checkout button clicked.");

        // Verify Checkout Information
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "Checkout Information page should be displayed.");

        System.out.println("Step 6: Checkout Information opened.");

        // Enter Valid Customer Information
        checkoutPage.enterCustomerInformation(
                "",
                "",
                ""
        );

        // Click Continue
        checkoutPage.clickContinue();

        // Get actual error message
        String actualMessage = checkoutPage.getErrorMessage();
        // Expected error message
        String expectedMessage = "Error: First Name is required";
        // Verify actual and expected messages
        Assert.assertEquals(actualMessage, expectedMessage,
                "Incorrect error message for empty PostalCode");


    }

    //TC26,27,28,29
    @Test
    public void verifyCheckoutOverviewSummaryTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        String[] selectedProducts = {
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        };

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Multiple Products
        productsPage.addProductsToCart(selectedProducts);

        // Open Cart
        productsPage.clickShoppingCart();

        // Proceed to Checkout
        cartPage.clickCheckout();

        // Enter Customer Information
        checkoutPage.enterCustomerInformation("Markos", "Youssef", "12345");
        checkoutPage.clickContinue();

        // Verify Checkout Overview Page
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPageDisplayed(),
                "Checkout Overview page should be displayed.");

        // TC-26: Verify Checkout Products
        Assert.assertEquals(checkoutPage.getOverviewProductsCount(), selectedProducts.length,
                "All selected products should appear in Checkout Overview.");

        Assert.assertTrue(checkoutPage.areOverviewProductsDisplayed(selectedProducts),
                "Selected products should be displayed in the order summary.");

        // TC-27: Verify Item Total
        double calculatedItemTotal = checkoutPage.getOverviewProductsTotal();
        double displayedItemTotal = checkoutPage.getItemTotal();

        Assert.assertEquals(displayedItemTotal, calculatedItemTotal, 0.01,
                "Item Total should equal the sum of product prices.");

        // TC-28: Verify Tax Calculation
        double displayedTax = checkoutPage.getTax();

        double expectedTax = Math.round(calculatedItemTotal * 0.08 * 100.0) / 100.0;

        Assert.assertEquals(displayedTax, expectedTax, 0.01,
                "Tax should be calculated correctly.");

        // TC-29: Verify Total Price
        double displayedTotal = checkoutPage.getTotal();

        double expectedTotal = Math.round((displayedItemTotal + displayedTax) * 100.0) / 100.0;

        Assert.assertEquals(displayedTotal, expectedTotal, 0.01,
                "Total should equal Item Total plus Tax.");
    }

    //TC-30
    @Test
    public void verifyCancelCheckout() {

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product to Cart
        productsPage.addFirstProductToCart();

        // Open Shopping Cart
        productsPage.clickShoppingCart();

        // Click Checkout
        cartPage.clickCheckout();
        // Click Cancel
        checkoutPage.clickCancel();
        Assert.assertTrue(checkoutPage.isBackToCartPageDisplayed(),
                "Checkout Canceled.");
    }

    //TC-35
    @Test
    public void verifyFirstNameWithNumbersTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product and Open Cart
        productsPage.addFirstProductToCart();
        productsPage.clickShoppingCart();

        // Proceed to Checkout
        cartPage.clickCheckout();

        // Enter Invalid First Name
        checkoutPage.enterCustomerInformation("Markos123", "Youssef", "12345");
        checkoutPage.clickContinue();

        // Verify First Name Validation
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "System should reject First Name containing numbers.");

    }

    //TC-36
    @Test
    public void verifyLastNameWithSpecialCharactersTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product and Open Cart
        productsPage.addFirstProductToCart();
        productsPage.clickShoppingCart();

        // Proceed to Checkout
        cartPage.clickCheckout();

        // Enter Invalid Last Name
        checkoutPage.enterCustomerInformation("Markos", "Youssef@#$", "12345");
        checkoutPage.clickContinue();

        // Verify Last Name Validation
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "System should reject Last Name containing special characters.");
    }

    //TC-37
    @Test
    public void verifyPostalCodeWithLettersTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product and Open Cart
        productsPage.addFirstProductToCart();
        productsPage.clickShoppingCart();

        // Proceed to Checkout
        cartPage.clickCheckout();

        // Enter Invalid Postal Code
        checkoutPage.enterCustomerInformation("Markos", "Youssef", "ABC123");
        checkoutPage.clickContinue();

        // Verify Postal Code Validation
        Assert.assertTrue(checkoutPage.isYourInformationPageDisplayed(),
                "System should reject Postal Code containing letters.");
    }


}

