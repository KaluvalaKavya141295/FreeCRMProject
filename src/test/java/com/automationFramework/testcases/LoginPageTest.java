package com.automationFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationFramework.base.TestBase;
import com.automationFramework.pages.HomePage;
import com.automationFramework.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();//will execute the TestBase() constructor
		}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		//create an object for LoginPage class 
		loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void loginPagelogo() {
		boolean logo=loginpage.crmlogo();
		Assert.assertTrue(logo);	
	}
	@Test(priority=3)
	public void crmlogin() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
