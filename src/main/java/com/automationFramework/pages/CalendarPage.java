package com.automationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationFramework.base.TestBase;

public class CalendarPage extends TestBase{
	private static final String String = null;

	Select dpdwn;
	
	@FindBy(xpath="//a[text()='Calendar']")
	WebElement calendar;
	
	@FindBy(xpath="//select[@id='load_calendar_for_user_id']")
	WebElement userdropdown;
	
	@FindBy(name="slctMonth")
	WebElement monthdropdown;
	
	@FindBy(name="slctYear")
	WebElement yeardropdown;
	
	public CalendarPage() {
		PageFactory.initElements(driver, this);
		
	}
	public void calendarclick() {
		calendar.click();
	}
	public void userdd() {
	dpdwn=new Select(userdropdown);
	dpdwn.selectByVisibleText(prop.getProperty("loginname"));
	
	}
	public void monthdp() {
		dpdwn=new Select(monthdropdown);
		dpdwn.selectByVisibleText("December");
	}
	public void yeardp() {
		dpdwn=new Select(yeardropdown);
		dpdwn.selectByVisibleText("2015");
	}

}
