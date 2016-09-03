package com.orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.library.OrangeHRMLibrary;
import com.orangehrm.utils.XLUtilities;

public class KeywordDrivenTest 
{

	OrangeHRMLibrary hrm=new OrangeHRMLibrary();
	XLUtilities xl=new XLUtilities();
	
	@Test
	public void keywordtest() throws IOException
	{
		int tccount,tscount;
		String keywordsxlfile,tcsheet,tssheet,resultsxlfile;
		String tcexeflg,tcid,tstcid,keyword,tsres,tcres;
		boolean res=false;
		
		keywordsxlfile="D:\\Frameworks\\OrangeHRM\\src\\com\\orangehrm\\keywords\\Keywords.xlsx";
		resultsxlfile="D:\\Frameworks\\OrangeHRM\\src\\com\\orangehrm\\results\\keywordtestresults.xlsx";
		tcsheet="TestCases";
		tssheet="TestSteps";
		tccount=xl.getRowcount(keywordsxlfile,tcsheet);
		tscount=xl.getRowcount(keywordsxlfile, tssheet);
		for (int i = 2; i <=tccount ; i++) 
		{
			tcexeflg=xl.getCellData(keywordsxlfile, tcsheet, i, 3);
			if (tcexeflg.equalsIgnoreCase("Y")) 
			{
				tcid=xl.getCellData(keywordsxlfile, tcsheet, i, 1);
				for (int j = 2; j <= tscount; j++) 
				{
					tstcid=xl.getCellData(keywordsxlfile, tssheet, j, 1);
					if (tcid.equalsIgnoreCase(tstcid)) 
					{
						keyword=xl.getCellData(keywordsxlfile, tssheet, j, 5);
						switch (keyword) 
						{
						case "LaunchApp":
							res=hrm.launchApp(hrm.url);
							break;
						case "AdminLogin":	
							res=hrm.adminLogin(hrm.uid, hrm.pwd);
							break;
						case "Logout":
							res=hrm.logout();
							    hrm.closeApp();
							break;
						case "EmpReg":
							res=hrm.empreg(hrm.fname, hrm.lname);
						}
						if (res) 
						{
							tsres="Pass";
						} else 
						{
							tsres="Fail";
						}
						xl.writeCell(keywordsxlfile, tssheet, resultsxlfile, j, 4, tsres);
						tcres=xl.getCellData(keywordsxlfile, tcsheet, i, 4);
						if (!tcres.equalsIgnoreCase("FAIL")) 
						{
							tcres=tsres;
							xl.writeCell(keywordsxlfile, tcsheet, resultsxlfile, i, 4, tcres);
							keywordsxlfile=resultsxlfile;
						}
						
					}
				}
			} else 
			{
				xl.writeCell(keywordsxlfile, tcsheet, resultsxlfile, i, 4, "Blocked");
			
			}
			
		}
		
		
		
	}
	
	
	
}
