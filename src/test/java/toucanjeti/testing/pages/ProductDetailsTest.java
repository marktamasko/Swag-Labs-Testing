package toucanjeti.testing.pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDetailsTest {
    private static final String URL = "https://www.saucedemo.com/";
    private static WebDriver driver;
    private Login login;
    private Products products;
    private ProductDetails productDetails;

    @BeforeAll
    static void setUpAll() {
        driver = new ChromeDriver();
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
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

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/LoginData.csv", numLinesToSkip = 1)
    void isDetailsIdenticalTest(String username, String password) throws InterruptedException {
        login.clickLoginButton(username, password);
        int i = 0;
        while (i < products.getNumberOfProducts()) {
            List<String> productData = products.getSelectedItemData(i);
            products.selectItem(i);
            List<String> detailsData = new ArrayList<>();
            detailsData.add(productDetails.getItemName());
            detailsData.add(productDetails.getItemDescription());
            detailsData.add(productDetails.getItemPrice());
            detailsData.add(productDetails.getButtonText());

            assertEquals(productData, detailsData);

            driver.navigate().back();
            i++;
        }
    }
}
