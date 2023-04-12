package com.site.util;

import com.site.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public void switchToFrame(String frameElementName){ //Passes the frames locator name as a String argument. This argument should be provided from wherever this method is called
        driver.switchTo().frame(frameElementName);
    }
}
