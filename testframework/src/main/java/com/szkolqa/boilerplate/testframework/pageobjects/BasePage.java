package com.szkolqa.boilerplate.testframework.pageobjects;

import com.szkolqa.boilerplate.testframework.url.UrlResolver;
import com.szkolqa.boilerplate.testframework.url.UrlResolverImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;
    UrlResolver urlResolver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.urlResolver = new UrlResolverImpl(driver);
    }

    public String getCurrentRelativeUrl(){
        return urlResolver.getUrlRelativePath();
    }
}
