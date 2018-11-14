package com.szkolqa.boilerplate.testframework.pageobjects.login;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import com.szkolqa.boilerplate.testframework.pageobjects.decisiontree.DecisionTreePage;
import com.szkolqa.boilerplate.testframework.pageobjects.decisiontree.DecisionTreePageWebImpl;
import com.szkolqa.boilerplate.testframework.webelements.WebElementHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageWebImpl extends BasePage implements LoginPage{

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class = 'message']")
    private WebElement validationMessage;

    private final String relativeUrl = "/cas/login";

    public LoginPageWebImpl(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage typeLogin(String email) {
        webElementHandler.sendKeys(usernameInput, email);
        return this;
    }

    @Override
    public LoginPage typePassword(String password) {
        webElementHandler.sendKeys(passwordInput, password);
        return this;
    }

    @Override
    public DecisionTreePage clickLogin() {
        webElementHandler.click(submitButton);
        return new DecisionTreePageWebImpl(driver);
    }

    @Override
    public boolean validationMessageIsDisplayed() {
        return webElementHandler.isDisplayed(validationMessage);
    }

    @Override
    public boolean isDisplayed() {
        wait.untilPageIsLoaded(relativeUrl);
        return urlResolver.getUrlRelativePath().equals(relativeUrl);
    }
}