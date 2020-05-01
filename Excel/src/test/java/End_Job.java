import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class End_Job {
	static String task;
	static String TeamMember;
	static String Reason;
	static String EndDate;
	static int AdditionalJobs;
	static int j=0;
	static int k=0;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver=new ChromeDriver();
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().window().maximize();
	
//---------------------------------------------------------------------------------------------------------------------------------------		
       
		
		
		Login.credentials(driver, "End Job");
		
		StartProxy.TeamMember(driver, "End Job");
		
		task = Task.EnterTask(driver, "End Additional Job");                                                                                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Team Member']")));
		
		//Team Member
	    TeamMember = inbox.input(driver, "End Job","Team Member");
	    
	    //Job
	    Job(driver);                                                                                                                                           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='End Date']")));
	    
	    //End Date
	    EndDate=inbox.input(driver, "End Job", "End Date");
	    
	    //Reason
	    Reason = inbox.input(driver, "End Job","Reason");
	    
 
	                                                                                                                                                                   driver.findElement(By.xpath("//*[text()='Submit']")).click();  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Submit']"))); Job(driver);

	                                                                                                                                                                   
	                                                                                                                                                                   
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	
	}
	


	public static void Job(WebDriver driver) throws InterruptedException, IOException
	{
	Actions a=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
	
	String Job1 = inbox.getExcelData("End Job", "Field", "Job").get(0);
	String[] JobSplit = Job1.split("=");
	String Job = JobSplit[1];

	
		if(Job.contains("All") || Job.equalsIgnoreCase("All")) 
		{
			if(j>0) { 
			 for(int i=1; i<AdditionalJobs; i++) 
			 {
				 if(j==1) { 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Home']/div/img")));
				Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@title='Home']/div/img")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Home']/div/img")));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
				 }	 
				 task = Task.EnterTask(driver, "End Additional Job");
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Team Member']")));

				    inbox.input(driver, "End Job", "Team Member");
				    if(i+1<AdditionalJobs) {
				    driver.findElement(By.xpath("//label[text()='Job']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 
				    Thread.sleep(1000); 
				    a.moveToElement(driver.findElement(By.xpath("//*[@aria-label='Job'] //div[@data-automation-id='promptOption']"))).build().perform();
				    Thread.sleep(500);  
				    a.moveToElement(driver.findElement(By.xpath("//*[@aria-label='Job'] //div[@data-automation-id='promptOption']"))).click().build().perform();
				    Thread.sleep(1000); }
					driver.findElement(By.xpath("//*[@title = 'OK']")).click();	
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='End Date']")));
				    inbox.input(driver, "End Job", "End Date=");
				    inbox.input(driver, "Reason","Reason");
				    driver.findElement(By.xpath("//*[text()='Submit']")).click();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Submit']"))); 
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Home']/div/img")));
					Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@title='Home']/div/img")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Home']/div/img")));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
			System.out.println(i); }
		}
			else {
				if(k==0) {
				driver.findElement(By.xpath("//label[text()='Job']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 
				Thread.sleep(1000); 
				AdditionalJobs = driver.findElements(By.xpath("//*[@aria-label='Job'] //div[@data-automation-id='promptOption']")).size();
				a.moveToElement(driver.findElement(By.xpath("//*[@aria-label='Job'] //div[@data-automation-id='promptOption']"))).build().perform();
				    Thread.sleep(500);  
				    a.moveToElement(driver.findElement(By.xpath("//*[@aria-label='Job'] //div[@data-automation-id='promptOption']"))).click().build().perform();
				    Thread.sleep(1000);
				    driver.findElement(By.xpath("//*[@title = 'OK']")).click();	
					j++;   k++;}}
		
		}
		else {
			if(j==0) {
			driver.findElement(By.xpath("//label[text()='Job']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 
			Thread.sleep(800); 
			a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).build().perform();
			Thread.sleep(500);
			a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).click().build().perform();
			Thread.sleep(1000); 
	
		driver.findElement(By.xpath("//*[@title = 'OK']")).click();	
			j++;}
		}
	}


		
	
}
