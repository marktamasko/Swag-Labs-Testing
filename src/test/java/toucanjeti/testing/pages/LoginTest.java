package toucanjeti.testing.pages;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {

    private static final String URL = "https://www.saucedemo.com/";
    private static WebDriver driver;
    private Login login;
    private Products products;

    @BeforeAll
    static void setupAll() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @BeforeEach
    void setUp() {
        login = new Login(driver);
        products = new Products(driver);
    }

    @AfterEach
    void tearDown() {
        this.products.pressLogoutButton();
    }

    @AfterAll
    static void tearDownAll() {
        driver.quit();
    }

    @Test
    void test_successfullyLogin() {
        String secretUser = System.getProperty("username", "defaultUsername");
        String secretPassword = System.getProperty("password", "defaultPassword");
        login.clickLoginButton(secretUser, secretPassword);
        products.pressMenuButton();
        boolean actual = products.checkVisibilityOfMenuButton();
        assertTrue(actual);
    }
}