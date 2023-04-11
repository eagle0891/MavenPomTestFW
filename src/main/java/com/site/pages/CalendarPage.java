package com.site.pages;

import com.site.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends TestBase {

    public  CalendarPage(){
        PageFactory.initElements(driver, this);
    }
}
