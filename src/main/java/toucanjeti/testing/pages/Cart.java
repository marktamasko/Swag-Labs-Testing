package toucanjeti.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;

    private final By cartList = By.className("cart_list");
    private final By cartItem = By.className("cart_item");
    private final By nameOfItem = By.className("inventory_item_name");
    private final By descriptionOfItem = By.className("inventory_item_desc");
    private final By priceOfItem = By.className("inventory_item_price");
    private final By checkoutButton = By.id("checkout");

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

}
