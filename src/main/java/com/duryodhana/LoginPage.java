package com.duryodhana;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    // Constructor that initializes the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the username, password, and login button
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login");
    private final By errorMessage = By.id("error");

    // Method to enter the username
    public void enterUsername(String username) {
        WebElement userElement = driver.findElement(usernameField);
        userElement.clear();
        userElement.sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        WebElement passElement = driver.findElement(passwordField);
        passElement.clear();
        passElement.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to get the login page title
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    // Method to get the error message
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
