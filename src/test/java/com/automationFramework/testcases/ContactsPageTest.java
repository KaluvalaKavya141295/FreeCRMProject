package com.automationFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationFramework.base.TestBase;
import com.automationFramework.pages.ContactsPage;
import com.automationFramework.pages.HomePage;
import com.automationFramework.pages.LoginPage;
import com.automationFramework.util.TestUtil;

public class ContactsPageTest extends TestBase{
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	String sheetName="Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void contacts() {
		initialization();
		homepage=new HomePage();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		homepage.contactspage();
		
	}
	@Test(priority=1)
	public void verifycontactsTest() {
		//testutil.switchToFrame();
		boolean cont_page=contactspage.verifycontactpage();
		Assert.assertTrue(cont_page, "user is in contacts page");
	}
/*	@Test(priority=2)
	public void ckeckboxTest() {
		contactspage.verifycheckbox("Divya Goyal");
	}
	@Test(priority=3)
	public void verify2checkboxesTest() {
		contactspage.verifycheckbox("Divya Kannan");
		contactspage.verifycheckbox("cvvcv sdsdsd");
	}*/
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=4, dataProvider="getCRMTestData")
	public void newcontactlinkTest(String title, String firstname, String lastname, String companyname) {
		homepage.clickOnNewContactLink();
		//contactspage.newcontactlink("Miss", "Kalu", "Kav", "Insearch");
		contactspage.newcontactlink(title, firstname, lastname, companyname);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
