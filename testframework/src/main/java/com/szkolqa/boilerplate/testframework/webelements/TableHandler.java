package com.szkolqa.boilerplate.testframework.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class TableHandler {
    private WebElementHandler webElementHandler;
    private static Logger logger = LoggerFactory.getLogger(TableHandler.class);

    public TableHandler(WebElementHandler webElementHandler) {
        this.webElementHandler = webElementHandler;
    }

    public WebElement getFirstRow(WebElement table) {
        return getRows(table).get(0);
    }

    public WebElement getLinkFromRow(WebElement table, String treeName) {
        return getRowByName(table, treeName).findElement(By.xpath(".//td[@class='name']"))
                .findElement(By.tagName("a"));
    }

    private List<WebElement> getRows(WebElement table) {
        return table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
    }

    private WebElement getRowByName(WebElement table, String treeName) {
        for (WebElement el : getRows(table)) {
            webElementHandler.scrollToElement(el);
            if (el.findElement(By.xpath(".//td[@class='name']")).findElement(By.tagName("a")).getText().equals(treeName)) {
                return el;
            }
        }
        logger.warn("List element was not found:" + treeName);
        return null;


//        Optional<WebElement> optionalRow = getRows(table).stream()
//                .filter(el -> el.findElement(By.xpath(".//td[@class='name']"))
//                        .findElement(By.tagName("a")).getText().equals(treeName))
//                .findFirst();
//        if (optionalRow.isPresent()) {
//            return optionalRow.get();
//        }
//        logger.warn("Row in the table is not found!");
//        return null;
    }
}
