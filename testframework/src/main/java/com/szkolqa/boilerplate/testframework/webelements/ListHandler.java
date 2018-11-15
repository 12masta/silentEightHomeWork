package com.szkolqa.boilerplate.testframework.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListHandler {
    private WebElementHandler webElementHandler;
    private static Logger logger = LoggerFactory.getLogger(TableHandler.class);

    public ListHandler(WebElementHandler webElementHandler) {
        this.webElementHandler = webElementHandler;
    }

    public WebElement getAddButton(List<WebElement> webElements, String assignment) {
        return getButton(webElements, assignment, "add");
    }

    public WebElement getActivateButton(List<WebElement> webElements, String assignment) {
        return getButton(webElements, assignment, "activate");
    }

    private WebElement getButton(List<WebElement> webElements, String assignment, String className) {
        return findListElement(webElements, assignment).findElement(By.xpath(".//button[@class='" + className + "']"));
    }

    private WebElement findListElement(List<WebElement> webElements, String assignment) {
        for (WebElement el : webElements) {
            webElementHandler.scrollToElement(el);
            if (el.findElement(By.xpath(".//div[@class='name']")).getText().trim().equals(assignment)) {
                return el;
            }
        }
        logger.warn("List element was not found:" + assignment);
        return null;
    }
}
