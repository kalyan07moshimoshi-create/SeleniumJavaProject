package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.devtools.idealized.Javascript;

public class AboutPage {

    WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

        public void scrollFullPageSlow() {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            long scrollHeight = ((Number) js.executeScript("return document.body.scrollHeight")).longValue();

            long currentPosition = 0;
            

            while (currentPosition < scrollHeight) {

                js.executeScript("window.scrollBy(0, 300);"); // scroll step
                currentPosition += 300;

               try {
                Thread.sleep(600);
               } catch (InterruptedException e) {
                e.printStackTrace();
               }
               }
            }            
            }                
            
    


