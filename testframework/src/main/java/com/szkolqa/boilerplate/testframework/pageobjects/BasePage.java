package com.szkolqa.boilerplate.testframework.pageobjects;

import com.szkolqa.boilerplate.testframework.url.UrlResolver;
import com.szkolqa.boilerplate.testframework.url.UrlResolverImpl;
import com.szkolqa.boilerplate.testframework.wait.Wait;
import com.szkolqa.boilerplate.testframework.webelements.ListHandler;
import com.szkolqa.boilerplate.testframework.webelements.TableHandler;
import com.szkolqa.boilerplate.testframework.webelements.WebElementHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected UrlResolver urlResolver;
    protected Wait wait;
    protected WebElementHandler webElementHandler;
    protected TableHandler tableHandler;
    protected ListHandler listHandler;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.urlResolver = new UrlResolverImpl(driver);
        this.wait = new Wait(this.driver);
        wait.untilPageIsFullyLoaded();
        this.webElementHandler = new WebElementHandler(driver);
        this.tableHandler = new TableHandler(webElementHandler);
        this.listHandler = new ListHandler(webElementHandler);
    }

    public String getCurrentRelativeUrl() {
        return urlResolver.getUrlRelativePath();
    }

    public String getJSessionId() {
        return driver.manage().getCookieNamed("JSESSIONID").getValue();
    }
}
