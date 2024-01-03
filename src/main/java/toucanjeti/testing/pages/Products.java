package toucanjeti.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Products {
    private WebDriver driver;

    public Products(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
