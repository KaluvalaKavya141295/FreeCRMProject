package com.automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationFramework.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//td[@class='headertable']//td[contains(text(), 'User')]")
	WebElement displayname;
	
	@FindBy(xpath="//a[text()='Contacts']")
	//@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacts;

	//@FindBy(xpath="//a[text()='New Contact']")
	//@FindBy(xpath="//a[@title='New Contact']")
	//WebElement newcontact;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[text()='Calendar']")
	WebElement calendar;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homepagetitle() {
		return driver.getTitle();
	}
	
	public boolean validateloginname() {
		return displayname.isDisplayed();
	}
	
	public ContactsPage contactspage() {
		contacts.click();
		return new ContactsPage();
	}
	
/*	public void newcontactspage() {
		Actions action=new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newcontact.click();
	}*/
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", newContactLink);
		//newContactLink.click();
		//driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		
	}
	
	public CalendarPage calendarpage() {
		calendar.click();
		return new CalendarPage();
	}
}
