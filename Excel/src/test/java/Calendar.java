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

public class Calendar {


	public static void Date(WebDriver driver, String DateType, String Month_Year, String Day) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		Actions a=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        
        WebElement Scroll = driver.findElement(By.xpath("//*[text() = '"+DateType+"']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Scroll);
        Thread.sleep(2000);
        a.moveToElement(driver.findElement(By.xpath("//label[text()='"+DateType+"']//parent::div/following-sibling::div //*[@class='wd-icon-container']"))).click().build().perform();

        
        
      //Month

        int months=0;

      while (!driver.findElement(By.xpath("//td[@class='datePickerMonth']")).getText().contains(Month_Year))
      {
      	months++;
      	if (months <= 13)	
      	{
      	driver.findElement(By.xpath("//div[starts-with(@class,'datePickerNextButton')]")).click();	}
      	else {
      	driver.findElement(By.xpath("//div[starts-with(@class,'datePickerPreviousButton')]")).click();
      	}		
      }



      //Day

      //List<WebElement> dates = driver.findElements(By.xpath("//div[contains(@class,'datePickerDay') and not(contains(@class, 'Filler')) ]"));
      //int count = driver.findElements(By.xpath("//div[contains(@class,'datePickerDay') and not(contains(@class, 'Filler')) ]")).size();		
      for(int i=0;i<driver.findElements(By.xpath("//div[contains(@class,'datePickerDay') and not(contains(@class, 'Filler')) ]")).size();i++)
      {
      String text  =	driver.findElements(By.xpath("//div[contains(@class,'datePickerDay') and not(contains(@class, 'Filler')) ]")).get(i).getText();
      if(text.equalsIgnoreCase(Day))
      {
      	driver.findElements(By.xpath("//div[contains(@class,'datePickerDay') and not(contains(@class, 'Filler')) ]")).get(i).click();
      	break;
      }
      }
    
}
}