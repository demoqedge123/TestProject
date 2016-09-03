import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class Demotest 
{


	public static void main(String[] args) 
	{
	
	ProfilesIni pr=new ProfilesIni();
	FirefoxProfile fp=new FirefoxProfile();
	fp=pr.getProfile("SeleniumTest");
	WebDriver driver=new FirefoxDriver(fp);
	driver.get("google.com");
	
		

	}

}
