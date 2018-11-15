package com.szkolqa.boilerplate.testframework.pageobjects.decisiontree;

public interface DecisionTreePage {
    boolean isLoaded();

    DecisionTreeDetailsViewPage clickFirstDecisionTreeInUse();

    String getJSessionId();

    DecisionTreeDetailsViewPage clickDecisionTreeAvailable(String treeName);

}
