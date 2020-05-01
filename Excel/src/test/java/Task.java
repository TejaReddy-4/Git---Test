import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task {

	public static String EnterTask(WebDriver driver, String task) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions a=new Actions(driver);

		//global search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-automation-id='globalSearchInput']")));
		driver.findElement(By.xpath("//input[@data-automation-id='globalSearchInput']")).clear();
		driver.findElement(By.xpath("//input[@data-automation-id='globalSearchInput']")).sendKeys(task);

	
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='searchInputAutocompletePopup']/div[1]/ul/li")));
				
				int resultsglobalsearch2 = driver.findElements(By.xpath("//*[@data-automation-id='searchInputAutocompletePopup']/div[1]/ul/li")).size();
				for(int i=0; i<resultsglobalsearch2; i++) { 
				String compare23 = driver.findElements(By.xpath("//*[@data-automation-id='searchInputAutocompletePopup']/div[1]/ul/li")).get(i).getText();
				//WebElement compare123 = driver.findElements(By.xpath("//*[@data-automation-id='searchInputAutocompletePopup']/div[1]/ul/li")).get(z2);
				
				if(compare23.contains(task)) {
				a.moveToElement(driver.findElements(By.xpath("//*[@data-automation-id='searchInputAutocompletePopup']/div[1]/ul/li")).get(i)).click().build().perform();
break;
				}

			
			
			
		}
		
		return task;
	}

}
