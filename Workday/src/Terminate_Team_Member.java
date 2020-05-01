import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Terminate_Team_Member {
	static String task;
	static String Employee;
	
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver=new ChromeDriver();
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().window().maximize();
	
		
        Login.credentials(driver, "900000019", "Inspire#1");
	
		StartProxy.TeamMember(driver, "George Willard (100148717)");
		
	    task = Task.EnterTask(driver, "Terminate Team Member");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Team Member']")));
	
	    //Team Member
	    Employee = inbox.input(driver, "Team Member=Allana Blackwell (100375513)");
	
		
		driver.findElement(By.xpath("//span[@title = 'OK']")).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Primary Reason']")));		
	    driver.findElement(By.xpath("//label[text() = 'Primary Reason']")).click();	
		Thread.sleep(1500);
		
		//Primary Reason
		inbox.input(driver, "Primary Reason=Accepted Other Employment");
		
		driver.findElement(By.xpath("//label[text() = 'Termination Date']")).click();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Termination Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']")));
		
		//Termination Date
		inbox.input(driver, "Termination Date=04/20/2020");
		
		//Last Day of Work
	    inbox.input(driver, "Last Day of Work=04/20/2020");
		
		//Pay Through Date
		inbox.input(driver, "Pay Through Date=04/20/2020");
		
		//Eligible for Rehire
        Rehire(driver, "Yes");
		
		//Submit
        Submit(driver);
        
       //Inbox Tasks
        inbox.Onboarding(driver, Employee, "Terminate");
	}
	
	public static void ProposedPrimaryJob(WebDriver driver, String Job) throws InterruptedException
	{
	Actions a=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
	
	        driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, 'Eligible for Rehire')] //*[contains(@class, 'container')]")).click();
	        Thread.sleep(3000);
			driver.findElement(By.xpath("//label[text()='Eligible for Rehire']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 
			a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).build().perform();
			Thread.sleep(500);
			a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).click().build().perform();
		
	}

	public static void Rehire(WebDriver driver, String Job) throws InterruptedException
	{
	Actions a=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);		
	
	driver.findElement(By.xpath("//label[text() = 'Eligible for Rehire']")).click();			
	
	driver.findElement(By.xpath("//label[text()='Eligible for Rehire']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 

	a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).build().perform();
	
	a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).click().build().perform();
		
	}	
	public static void Submit(WebDriver driver) throws InterruptedException
	{
	Actions a=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 25);
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);		
	
	
	//Submit
    driver.findElement(By.xpath("//*[text()='Submit']")).click();
    wait.until(ExpectedConditions.or(
    		ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Submit']")),
    		ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Alert')]"))));
    Thread.sleep(2500);
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
    if(driver.findElements(By.xpath("//*[contains(text(),'Alert')]")).size() >0) 
    {if(driver.findElements(By.xpath("//*[text()='Submit']")).size() >0) {
    	driver.findElement(By.xpath("//*[text()='Submit']")).click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Submit']")));}		
	}}
}		