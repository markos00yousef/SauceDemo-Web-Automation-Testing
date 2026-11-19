package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Checkout Information Locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By pageTitle = By.className("title");
    private By finshButton = By.id("finish");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By cancelButton = By.id("cancel");
    private By backHome = By.id("back-to-products");
    private By overviewItems = By.className("cart_item");
    private By overviewProductNames = By.className("inventory_item_name");
    private By overviewProductPrices = By.className("inventory_item_price");
    private By itemTotalLabel = By.className("summary_subtotal_label");
    private By taxLabel = By.className("summary_tax_label");
    private By totalLabel = By.className("summary_total_label");

    //TC-20,21,31
    // Enter Customer Information
    public void enterCustomerInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    // Click Continue Button
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    // Get Current Checkout Page Title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    // Verify Checkout Information Page
    public boolean isYourInformationPageDisplayed() {
        return getPageTitle().equals("Checkout: Your Information");
    }

    // Verify Checkout Overview Page
    public boolean isCheckoutOverviewPageDisplayed() {
        return getPageTitle().equals("Checkout: Overview");
    }

    public void clickFinsh() {
        driver.findElement(finshButton).click();
    }

    public boolean isfinshOverviewPageDisplayed() {
        return getPageTitle().equals("Checkout: Complete!");
    }

    //TC-22,23,24,25
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

    //TC-30
    public boolean isBackToCartPageDisplayed() {
        return getPageTitle().equals("Your Cart");
    }

    public void clickBackHome() {
        driver.findElement(backHome).click();
    }

    public boolean isBackToHome() {
        return getPageTitle().equals("Products");
    }

    //TC-26,27,28,29
    // Get number of products in Checkout Overview
    public int getOverviewProductsCount() {
        return driver.findElements(overviewItems).size();
    }

    // Get all product prices from Checkout Overview
    public double getOverviewProductsTotal() {
        double sum = 0;

        for (WebElement price : driver.findElements(overviewProductPrices)) {
            sum += Double.parseDouble(price.getText().replace("$", ""));
        }

        return sum;
    }

    // Get Item Total
    public double getItemTotal() {
        String text = driver.findElement(itemTotalLabel).getText();
        return Double.parseDouble(text.replace("Item total: $", ""));
    }

    // Get Tax
    public double getTax() {
        String text = driver.findElement(taxLabel).getText();
        return Double.parseDouble(text.replace("Tax: $", ""));
    }

    // Get Total
    public double getTotal() {
        String text = driver.findElement(totalLabel).getText();
        return Double.parseDouble(text.replace("Total: $", ""));
    }

    public boolean areOverviewProductsDisplayed(String... expectedProducts) {

        for (String product : expectedProducts) {
            boolean found = false;

            for (WebElement item : driver.findElements(overviewProductNames)) {
                if (item.getText().equals(product)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}

