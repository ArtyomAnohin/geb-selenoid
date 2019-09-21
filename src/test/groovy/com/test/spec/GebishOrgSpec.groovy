package com.test.spec

import com.test.helpers.BaseSpec
import com.test.pages.GebishOrgHomePage
import com.test.pages.TheBookOfGebPage

class GebishOrgSpec extends BaseSpec {

    def "can get to the current Book of Geb"() {
        when:
        to GebishOrgHomePage

        and:
        manualsMenu.open()

        then:
        manualsMenu.links[0].text().startsWith("current")

        when:
        manualsMenu.links[0].click()

        then:
        at TheBookOfGebPage
    }
}

