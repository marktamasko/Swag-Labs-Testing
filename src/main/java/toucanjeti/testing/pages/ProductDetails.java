package toucanjeti.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ProductDetails {
    private WebDriver driver;
    //TODO correct locators of ProductDetails POM
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement itemName;
    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    private WebElement itemDescription;
    @FindBy(className = "inventory_details_price")
    private WebElement itemPrice;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;
    @FindBy(id = "back-to-products")
    private WebElement backButton;

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
    }
    private void useFluentWait(WebElement element) {
        Wait<WebDriver> driverWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public String getItemName() {
        useFluentWait(itemName);
        return itemName.getText();
    }
    public String getItemDescription() {
        useFluentWait(itemDescription);
        return itemDescription.getText();
    }
    public String getItemPrice() {
        useFluentWait(itemPrice);
        return itemPrice.getText();
    }
    public String getButtonText() {
        useFluentWait(addToCartButton);
        return addToCartButton.getText();
    }
    public void clickBackButton() {
        useFluentWait(backButton);
        backButton.click();
    }
}
