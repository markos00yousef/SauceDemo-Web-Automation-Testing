
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.annotations.DataProvider;

public class ProductsTest extends BaseTest {
    //TC-08
    @Test
    public void verifyProductsPageTest() {

        // Login to SauceDemo
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Create ProductsPage object
        ProductsPage productsPage = new ProductsPage(driver);

        // Verify Products page is displayed
        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed"
        );

        // Verify number of products
        Assert.assertEquals(
                productsPage.getProductsCount(),
                6,
                "Expected 6 products"
        );

        // Verify product names
        Assert.assertTrue(
                productsPage.areProductNamesDisplayed(),
                "Product names are missing"
        );

        // Verify product prices
        Assert.assertTrue(
                productsPage.areProductPricesDisplayed(),
                "Product prices are missing"
        );

        // Verify Add to Cart buttons
        Assert.assertTrue(
                productsPage.areAddToCartButtonsDisplayed(),
                "Add to Cart buttons are missing"
        );

        // Verify Shopping Cart Icon
        Assert.assertTrue(
                productsPage.isShoppingCartDisplayed(),
                "Shopping Cart Icon is not displayed"
        );
        Assert.assertTrue(
                productsPage.areProductImgDisplayed(),
                "product Img is not displayed"
        );

    }

    //TC-09
    // Test Data: Product Name and Expected Price
    @DataProvider(name = "productsData")
    public Object[][] productsData() {

        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99"},
                {"Sauce Labs Bike Light", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
                {"Sauce Labs Fleece Jacket", "$49.99"},
                {"Sauce Labs Onesie", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99"}
        };
    }

    @Test(dataProvider = "productsData")
    public void verifyProductDetailsTest(
            String expectedProductName,
            String expectedProductPrice) {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Open the selected product
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.openProductDetails(expectedProductName);

        // Verify product details
        Assert.assertEquals(
                productsPage.getDetailProductName(),
                expectedProductName,
                "Product name does not match"
        );

        Assert.assertTrue(
                !productsPage.getDetailProductDescription().isEmpty(),
                "Product description is empty"
        );

        Assert.assertEquals(
                productsPage.getDetailProductPrice(),
                expectedProductPrice,
                "Product price does not match"
        );

        Assert.assertTrue(
                productsPage.isDetailProductImageDisplayed(),
                "Product image is not displayed"
        );

        Assert.assertTrue(
                productsPage.isDetailAddToCartButtonDisplayed(),
                "Add to Cart button is not displayed"
        );
    }

    // TC-10: Add One Product to Cart
    @Test
    public void verifyAddOneProductToCartTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Create Products Page object
        ProductsPage productsPage = new ProductsPage(driver);

        // Add first product to cart
        productsPage.addFirstProductToCart();

        // Verify button changed to Remove
        Assert.assertEquals(
                productsPage.getFirstProductButtonText(),
                "Remove"
        );

        // Verify cart badge count
        Assert.assertEquals(
                productsPage.getCartItemCount(),
                1
        );
    }

    // TC-11 + TC-12: Add Multiple Products and Remove One Product
    @Test
    public void verifyAddAndRemoveProductsTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);

        // Test Data
        String backpack = "Sauce Labs Backpack";
        String bikeLight = "Sauce Labs Bike Light";
        String boltTShirt = "Sauce Labs Bolt T-Shirt";

        // Add three products
        productsPage.addProductsToCart(
                backpack,
                bikeLight,
                boltTShirt
        );

        // Verify all three products were added
        Assert.assertEquals(productsPage.getCartItemCount(), 3);

        Assert.assertEquals(
                productsPage.getProductButtonText(backpack),
                "Remove"
        );

        Assert.assertEquals(
                productsPage.getProductButtonText(bikeLight),
                "Remove"
        );

        Assert.assertEquals(
                productsPage.getProductButtonText(boltTShirt),
                "Remove"
        );

        // Remove Bike Light&backpack
        productsPage.removeProductFromCart(bikeLight);
        productsPage.removeProductFromCart(backpack);
        // Verify removed product
        Assert.assertEquals(
                productsPage.getProductButtonText(bikeLight),
                "Add to cart"
        );

        // Verify remaining products
        Assert.assertEquals(
                productsPage.getProductButtonText(backpack),
                "Add to cart"
        );

        Assert.assertEquals(
                productsPage.getProductButtonText(boltTShirt),
                "Remove"
        );

        // Verify cart contains two products
        Assert.assertEquals(productsPage.getCartItemCount(), 1);
    }


}
