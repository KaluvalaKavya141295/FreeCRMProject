package com.automationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationFramework.base.TestBase;

public class SignUPPage extends TestBase{
	@FindBy(id="payment_plan_id")
	WebElement paymenttype;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement lastname;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="email_confirm")
	WebElement confirmemail;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="passwordconfirm")
	WebElement confirmpwd;
	
	@FindBy(name="agreeTerms")
	WebElement agreecheckbox;
	
	@FindBy(id="submitButton")
	WebElement reg_submit;
	
	
	

}
