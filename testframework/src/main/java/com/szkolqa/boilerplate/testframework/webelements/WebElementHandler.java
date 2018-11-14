package com.szkolqa.boilerplate.testframework.webelements;

import com.szkolqa.boilerplate.testframework.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebElementHandler {
    private WebDriver driver;
    private Wait wait;

    private static Logger logger = LoggerFactory.getLogger(WebElementHandler.class);


    public WebElementHandler(WebDriver driver){
        this.driver = driver;
        this.wait = new Wait(this.driver);
    }

    public WebElementHandler sendKeys(WebElement webElement, String input) {
        wait.elementToBeClickable(webElement);
        webElement.sendKeys(input);
        return this;
    }

    public WebElementHandler click(WebElement webElement) {
        wait.elementToBeClickable(webElement);
        webElement.click();
        return this;
    }

    public boolean isDisplayed(WebElement element) {
        boolean isDisplayed;
        try {
            isDisplayed = element.isDisplayed();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            isDisplayed = false;
        }
        return isDisplayed;
    }
}
