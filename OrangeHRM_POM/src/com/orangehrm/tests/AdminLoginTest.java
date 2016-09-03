package com.orangehrm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminHomePage;
import com.orangehrm.pages.LoginPage;

public class AdminLoginTest 
{

	public static WebDriver driver;
	
	@BeforeMethod
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com");		
	}
	
	@Test
	public void logintest()
	{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);	
		AdminHomePage home=PageFactory.initElements
											(driver, AdminHomePage.class);
		
		lp.adminLogin("Admin", "admin");
		home.logout();
	}
	
	
	
	
}
