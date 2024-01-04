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

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/WrongUsers.csv", numLinesToSkip = 1)
    void test_notExistUsersLogin(String username, String password) {
        String expected = "Epic sadface: Username and password do not match any user in this service";
        login.clickLoginButton(username, password);
        String actual = login.getErrorMessage();
        assertEquals(expected, actual);
        login.clearLoginField();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/LockedUser.csv", numLinesToSkip = 1)
    void test_lockedUserLogin(String username, String password) {
        String expected = "Epic sadface: Sorry, this user has been locked out.";
        login.clickLoginButton(username, password);
        String actual = login.getErrorMessage();
        assertEquals(expected, actual);
        login.clearLoginField();
    }
}
