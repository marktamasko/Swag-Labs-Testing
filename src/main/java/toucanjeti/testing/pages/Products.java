package toucanjeti.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
