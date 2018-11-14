package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DecisionTreePageWebImpl extends BasePage implements DecisionTreePage {

    @FindBy(xpath = "//table[@class='decision-trees-list active-decision-trees']")
    private WebElement activeDecisionTreesTable;

    @FindBy(xpath = "//div[@class='loading']")
    private List<WebElement> loadingScreens;

    private final String relativeUrl = "/decision-tree";

    public DecisionTreePageWebImpl(WebDriver driver) {
        super(driver);
        wait.untilPageIsLoaded(relativeUrl);
        wait.invisibilityOfAllElements(loadingScreens);
    }

    @Override
    public boolean isLoaded() {
        return urlResolver.getUrlRelativePath().equals(relativeUrl);
    }

    @Override
    public DecisionTreeDetailsViewPage clickFirstDecisionTreeInUse() {
        webElementHandler.click(tableHandler.getFirstRow(activeDecisionTreesTable));
        return new DecisionTreeDetailsViewPageWebImpl(driver);
    }
}
