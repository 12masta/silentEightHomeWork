package com.szkolqa.boilerplate.testframework.pageobjects.login;

import com.szkolqa.boilerplate.testframework.pageobjects.decisiontree.DecisionTreePage;

public interface LoginPage {

    LoginPage typeLogin(String email);

    LoginPage typePassword(String password);

    DecisionTreePage clickLogin();

    boolean validationMessageIsDisplayed();

    boolean isDisplayed();
}
