import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Start_Proxy {

	public static void credentials(String Efield) throws IOException
	{
		
	String Login = dataDriven2.getExcelData(Efield, "Field", "Login").get(0);
	String[] LoginSplit = Login.split("=");
	Login = LoginSplit[1];
	LoginSplit = Login.split("&");
	String UserName = LoginSplit[0];
	String Password = LoginSplit[1];
		
System.out.println(UserName);
System.out.println(Password);
		 
	}

}
