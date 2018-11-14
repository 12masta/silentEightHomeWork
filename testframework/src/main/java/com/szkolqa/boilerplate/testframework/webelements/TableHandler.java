package com.szkolqa.boilerplate.testframework.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHandler {
    private WebDriver driver;

    public TableHandler(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstRow(WebElement table){
        return getRows(table).get(0);
    }

    public List<WebElement> getRows(WebElement table){
        return table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
    }
}
