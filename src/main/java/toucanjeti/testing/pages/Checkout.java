package toucanjeti.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout {
    private final WebDriver driver;
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String fName) {
        firstNameInput.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastNameInput.sendKeys(lName);
    }

    public void enterPostalCode(int postalCode) {
        postalCodeInput.sendKeys(String.valueOf(postalCode));
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
