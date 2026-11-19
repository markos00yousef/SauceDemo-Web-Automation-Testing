package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.annotations.DataProvider;
import pages.CartPage;

public class CartTest extends BaseTest {
    // TC-13 to TC-18: Cart Operations
    @Test
    public void verifyCartOperationsTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Test Data
        String backpack = "Sauce Labs Backpack";
        String bikeLight = "Sauce Labs Bike Light";

        // Add products to cart
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addProductsToCart(backpack, bikeLight);

        // Open Shopping Cart
        productsPage.clickShoppingCart();

        // Create Cart Page object
        CartPage cartPage = new CartPage(driver);

        // Verify cart contains two products
        Assert.assertEquals(cartPage.getCartItemsCount(), 2);

        // Verify product names
        Assert.assertTrue(cartPage.isProductInCart(backpack));
        Assert.assertTrue(cartPage.isProductInCart(bikeLight));

        // Verify product prices
        Assert.assertEquals(cartPage.getProductPrice(backpack), "$29.99");
        Assert.assertEquals(cartPage.getProductPrice(bikeLight), "$9.99");

        // Open Backpack details from cart
        cartPage.openProductDetails(backpack);

        // Verify product details
        Assert.assertEquals(
                productsPage.getDetailProductName(),
                backpack
        );

        Assert.assertEquals(
                productsPage.getDetailProductPrice(),
                "$29.99"
        );

        // Return to cart
        cartPage.returnToCart();

        // Remove Bike Light
        cartPage.removeProduct(bikeLight);

        // Verify remaining product
        Assert.assertEquals(cartPage.getCartItemsCount(), 1);
        Assert.assertTrue(cartPage.isProductInCart(backpack));
        Assert.assertFalse(cartPage.isProductInCart(bikeLight));

        // Continue Shopping
        cartPage.clickContinueShopping();

        // Verify Products Page
        Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }

    //TC19
    @Test
    public void verifyCheckoutWithEmptyCartTest() {

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Open Shopping Cart
        productsPage.clickShoppingCart();

        // Verify Cart is empty
        Assert.assertEquals(cartPage.getCartItemsCount(), 0,
                "Cart should be empty.");

        // Attempt to Checkout
        cartPage.clickCheckout();

        // Verify Checkout does not proceed
        Assert.assertTrue(cartPage.isCartPageDisplayed(),
                "Checkout should not proceed when Cart is empty.");
    }

}

