package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditAssignmentModalPageWebImpl extends BasePage implements EditAssignmentModalPage {

    @FindBy(xpath = "//div[@class='popup-window is-active']")
    private WebElement activePopup;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    public EditAssignmentModalPageWebImpl(WebDriver driver) {
        super(driver);
        wait.visibilityOf(activePopup);
    }

    @Override
    public boolean isDisabled() {
        return webElementHandler.isDisabled(saveButton);
    }

    @Override
    public EditAssignmentModalPage clickAddInAvailable(String assignment) {
        //TODO: tottaly bad approach with activePopup WebElement but there is no way to do it better, selectors should be
        //improved in code base

        List<WebElement> assignmentsWebElements = activePopup.findElement(By.xpath(".//div[@class='horizontal-sections']"))
                .findElements(By.tagName("section"))
                .get(0)
                .findElements(By.tagName("li"));
        webElementHandler.click(listHandler.getAddButton(assignmentsWebElements, assignment));
        return new EditAssignmentModalPageWebImpl(driver);
    }

    @Override
    public EditAssignmentModalPage clickActivateInAvailable(String assignments) {
        List<WebElement> assignmentsWebElements = activePopup.findElement(By.xpath(".//div[@class='horizontal-sections']"))
                .findElements(By.tagName("section"))
                .get(1)
                .findElements(By.tagName("li"));
        webElementHandler.click(listHandler.getActivateButton(assignmentsWebElements, assignments));
        return new EditAssignmentModalPageWebImpl(driver);
    }

    @Override
    public DecisionTreeDetailsViewPage clickSave() {
        webElementHandler.click(saveButton);
        return new DecisionTreeDetailsViewPageWebImpl(driver);
    }
}
