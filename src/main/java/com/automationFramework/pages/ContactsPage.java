package com.automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationFramework.base.TestBase;

public class ContactsPage extends TestBase{
	Select select;
	
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement checkcontactpage;
	
	//@FindBy(name="title")
	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
		
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactpage() {
		return checkcontactpage.isDisplayed();
		}
	public void verifycheckbox(String Name) {
		driver.findElement(By.xpath("//a[contains(text(), '"+Name+"')]//parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
	}
	public void newcontactlink(String title_value, String ftname, String ltname, String compname) {
		select=new Select(title);
		select.selectByVisibleText(title_value);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		companyname.sendKeys(compname);
		savebtn.click();
		
	}
}
