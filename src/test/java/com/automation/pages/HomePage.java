package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // ========= CORRECT LOCATORS (CONTEXT-BASED) =========

    // Hero section dropdown (NOT header)
    private By heroDropdownButton =
            By.xpath("//main//button[contains(@class,'rounded-full')]");

    // Slider NEXT arrow (testimonial/cards section)
    private By sliderNextArrow =
            By.xpath("//section//button[contains(@class,'rounded-full') and contains(@class,'border')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ========= MAIN METHOD =========

    public void scrollAndHandleDropdownAndSlider() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        long pageHeight =
                ((Number) js.executeScript("return document.body.scrollHeight")).longValue();

        long currentScroll = 0;
        boolean dropdownClicked = false;
        boolean sliderHandled = false;

        while (currentScroll < pageHeight) {

            js.executeScript("window.scrollBy(0, 300);");
            currentScroll += 300;
            sleep(700);

            // 🔽 CLICK HERO DROPDOWN ONCE
            if (!dropdownClicked) {
                WebElement dropdown = getVisibleElement(heroDropdownButton);
                if (dropdown != null) {
                    System.out.println("Clicking HERO dropdown");
                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);
                    sleep(500);
                    dropdown.click();
                    dropdownClicked = true;
                    sleep(1200);
                }
            }

            // ▶ HANDLE SLIDER ARROW ONCE
            if (!sliderHandled) {
                WebElement sliderArrow = getVisibleElement(sliderNextArrow);
                if (sliderArrow != null) {
                    System.out.println("Clicking SLIDER arrows");

                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", sliderArrow);
                    sleep(500);

                    for (int i = 0; i < 5; i++) {   // adjust slide count if needed
                        sliderArrow.click();
                        sleep(1000);
                    }
                    sliderHandled = true;
                }
            }
        }

        System.out.println("Scroll + Dropdown + Slider actions completed");
    }

    // ========= HELPER METHODS =========

    /**
     * Returns the first visible element from a locator
     */
    private WebElement getVisibleElement(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement el : elements) {
            if (el.isDisplayed() && el.isEnabled()) {
                return el;
            }
        }
        return null;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
