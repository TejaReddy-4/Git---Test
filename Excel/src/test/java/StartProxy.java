import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartProxy {

//public static String ProxyName;
//static String ProxyName;
	public static void TeamMember(WebDriver driver, String Efield) throws IOException {
		
		String StartProxy = inbox.getExcelData(Efield, "Field", "Start Proxy").get(0);
		String[] StartProxySplit = StartProxy.split("=");
		String ProxyName = StartProxySplit[1];
		
		
	
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		Actions a=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
//Global Search
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-automation-id='globalSearchInput']")));
driver.findElement(By.xpath("//input[@data-automation-id='globalSearchInput']")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
driver.findElement(By.xpath("//input[@data-automation-id='globalSearchInput']")).sendKeys( ProxyName, Keys.ENTER);


//Start Proxy
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-automation-label, '"+ProxyName+"')]")));
String Employee_Status = driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+ProxyName+"')]")).getText();

//if (Employee_Status.contains("Terminated"))  
//{
//	System.out.println("Employee is Terminated");

//}
driver.findElement(By.xpath("//img[contains(@aria-label, '"+ProxyName+"')]")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-automation-id='popUpDialog']")));


WebElement Security_profile = driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"));


a.moveToElement(Security_profile).build().perform();

WebElement Start_proxy = driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"));
//a.moveToElement(Security_profile).click(Start_proxy).build().perform();
a.moveToElement(Start_proxy).click().build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")));
driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();



}

}