package com.duryodhana;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginPageTitle() {
        String title = loginPage.getLoginPageTitle();
        assertEquals(title, "Test Login | Practice Test Automation", "Login page title should match the expected value.");
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickLoginButton();
    }

    @Test
    public void testInvalidLogin() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLoginButton();

        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "", "");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
