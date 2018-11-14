package com.szkolqa.boilerplate.testframework.pageobjects;

import com.szkolqa.boilerplate.testframework.url.UrlResolver;
import com.szkolqa.boilerplate.testframework.url.UrlResolverImpl;
import com.szkolqa.boilerplate.testframework.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected UrlResolver urlResolver;
    protected Wait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.urlResolver = new UrlResolverImpl(driver);
        this.wait = new Wait(this.driver);
        wait.untilPageIsFullyLoaded();
    }

    public String getCurrentRelativeUrl(){
        return urlResolver.getUrlRelativePath();
    }
}
