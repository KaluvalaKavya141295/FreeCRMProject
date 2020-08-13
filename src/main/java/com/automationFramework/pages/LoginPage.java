package com.automationFramework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationFramework.base.TestBase;

public class LoginPage extends TestBase {
	
	//define the pagefactory or object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='input-group-btn']//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement crmlogo;

//initialize the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);//this is pointing to current class object
	}
	//define actions present on login page
	public String validateloginpagetitle() {
		return driver.getTitle();
					//OR
		/*String logintitle=driver.getTitle();
		System.out.println(logintitle);	*/
	}
	public boolean crmlogo() {
		return crmlogo.isDisplayed();
	}
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginbtn);
		//loginbtn.click();//this is not working here
		
		return new HomePage();
	}
	
}
