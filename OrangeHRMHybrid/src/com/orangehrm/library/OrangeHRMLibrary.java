package com.orangehrm.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class OrangeHRMLibrary 
{
	public static WebDriver driver;
		
	
	public boolean launchApp(String url,String locator)
	{
		
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		if (driver.findElement(By.xpath(locator)).isDisplayed()) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
	
	public boolean inputData(String locator,String data)
	{
		
		try 
		{
			driver.findElement(By.xpath(locator)).sendKeys(data);
			Assert.assertTrue(true, "Inpud Data Failed");
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
		
	}
	
	
	public boolean clickElement(String locator)
	{
		try 
		{
			driver.findElement(By.xpath(locator)).click();
			return true;
		} catch (Exception e) 
		{
			return false;
		}
	}
	
	
	public boolean checkAdminLogin()
	{
		if (driver.findElement(By.linkText("Welcome Admin")).isDisplayed()) 
		{
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
