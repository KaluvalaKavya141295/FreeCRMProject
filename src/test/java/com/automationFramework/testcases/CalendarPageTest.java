package com.automationFramework.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationFramework.base.TestBase;
import com.automationFramework.pages.CalendarPage;
import com.automationFramework.pages.HomePage;
import com.automationFramework.pages.LoginPage;
import com.automationFramework.util.TestUtil;

public class CalendarPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	CalendarPage calendarpage;
	TestUtil testutil;
	public CalendarPageTest() {
		super();
	}
	@BeforeMethod
	public void calendarpage() {
		initialization();
		calendarpage=new CalendarPage();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		homepage.calendarpage();
	}
	
	
	@Test(priority=1)
	public void userdpdwn(){
		calendarpage.userdd();
		//Assert.assertEquals(userdemo, prop.getProperty("loginname"));
	}
	
	@Test(priority=2)
	public void monthdd() {
		calendarpage.monthdp();
	}
	@Test(priority=3)
	public void yeardd() {
		calendarpage.yeardp();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	

}
