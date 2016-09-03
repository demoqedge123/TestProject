package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage 
{

	@FindBy(linkText="Welcome Admin") WebElement lnkwelcomeAdmin;
	
	@FindBy(linkText="Logout") WebElement lnklogout;
	
	
	public void logout()
	{
		lnkwelcomeAdmin.click();
		lnklogout.click();
	}
	
	
	
}
