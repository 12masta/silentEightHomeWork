package com.szkolqa.boilerplate.testframework.pageobjects.login;

import com.szkolqa.boilerplate.testframework.pageobjects.BasePage;
import com.szkolqa.boilerplate.testframework.webelements.WebElementHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageWebImpl extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    private WebElementHandler webElementHandler;

    public LoginPageWebImpl(WebDriver driver) {
        super(driver);
        this.webElementHandler = new WebElementHandler(driver);
    }
}