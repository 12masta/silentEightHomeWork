package com.szkolqa.biolerplate.tests.editassignment

import com.szkolqa.biolerplate.tests.BaseSpec
import io.qameta.allure.Epic
import io.qameta.allure.Feature

@Epic("EditAssignmentSpec")
@Feature("EditAssignmentSpec")
class EditAssignmentSpec extends BaseSpec {
    def "Open edit assignment without changes"() {
        when: "user open edit assignments"
        def editAssignmentsPage = loginPage.typeLogin(login)
                .typePassword(password)
                .clickLogin()
                .clickFirstDecisionTreeInUse()
                .clickEditAssignments()

        then: "save changes button is disabled"
        editAssignmentsPage.isDisabled()

        where:
        login                    | password
        "tester@silenteight.com" | "cS4aVcEfNP"
    }
}
