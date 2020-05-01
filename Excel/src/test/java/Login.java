import java.io.IOException;
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

public class Login {

	public static void credentials(WebDriver driver, String Efield) throws IOException
	{
		String Login = inbox.getExcelData(Efield, "Field", "Login").get(0);
		String[] LoginSplit = Login.split("=");
		Login = LoginSplit[1];
		LoginSplit = Login.split("&");
		String UserName = LoginSplit[0];
		String Password = LoginSplit[1];

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		driver.get("https://wd5-impl.workday.com/inspirebrands2/d/home.htmld");	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-automation-id='userName']/input")));
		//System.out.println(isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//div[@data-automation-id='userName']/input"))));
		
		 //UserName
		 driver.findElement(By.xpath("//div[@data-automation-id='userName']/input")).sendKeys(UserName);
	

		 //Password	
		 driver.findElement(By.xpath("//div[@data-automation-id='password']/input")).sendKeys(Password);
		
		//Signin
		// driver.findElement(By.xpath("//button[@data-automation-id='goButton']")).click();
					 
		 
	}

}
