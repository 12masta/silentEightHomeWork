package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;

public class DecisionTreePageWebImpl extends BasePage implements DecisionTreePage {

    private final String relativeUrl = "/decision-tree";

    public DecisionTreePageWebImpl(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        wait.untilPageIsLoaded(relativeUrl);
        return urlResolver.getUrlRelativePath().equals(relativeUrl);
    }
}
