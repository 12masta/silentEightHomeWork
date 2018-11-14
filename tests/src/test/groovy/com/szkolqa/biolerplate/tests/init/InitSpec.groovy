package com.szkolqa.biolerplate.tests.init

import com.szkolqa.biolerplate.tests.BaseSpec
import io.qameta.allure.Epic
import io.qameta.allure.Feature

@Epic("InitSpec")
@Feature("InitSpec")
class InitSpec extends BaseSpec {
    def "base page login check"() {
        expect:
        loginPage.getCurrentRelativeUrl().contains("/cas/login?service")
    }
}
