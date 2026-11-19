
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class ProductsPage {

    // WebDriver instance
    private WebDriver driver;

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Products page container
    private By productsContainer = By.id("inventory_container");
    // Locator for all products
    private By productItems = By.className("inventory_item");
    // Locator for product names
    private By productNames = By.className("inventory_item_name");
    // Locator for product prices
    private By productPrices = By.className("inventory_item_price");
    // Locator for Add to Cart buttons
    //private By addToCartButtons = By.cssSelector("button[data-test^='add-to-cart']");
    // Locator for Shopping Cart Icon
    private By shoppingCartIcon = By.className("shopping_cart_link");
    private By productImg = By.className("inventory_item_img");
    // Product details locators
    private By detailProductName = By.className("inventory_details_name");
    private By detailProductDescription = By.className("inventory_details_desc");
    private By detailProductPrice = By.className("inventory_details_price");
    private By detailProductImage = By.className("inventory_details_img");
    private By detailAddToCartButton = By.cssSelector("button[data-test^='add-to-cart']");
    // Product Cart Locators
    private By addToCartButtons = By.className("btn_inventory");
    private By shoppingCartBadge = By.className("shopping_cart_badge");
    private By removeButtons = By.className("cart_button");
    private By continueShoppingButton = By.id("continue-shopping");
    private By cartItems = By.className("cart_item");

    //Methods
    //TC-8
    // Check if Products page is displayed
    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsContainer).isDisplayed();
    }

    // Get number of displayed products
    public int getProductsCount() {
        return driver.findElements(productItems).size();
    }

    // Check if all product names are displayed
    public boolean areProductNamesDisplayed() {
        return driver.findElements(productNames).size() == 6;
    }

    // Check if all product prices are displayed
    public boolean areProductPricesDisplayed() {
        return driver.findElements(productPrices).size() == 6;
    }

    // Check if all Add to Cart buttons are displayed
    public boolean areAddToCartButtonsDisplayed() {
        return driver.findElements(addToCartButtons).size() == 6;
    }

    // Check if Shopping Cart Icon is displayed
    public boolean isShoppingCartDisplayed() {
        return driver.findElement(shoppingCartIcon).isDisplayed();
    }

    public boolean areProductImgDisplayed() {
        return driver.findElement(productImg).isDisplayed();
    }

    //TC-9
    // Open a specific product details page
    public void openProductDetails(String productName) {
        // Get all product names displayed on Products Page
        for (WebElement product : driver.findElements(productNames)) {
            // Compare each product name with the requested name
            if (product.getText().equals(productName)) {
                // Click the matching product
                product.click();
                // Stop searching after clicking
                return;
            }
        }
        // If the product does not exist, fail with a clear message
        throw new NoSuchElementException("Product not found: " + productName);
    }

    // Get product name from Details Page
    public String getDetailProductName() {
        return driver.findElement(detailProductName).getText();
    }

    // Get product description
    public String getDetailProductDescription() {
        return driver.findElement(detailProductDescription).getText();
    }

    // Get product price
    public String getDetailProductPrice() {
        return driver.findElement(detailProductPrice).getText();
    }

    // Verify product image is displayed
    public boolean isDetailProductImageDisplayed() {
        return driver.findElement(detailProductImage).isDisplayed();
    }

    // Verify Add to Cart button is displayed
    public boolean isDetailAddToCartButtonDisplayed() {
        return driver.findElement(detailAddToCartButton).isDisplayed();
    }

    //TC-10
    // Add the first product to cart
    public void addFirstProductToCart() {
        driver.findElements(addToCartButtons).get(0).click();
    }

    // Get the first product button text
    public String getFirstProductButtonText() {
        return driver.findElements(addToCartButtons).get(0).getText();
    }

    // Get shopping cart badge count
    public int getCartItemCount() {

        if (driver.findElements(shoppingCartBadge).isEmpty()) {
            return 0;
        }

        return Integer.parseInt(
                driver.findElement(shoppingCartBadge).getText()
        );
    }

    // Add multiple selected products to cart
    public void addProductsToCart(String... productNamesToAdd) {

        // Get all product cards
        for (WebElement product : driver.findElements(productItems)) {

            // Get current product name
            String currentProductName =
                    product.findElement(productNames).getText();

            // Check if this product is in our test data
            for (String productName : productNamesToAdd) {

                if (currentProductName.equals(productName)) {

                    // Click its Add to Cart button
                    product.findElement(addToCartButtons).click();

                    break;
                }
            }
        }
    }

    //TC-11
    // Get button text for a specific product
    public String getProductButtonText(String productName) {

        for (WebElement product : driver.findElements(productItems)) {

            String currentProductName =
                    product.findElement(productNames).getText();

            if (currentProductName.equals(productName)) {

                return product.findElement(addToCartButtons).getText();
            }
        }

        throw new NoSuchElementException(
                "Product not found: " + productName
        );
    }

    //TC-12
    public void removeProductFromCart(String productName) {

        // Get all product cards
        for (WebElement product : driver.findElements(productItems)) {

            // Get current product name
            String currentProductName =
                    product.findElement(productNames).getText();

            // Find the requested product
            if (currentProductName.equals(productName)) {

                // Click Remove button
                product.findElement(addToCartButtons).click();

                return;
            }
        }

        throw new NoSuchElementException(
                "Product not found: " + productName
        );
    }

    // Get number of products in cart
    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    //TC-14-18
    // Check if a product exists in cart
    public boolean isProductInCart(String productName) {

        for (WebElement item : driver.findElements(cartItems)) {

            String currentName =
                    item.findElement(productNames).getText();

            if (currentName.equals(productName)) {
                return true;
            }
        }

        return false;
    }

    // Get product price from cart
    public String getProductPrice(String productName) {

        for (WebElement item : driver.findElements(cartItems)) {

            String currentName =
                    item.findElement(productNames).getText();

            if (currentName.equals(productName)) {

                return item.findElement(productPrices).getText();
            }
        }

        throw new NoSuchElementException(
                "Product not found in cart: " + productName
        );
    }

    // Open product details from cart
    public void opencartProductDetails(String productName) {

        for (WebElement item : driver.findElements(cartItems)) {

            String currentName =
                    item.findElement(productNames).getText();

            if (currentName.equals(productName)) {

                item.findElement(productNames).click();
                return;
            }
        }

        throw new NoSuchElementException(
                "Product not found in cart: " + productName
        );
    }

    // Remove a specific product from cart
    public void removeProduct(String productName) {

        for (WebElement item : driver.findElements(cartItems)) {

            String currentName =
                    item.findElement(productNames).getText();

            if (currentName.equals(productName)) {

                item.findElement(removeButtons).click();
                return;
            }
        }

        throw new NoSuchElementException(
                "Product not found in cart: " + productName
        );
    }

    // Return to the cart after viewing product details
    public void returnToCart() {
        driver.navigate().back();
    }

    // Click Continue Shopping
    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickShoppingCart() {
        driver.findElement(shoppingCartIcon).click();
    }


}



