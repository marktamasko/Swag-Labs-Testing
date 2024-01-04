package toucanjeti.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    private final WebDriverWait wait;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMessage;

    public Login(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    private void enterUsername(String username) {
        this.usernameField.sendKeys(username);
    }

    private void enterPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    public void clickLoginButton(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        this.loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clearLoginField() {
        this.usernameField.clear();
        this.passwordField.clear();
    }
}
