package com.automationFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationFramework.base.TestBase;
import com.automationFramework.pages.CalendarPage;
import com.automationFramework.pages.ContactsPage;
import com.automationFramework.pages.HomePage;
import com.automationFramework.pages.LoginPage;
import com.automationFramework.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	CalendarPage calendarpage;
	TestUtil testutil;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void HP(){
		initialization();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String homepagetitle=homepage.homepagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepage title not matched");
	}
	@Test(priority=2)
	public void verifyDisplayNameTest() {
		testutil.switchToFrame();
		boolean dis_name=homepage.validateloginname();
		Assert.assertTrue(dis_name, "loginname is displayed correctly");
	}
	@Test(priority=3)
	public void clickoncontacts() {
		testutil.switchToFrame();
		contactspage=homepage.contactspage();
	}
	@Test(priority=4)
	public void clickoncalendar() {
		testutil.switchToFrame();
		calendarpage=homepage.calendarpage();
	}
		
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
