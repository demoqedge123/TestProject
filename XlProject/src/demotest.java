import java.io.IOException;


public class demotest
{
	public static void main(String[] args) throws IOException 
	{
	
		
		XLUtilities xl=new XLUtilities();
		xl.setPasscolor("d:\\testdata.xlsx", "EmpData", 2, 3);
		xl.setFailcolor("d:\\testdata.xlsx", "EmpData", 3, 3);

	}

}
