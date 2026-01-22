package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By username = By.id("username");
    private By password = By.id("password");
    private By submit = By.cssSelector("button[type='submit']");

    // Actions
    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("tomsmith");
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys("SuperSecretPassword");
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
    }
}

