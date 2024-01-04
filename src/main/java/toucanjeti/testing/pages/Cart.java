package toucanjeti.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart {
    private final WebDriver driver;
    private final By nameOfItem = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public List<String> getItemsInTheCart() {
        List<WebElement> cartElements = driver.findElements(nameOfItem);

        return cartElements.stream().map(WebElement::getText).toList();
    }
}
