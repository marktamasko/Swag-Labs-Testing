package toucanjeti.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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

    public boolean checkVisibilityOfMenuButton() {
        try {
            return menuButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
