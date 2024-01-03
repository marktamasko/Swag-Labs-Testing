package toucanjeti.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Products {
    private WebDriver driver;
    //menu & menu itmes
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    //inventory items
    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> products;
    //item filter
    @FindBy(className = "product_sort_container")
    private Select filterSelect;
    //shopping cart & shopping cart counter
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingButton;
    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingButtonBadge;
    //By-s for item datas
    private static final By productName = By.className("inventory_item_name");
    private static final By productPrice = By.className("inventory_item_price");
    private static final By productDescription = By.className("inventory_item_desc");
    private static final By productButton = By.className("btn_inventory");

    public Products(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void pressMenuButton() {
        menuButton.click();
    }
    public void pressLogoutButton() {
        logoutButton.click();
    }
    public int getNumberOfProducts() {
        return products.size();
    }
    public String clickProductButton(int productNumber) {
        products.get(productNumber).findElement(productButton).click();
        return products.get(productNumber).findElement(productName).getText();
    }
}
