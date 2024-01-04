package toucanjeti.testing.pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetailsTest {
    private static final String URL = "https://www.saucedemo.com/";
    private static WebDriver driver;
    private Login login;
    private Products products;
    private ProductDetails productDetails;
    @BeforeAll
    void setUpAll() {
        driver = new ChromeDriver();
    }
    @BeforeEach
    void setUp() {
        driver.get(URL);
        login = new Login(driver);
        products = new Products(driver);
        productDetails = new ProductDetails(driver);
    }
    @AfterEach
    void tearDown() {
        this.products.pressLogoutButton();
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }
}
