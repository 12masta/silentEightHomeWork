package com.szkolqa.biolerplate.tests.editassignment

import com.szkolqa.biolerplate.tests.BaseSpec
import com.szkolqa.boilerplate.testframework.api.Api
import com.szkolqa.boilerplate.testframework.generators.RandomGenerator
import io.qameta.allure.Epic
import io.qameta.allure.Feature

@Epic("EditAssignmentSpec")
@Feature("EditAssignmentSpec")
class EditAssignmentSpec extends BaseSpec {

    def "Open edit assignment without changes for decision tree in use"() {
        when: "user open edit assignments for decision tree in use"
        def editAssignmentModalPage = loginPage.typeLogin(login)
                .typePassword(password)
                .clickLogin()
                .clickFirstDecisionTreeInUse()
                .clickEditAssignments()

        then: "save changes button is disabled"
        editAssignmentModalPage.isDisabled()

        where:
        login                    | password
        "tester@silenteight.com" | "cS4aVcEfNP"
    }

    def "Assign Assignments for blank tree"() {
        given: "user is already logged in"
        def decisionTreePage = loginPage.typeLogin(login)
                .typePassword(password)
                .clickLogin()
        and: "all assignments are ready to assign"
        def api = new Api(getConfig().url.toString(), decisionTreePage.getJSessionId())
        api.removeAllUsedAssignments()
        and: "blank tree is created"
        api.createBlankTree(treeName, 1)

        when: "user open edit assignments for newly created tree"
        def editAssignmentModalPage = decisionTreePage.clickDecisionTreeAvailable(treeName)
                .clickEditAssignments()
        and: "assign Assignments to Assigned"
        editAssignmentModalPage.clickAddInAvailable("US_BTCH_DENY")
                .clickAddInAvailable("US_PERD_DENY")
                .clickAddInAvailable("AE_BTCH_AM")
                .clickAddInAvailable("AE_BTCH_DENY")
                .clickAddInAvailable("BH_BTCH_DENY")
                .clickAddInAvailable("IN_BTCH_DENY")
                .clickAddInAvailable("IN_PERD_DENY")
        and: "assign Assignments to Active"
        editAssignmentModalPage.clickActivateInAvailable("US_BTCH_DENY")
                .clickActivateInAvailable("AE_BTCH_AM")
                .clickActivateInAvailable("BH_BTCH_DENY")
                .clickActivateInAvailable("IN_PERD_DENY")

        and: "click Save"
        def decisionTreeDetailsViewPage = editAssignmentModalPage.clickSave()

        then: "success notification has been displayed"
        decisionTreeDetailsViewPage.isSuccessfulNotificationDisplayed()

        where:
        login                    | password     | treeName
        "tester@silenteight.com" | "cS4aVcEfNP" | RandomGenerator.getRandomString(10)
    }

}
