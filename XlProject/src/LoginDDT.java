import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT 
{
	XLUtilities xl=new XLUtilities();
	
	@Test(dataProvider="logindata")
	public void logintest(String uid,String pwd)
	{
		System.out.println(uid);
		System.out.println(pwd);
	}
	
	@DataProvider
	public Object[][] logindata() throws IOException
	{
		String xlfile,xlsheet;
		xlfile="d:\\inputdata.xlsx";
		xlsheet="LoginData";
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
