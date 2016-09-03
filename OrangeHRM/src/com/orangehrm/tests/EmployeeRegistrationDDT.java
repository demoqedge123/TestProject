package com.orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.library.OrangeHRMLibrary;
import com.orangehrm.utils.XLUtilities;

public class EmployeeRegistrationDDT 
{
	 
	 
 OrangeHRMLibrary hrm=new OrangeHRMLibrary();
 XLUtilities xl=new XLUtilities();
 String xlfile="D:\\Frameworks\\OrangeHRM\\src\\com\\orangehrm\\testdata\\testdata.xlsx";
 String xlsheet="EmpData";
 String resxlfile="D:\\Frameworks\\OrangeHRM\\src\\com\\orangehrm\\results\\testresults.xlsx";
 int rowno=2;
 @BeforeClass
 public void empreg_init()
 {
	 hrm.launchApp(hrm.url);
	 hrm.adminLogin(hrm.uid, hrm.pwd);
 }
 
 @AfterClass
 public void empreg_end()
 {
	 hrm.logout();
	 hrm.closeApp();
 }
 @Test(dataProvider="empdata")
 public void empregddt(String fname,String lname) throws IOException
 {
	 boolean res;
	 String result;
	 
	 res=hrm.empreg(fname, lname);
	 Assert.assertTrue(res, "Employee Registration Failed");
	 if (res) 
	 {
		 result="Pass";
	 } else 
	 {
		 result="Fail";
	 }
	 
	 xl.writeCell(xlfile, xlsheet, resxlfile, rowno, 3, result);
	 rowno++;
	 xlfile=resxlfile;
	 
	 
 }
 
	
 @DataProvider	
 public Object[][] empdata() throws IOException
 {
	
	 int rc;
	 rc=xl.getRowcount(xlfile, xlsheet);
	 
	 Object[][] data=new Object[rc-1][2];
	 for (int i = 2; i <=rc ; i++) 
	 {
		 data[i-2][0]=xl.getCellData(xlfile, xlsheet, i, 1);
		 data[i-2][1]=xl.getCellData(xlfile, xlsheet, i, 2);
	 }
	 return data;
	 
 }
 
 
 
}
