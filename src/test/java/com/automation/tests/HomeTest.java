package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
//import com.automation.pages.AboutPage;
import com.automation.pages.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void ScrollHomePageTest() throws InterruptedException {
        driver.get("https://new.zaggle.in");

        HomePage hm = new HomePage(driver);
        hm.scrollAndHandleDropdownAndSlider();

        System.out.println("Home page Scroll test executed");
    }


        /*@Test (dependsOnMethods = "ScrollHomePageTest")
        public void scrollAboutPageTest() {
            driver.get("https://new.zaggle.in/about-us");
            AboutPage ap =new AboutPage(driver);
            ap.scrollFullPageSlow();
            System.out.println("About page scroll test executed");

        }*/

    }


