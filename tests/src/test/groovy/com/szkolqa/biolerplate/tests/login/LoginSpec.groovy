package com.szkolqa.biolerplate.tests.login

import com.szkolqa.biolerplate.tests.BaseSpec
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import spock.lang.Unroll

@Epic("LoginSpec")
@Feature("LoginSpec")
class LoginSpec extends BaseSpec {
    def 'successfull login'() {
        when: "user provides correct login data"
        loginPage.typeLogin(login).typePassword(password)
        and: "click login"
        def decisionTreePage = loginPage.clickLogin()

        then: "user is redirected to decision tree page"
        decisionTreePage.isLoaded()

        where:
        login                    | password
        "tester@silenteight.com" | "cS4aVcEfNP"
    }

    @Unroll
    def 'login with wrong data'() {
        when: "user provides wrong login data"
        loginPage.typeLogin(login).typePassword(password)
        and: "click login"
        loginPage.clickLogin()

        then: "validation message is displayed"
        loginPage.validationMessageIsDisplayed()
        and: "user stays at login page"
        loginPage.isDisplayed()

        where:
        login                    | password
        "tester@silenteight.com" | ""
        ""                       | "tester@silenteight.com"
        ""                       | ""
    }
}
