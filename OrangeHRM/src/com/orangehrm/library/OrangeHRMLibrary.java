package com.orangehrm.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRMLibrary 
{
	public static WebDriver driver;
	public String url="http://orangehrm.qedgetech.com";
	public String uid="Admin";
	public String pwd="admin";
	public String fname="smith";
	public String lname="john";
	
	
	public boolean launchApp(String url)
	{
		
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		if (driver.findElement(By.id("btnLogin")).isDisplayed()) 
		{
			return true;
		} else 
		{
			return false;
		}
		
		
	}
	
	
	public boolean adminLogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		if (driver.findElement(By.linkText("Welcome Admin")).isDisplayed()) {
			return true;
		} else 
		{
			return false;
		}
	}

	public boolean logout()
	{
		driver.findElement(By.linkText("Welcome Admin")).click();
		driver.findElement(By.linkText("Logout")).click();
		if (driver.findElement(By.id("btnLogin")).isDisplayed()) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
	
	public void closeApp()
	{
		driver.quit();
	}

	public boolean empreg(String fname,String lname)
	{
		String expres,actres;
		expres=fname+" "+lname;
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("btnSave")).click();
		actres=driver.findElement(By.id("profile-pic")).getText();
		if (expres.equalsIgnoreCase(actres)) 
		{
			return true;
		} else 
		{
			return false;
		}
		
	}
	
	
	
	
	
	
	
}
