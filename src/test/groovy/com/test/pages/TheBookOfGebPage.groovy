package com.test.pages

import geb.Page

class TheBookOfGebPage extends Page{

    static at = { title.startsWith(it) }

}
