package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

public interface EditAssignmentModalPage {
    boolean isDisabled();

    EditAssignmentModalPage clickAddInAvailable(String assignments);

    EditAssignmentModalPage clickActivateInAvailable(String assignments);

    DecisionTreeDetailsViewPage clickSave();
}
