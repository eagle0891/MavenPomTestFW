package com.site.pages;

import com.site.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends TestBase {

    @FindBy(xpath = "//input[@name='title']")
    WebElement calendarTitleField;

    @FindBy(xpath = "//div[@class='two fields'][2]//input[contains(@class, 'calendarField')]")
    WebElement calendarDateField;

    @FindBy(xpath = "//div[@class='react-datepicker']")
    WebElement calendarDatePicker;

    @FindBy(xpath = "//div[@class='react-datepicker__current-month']")
    WebElement calandarCurrentMonth;

    @FindBy(xpath = "//span[contains(@class, 'react-datepicker__navigation-icon--next')]")
    WebElement calendarNextMonthButton;

    @FindBy(xpath = "//div[@class='react-datepicker__month']")
    WebElement calendarMonthBlock;

    @FindBy(xpath = "//div[@class='react-datepicker__week']")
    WebElement calendarWeekBlock;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day react-datepicker__day')][not(contains(@class, '--outside-month'))]")
    WebElement calendarDay;

    public  CalendarPage(){
        PageFactory.initElements(driver, this);
    }

    /**************** WEBELEMENTS ********************/
    public WebElement getCalendarTitleField(){
        return calendarTitleField;
    }

    public WebElement getCalendarDateField(){
        return calendarDateField;
    }

    public WebElement getCalendarCurrentMonth(){
        return calandarCurrentMonth;
    }

    public WebElement getCalendarDatePicker(){
        return calendarDatePicker;
    }

    public WebElement getCalendarNextMonthButton(){
        return calendarNextMonthButton;
    }

    public WebElement getCalendarMonthBlock(){
        return calendarMonthBlock;
    }

    public WebElement getCalendarWeekBlock(){
        return calendarWeekBlock;
    }

    public WebElement getCalendarDay(){
        return calendarDay;
    }

    /**************** SEND KEYS ********************/
    public void populateCalendarTitleField(String title){
        getCalendarTitleField().sendKeys(title);
    }

    /**************** CLICKS ********************/
    public void clickOnCalendarDatePickerField(){
        getCalendarDateField().click();
    }

    public void clickOnNextMonthButton(){
        getCalendarNextMonthButton().click();
    }

    /************** CALENDAR FLOWS ********************/
    public void selectMonth(String month){

    }

    public void selectDay(String day){

    }
}
