package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DecisionTreePageWebImpl extends BasePage implements DecisionTreePage {

    //TODO: create proper ids for this buttons
    @FindBy(xpath = "//table[@class='decision-trees-list active-decision-trees']")
    private WebElement activeDecisionTreesTable;

    //TODO: create proper ids for this buttons
    @FindBy(xpath = "//table[@class='decision-trees-list inactive-decision-trees']")
    private WebElement inactiveDecisionTreesTable;

    //TODO: create proper ids for this buttons
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

    @Override
    public DecisionTreeDetailsViewPage clickDecisionTreeAvailable(String treeName) {
        PageFactory.initElements(driver, this);
        //sorry it is after 3am :D
        wait.seconds(3);
        webElementHandler.click(tableHandler.getLinkFromRow(inactiveDecisionTreesTable, treeName));
        return new DecisionTreeDetailsViewPageWebImpl(driver);
    }
}
