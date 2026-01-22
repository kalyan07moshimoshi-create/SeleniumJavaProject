package com.automation.tests;

import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        driver.get("https://karkhana.moshimoshi.tech/");
        LoginPage page = new LoginPage(driver);
        page.enterUsername("tomsmith");
        page.enterPassword("SuperSecretPassword");
        page.clickLogin();
        System.out.println("Login test executed");
    }
}