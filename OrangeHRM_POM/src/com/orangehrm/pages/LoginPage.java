package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{

	//Define Elements
	
	@FindBy(id="txtUsername") WebElement uid;
	
	@FindBy(name="txtPassword")	WebElement pwd;
	
	@FindBy(xpath="//div[5]/input") WebElement login; 
	
	
	//Define methods
	
	public void adminLogin(String uname,String pword)
	{
		uid.sendKeys(uname);
		pwd.sendKeys(pword);
		login.click();
	}
	
}
