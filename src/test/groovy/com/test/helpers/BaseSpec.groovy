package com.test.helpers

import geb.spock.GebReportingSpec
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.SessionId

class BaseSpec extends GebReportingSpec {

    def setupSpec() {
        SessionId session = ((RemoteWebDriver) driver).getSessionId()
    }
}
