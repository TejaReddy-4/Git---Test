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

import com.google.common.collect.Iterables;

public class preHire {
static String task;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
WebDriver driver=new ChromeDriver();
Actions a=new Actions(driver);
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 25);
driver.manage().window().maximize();



Login.credentials(driver, "900000019", "Inspire#1");

StartProxy.TeamMember(driver, "Jen Christy (1547682)");

task = Task.EnterTask(driver, "Create Pre-Hire");

input(driver, "Legal information", "First Name=Test", "Last Name=Test");                                                                                                                                               driver.findElement(By.xpath("//*[text()= 'Contact Information']")).click();

input(driver, "Phone", "Phone Number=7245681236","Type=Home");

input(driver, "Address", "Address Line 1=Morris Rd","City=Alpharetta", "State=Georgia", "Postal Code=30005", "Type=Home");

input(driver, "Email", "Email Address=test@test.com","Type=Home");

                                                                                                                                                                                                                       driver.findElement(By.xpath("//*[@title = 'OK']")).click(); wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[title = 'Done']"))); driver.findElement(By.xpath("//*[@title = 'Done']")).click();






















	}
	
	
public static void input(WebDriver driver, String... Enter) throws InterruptedException 
	   {
		

		if (Enter.length >=2) {
			
			if(driver.findElements(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/following-sibling::button")).size()>0) {
				
				driver.findElement(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/following-sibling::button")).click();
			}}
			
		
		
		if(Enter.length == 0) {}
		else {
			
			   int ctr=0;
			   for(String i: Enter) {
				   if (ctr>0) {
				   String[] field1= i.split("=");
				   String field=  field1[0];
				   String input= field1[1];
				   
				   if(driver.findElements(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/parent::div //*[text()='"+field+"']")).size()>0) {
				   WebElement Task = driver.findElement(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/parent::div //*[text()='"+field+"']"));
				   
				   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);}
				   
				   else { WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
					   
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);}   
				   
				   
				   
				   
				   if(field.contains("Type")) { 
					   
					   driver.findElement(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/parent::div //*[text()='"+field+"']/parent::div/parent::li //*[@placeholder='Search']")).click();
					   driver.findElement(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/parent::div //*[text()='"+field+"']/parent::div/parent::li //*[@placeholder='Search']")).sendKeys(input);
					   
				   }
				   else {
				   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).size()>0) {
						
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).clear();
					   Thread.sleep(2000);
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(input);
					}
				   
				   
				   else if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div/input")).size()>0) {
						
                           driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div/input")).click();
						
						   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div/input")).sendKeys(input, Keys.ENTER);
					
									
						Thread.sleep(500);
					if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
						
						driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
                     
					else { driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }}}   
	
					
					
					
					
					
				   }//if ctr>0
				   ctr++;
			   }//for-each	   

		}}
	    	
public static void inputBox(WebDriver driver, String field, String enter) throws InterruptedException 
	   {
		   WebDriverWait wait = new WebDriverWait(driver, 20);
		   WebElement Scroll = driver.findElement(By.xpath("//*[text() = '"+field+"']"));
		   //a.moveToElement(Scroll).perform();
		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Scroll);
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")));
		   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).clear();
		   Thread.sleep(1500);
		   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(enter);
	   }  

public static void searchBox(WebDriver driver, String field, String enter) throws InterruptedException
{
	   WebDriverWait wait = new WebDriverWait(driver, 20);
	   Actions a=new Actions(driver);
	   
	   Thread.sleep(1000);
	   WebElement Scroll = driver.findElement(By.xpath("//*[text() = '"+field+"']"));
	   //a.moveToElement(Scroll).perform();
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Scroll);
	   
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div/input")).click();
	   
	   if (field.contains("Worker Type")){		   
		   driver.findElement(By.xpath("//*[contains(text(),'"+enter+"')]")).click();
		   driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+enter+"')]")).click();
		   
	   } else if (field.contains("Job Profile")) {    
	   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div/input")).sendKeys(enter, Keys.ENTER);
	   driver.findElement(By.xpath("//*[contains(text(),'"+enter+"')]")).click();
	   driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+enter+"')]")).click();
	   

	   } else {
		   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div/input")).sendKeys(enter, Keys.ENTER);
		   try
		   {
			   Thread.sleep(1000);
		   if (driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+enter+"')]")).isDisplayed() == true)
		   {
			   driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+enter+"')]")).click();
		   }}
		   catch (Exception e) {
			   Thread.sleep(1000);
			   driver.findElement(By.xpath("//*[contains(text(),'"+enter+"')]")).click();
			   //3
		   }
	   }
	   }
	   
}

