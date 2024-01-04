package toucanjeti.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.Select;
=======
import org.openqa.selenium.support.ui.Wait;
>>>>>>> main
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

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

    private void useFluentWait(WebElement element) {
        Wait<WebDriver> driverWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void pressMenuButton() {
        useFluentWait(menuButton);
        menuButton.click();
    }
    public void pressLogoutButton() {
        useFluentWait(logoutButton);
        logoutButton.click();
    }
    public int getNumberOfProducts() {
        return products.size();
    }
    public String clickProductButton(int productNumber) {
        products.get(productNumber).findElement(productButton).click();
        return products.get(productNumber).findElement(productName).getText();
    }
    public List<String> selectProduct(int productNumber) {
        WebElement product = products.get(productNumber);
        useFluentWait(product);
        product.findElement(productName).click();
        return List.of(
                product.findElement(productName).getText(),
                product.findElement(productDescription).getText(),
                product.findElement(productPrice).getText(),
                product.findElement(productButton).getText()
        );
    }

    public boolean checkVisibilityOfMenuButton() {
        try {
            return menuButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
