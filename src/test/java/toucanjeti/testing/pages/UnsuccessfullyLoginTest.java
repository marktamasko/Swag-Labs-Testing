package toucanjeti.testing.pages;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnsuccessfullyLoginTest {

    private static final String URL = "https://www.saucedemo.com/";
    private static WebDriver driver;
    private Login login;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
        login = new Login(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void test_notExistUsersLogin() {
        String expected = "Epic sadface: Username and password do not match any user in this service";
        String secretUser = System.getProperty("username", "defaultUsername");
        String secretPassword = System.getProperty("password", "defaultPassword");
        login.clickLoginButton(secretUser, secretPassword);
        String actual = login.getErrorMessage();
        assertEquals(expected, actual);
        login.clearLoginField();
    }

    @Test
    void test_lockedUserLogin() {
        String expected = "Epic sadface: Sorry, this user has been locked out.";
        String secretUser = System.getProperty("username", "defaultUsername");
        String secretPassword = System.getProperty("password", "defaultPassword");
        login.clickLoginButton(secretUser, secretPassword);
        String actual = login.getErrorMessage();
        assertEquals(expected, actual);
        login.clearLoginField();
    }
}
