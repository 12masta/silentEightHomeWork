package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAssignmentModalPageWebImpl extends BasePage implements EditAssignmentModalPage {

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    public EditAssignmentModalPageWebImpl(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisabled() {
        return webElementHandler.isDisabled(saveButton);
    }
}
