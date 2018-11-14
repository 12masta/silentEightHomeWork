package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DecisionTreeDetailsViewPageWebImpl extends BasePage implements DecisionTreeDetailsViewPage {

    //TODO: create proper ids for this buttons
    @FindBy(xpath = "//div[@class='page-header-options']")
    private WebElement pageHeaderOptions;

    public DecisionTreeDetailsViewPageWebImpl(WebDriver driver) {
        super(driver);
    }

    @Override
    public EditAssignmentModalPage clickEditAssignments() {
        webElementHandler.click(pageHeaderOptions.findElements(By.tagName("button")).get(1));
        return new EditAssignmentModalPageWebImpl(driver);
    }
}
