import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_Primary_Job {
	static String task;
	
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver=new ChromeDriver();
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().window().maximize();
	
		
        Login.credentials(driver, "900000019", "Inspire#1");
		
		StartProxy.TeamMember(driver, "George Willard (100148717)");
		
		task = Task.EnterTask(driver, "Switch Primary Job");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Worker']")));
		
		//Team Member
	    inbox.input(driver, "Worker=Allison Beasley (100380554)");
	    
	    driver.findElement(By.xpath("//span[@title = 'OK']")).click();	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Date and Reason']")));
	    
	    //Reason
	    inbox.input(driver, "Reason:Reason=Change in Job Responsibilities");
	    
	    //Effective Date
	    inbox.input(driver, "Effective Date=04/20/2020");
	    
	    //Proposed Primary Job
	    ProposedPrimaryJob(driver, "Trainee Server");
	    
	    //Submit
	    driver.findElement(By.xpath("//*[text()='Submit']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Submit']")));
	
	}
	
	public static void ProposedPrimaryJob(WebDriver driver, String Job) throws InterruptedException
	{
	Actions a=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
	
	        driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, 'Proposed Primary Job')] //*[contains(@class, 'container')]")).click();
	        Thread.sleep(3000);
			driver.findElement(By.xpath("//label[text()='Proposed Primary Job']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 
			a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).build().perform();
			Thread.sleep(500);
			a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).click().build().perform();
		
	}
}