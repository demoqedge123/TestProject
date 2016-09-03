package com.orangehrm.tests;

import junit.framework.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.library.OrangeHRMLibrary;

public class AdminLoginTest 
{
	OrangeHRMLibrary hrm=new OrangeHRMLibrary();

	@BeforeMethod
	public void adminLogin_init()
	{
		hrm.launchApp(hrm.url);
		
	}
	
	@Test
	public void adminLogin()
	{
		boolean res;
		res=hrm.adminLogin(hrm.uid, hrm.pwd);
		Assert.assertTrue("Admin Login Test Failed", res);
	}
	
	@AfterMethod
	public void adminLogin_End()
	{
		hrm.logout();
		hrm.closeApp();
	}
	
	
}
