package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    // Cart Locators
    private By cartItems = By.className("cart_item");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By removeButtons = By.className("cart_button");
    private By continueShoppingButton = By.id("continue-shopping");
    private By shoppingCartIcon = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //TC-14 to TC-18
    // Get number of products in cart
    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

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
    public void openProductDetails(String productName) {

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

    //TC19
    // Click Checkout button
    public void clickCheckout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();

        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
    }

    // Check if Cart Page is displayed
    public boolean isCartPageDisplayed() {
        return driver.getCurrentUrl().contains("cart.html");
    }
}
