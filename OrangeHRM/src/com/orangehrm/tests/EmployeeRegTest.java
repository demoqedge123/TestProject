package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.library.OrangeHRMLibrary;

public class EmployeeRegTest 
{
	
	OrangeHRMLibrary hrm=new OrangeHRMLibrary();

	@BeforeMethod
	public void empreg_init()
	{
		hrm.launchApp(hrm.url);
		hrm.adminLogin(hrm.uid, hrm.pwd);
	}
	
	@Test
	public void empregTest()
	{
		boolean res;
		res=hrm.empreg(hrm.fname,hrm.lname);
		Assert.assertTrue(res, "Employee Registration Test Failed");
		
	}
	
	@AfterMethod
	public void empreg_end()
	{
		hrm.logout();
		hrm.closeApp();
	}
	
	
	
	
}
