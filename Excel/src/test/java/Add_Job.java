import java.io.IOException;
import java.util.ArrayList;
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

public class Add_Job {
	static String task="Add Job";
	static int min;
	static int max;
	static int random_int;
	static String Employee;
	static String nextAwaitingStep = Employee;
	static String nextAwaitingStep1="D$mmy Var!able";
	static WebElement inbox_list;
	static int nextstep=1;
	static String[] field1;
	static String input;
	static String field;
	static String fieldm[];
	static String field12;
	static String field13;
	static String field4;
	static String input4;
	static String[] fieldn3;
	static String field3;
	static String input3;
	static String[] fieldn2;
	static String[] fieldn;
	static String Person2;
	static String onBehalfOf22;
	static String[] onBehalfOf12;
	static String onBehalfof2;
	static int ghj=0;
	static String UpNext;
	static String[] inboxselection;
	static String ListoftasksAwaiting1;
	static List<String> ListoftasksAwaiting=new ArrayList<String>();
	static ArrayList<String> Enter1 =new ArrayList<String>();
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver=new ChromeDriver();
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().window().maximize();

		
		
		Login.credentials(driver, "Add Job");
		
		StartProxy.TeamMember(driver, "Add Job");
		
		task = Task.EnterTask(driver, "Add Job");

		//Supervisory Organization
		inbox.SupervisoryOrganization(driver, "Add Job","Supervisory Organization");
		
		//Team Member
		Employee=input(driver, "Add Job", "Team Member");

		
		//OK
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		
		//Effective Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Effective Date']")));
		input(driver, "Add Job", "Effective Date");
		
		//Reason
	    input(driver, "Add Job", "Reason");
		
	    //Job Requisition(If Available)
		//input(driver, "Job Requisition=JRARB748");
		
	    //Position(If Available)
		input(driver, "Add Job", "Position");

		//Team Member Type
		input(driver, "Add Job","Team Member Type");
		
		//Job Profile
		input(driver, "Add Job", "Job Profile");

		//Time Type
		input(driver, "Add Job", "Time Type");
		
		//Location
		input(driver, "Add Job", "Location");
		
		//Submit
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Submit']")));
		
		
		//Inbox Tasks
		inbox.Onboarding(driver, "Add Job", Employee, task);
	}
	
	
	
	public static String input(WebDriver driver, String Efield, String Efield2) throws InterruptedException, IOException 
	   {
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	Actions a=new Actions(driver);

	Enter1 = inbox.getExcelData(Efield, "Field", Efield2);
	if(Enter1.size() == 0) {}
		else {
		
			   int ctr=0;
			   for(String i: Enter1) {
				  // if (ctr>0) {
				   field1= i.split("=");
				  field=  field1[0];
				input= field1[1];
			 
				   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				   
				   
			 if(driver.findElements(By.xpath("//*[text()='"+field+"']")).size()>0)
				   { WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
					   
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
					   
					   Boolean h = false;
						 while(h==false)
						 {
							h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field+"']")));
						 }
				   }
				    
				   if(field.equalsIgnoreCase("Team Member Type")) {driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);}
				   else {driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);}   
					   				  
		
		//----------------------------------------inputbox-----------------------------------------------------------------------				   
				   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).size()>0) {
						
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).clear();
					   Thread.sleep(2000);
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(input);
					}
				   
	//----------------------------------------searchbox-----------------------------------------------------------------------				   		   
				   else if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).size()>0) {
					   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div/following-sibling::div/ul/li")).size()>0) 
					   {
						   String Value =driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div[1]/following-sibling::div/ul/li")).getText();
						   if(Value.equalsIgnoreCase(input)) {}        
					         else {driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //*[@data-automation-id='DELETE_charm']")).click();
					       

							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
								
								   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(input, Keys.ENTER);
							
								   
								   //wait time
							if (field.equalsIgnoreCase("Position")) {	   
							try { 	WebDriverWait wait1 = new WebDriverWait(driver, 8);
								wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
							catch(Exception e) { WebDriverWait wait2 = new WebDriverWait(driver, 7);
								wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
							
							else {try { 	WebDriverWait wait3 = new WebDriverWait(driver, 4);
							wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='selectedItem']")));}
						catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 5);
							wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
							
								//Reselecting the option   
							driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@role='listbox' and @tabindex='-1'] //*[@data-automation-id='selectedItem']")).size()>0) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='selectedItem']")).click();}
				
							else { Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@aria-label='Search Results'] //*[contains(@data-automation-label, '"+input+"')]")).click();          }
					         }
						  
						   }
					  
					   else {
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
						
						   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(input, Keys.ENTER);
					
						   
						   //wait time
					if (field.equalsIgnoreCase("Position")) {	   
					try { 	WebDriverWait wait1 = new WebDriverWait(driver, 8);
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
					catch(Exception e) { WebDriverWait wait2 = new WebDriverWait(driver, 7);
						wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
					
					else {try { 	WebDriverWait wait3 = new WebDriverWait(driver, 5);
					wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='selectedItem']")));}
				catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 5);
					wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
					
					
						//Reselecting the option   
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@role='listbox' and @tabindex='-1'] //*[@data-automation-id='selectedItem']")).size()>0) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='selectedItem']")).click();}
	              
					else { 
						driver.findElement(By.xpath("//*[@aria-label='Search Results'] //*[contains(@data-automation-label, '"+input+"')]")).click();          }}}  

	//------------------------------------------------------Calendar---------------------------------------------------				
				   
				   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				   if(driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).size()>0) 
			        {
						   driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).click(); 
						   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@class='wd-icon-container']")));
						   Thread.sleep(1000); 
					   
					 if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']")).size()>0) 
				        {
			        	String[] spaces = input.split("/"); 
			        	String Month= spaces[0];
			        	String Day = spaces[1];
			        	String year = spaces[2];
			        
			        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).click().sendKeys(Month).build().perform();
			        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionDay']"))).click().sendKeys(Day).build().perform();
			        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionYear']"))).click().sendKeys(year).build().perform();
			        
				        }
			        }
				   
				   
				   else if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']")).size()>0) 
			        { 
			        	String[] spaces = input.split("/"); 
			        	String Month= spaces[0];
			        	String Day = spaces[1];
			        	String year = spaces[2];
			        
			        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).click().sendKeys(Month).build().perform();
			        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionDay']"))).click().sendKeys(Day).build().perform();
			        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionYear']"))).click().sendKeys(year).build().perform();  
			        }
					
			//--------------------------------------------------------CheckBox----------------------------------------------------------------	   
				   if (driver.findElements(By.xpath("//label[text()='"+field+"']/parent::div/following-sibling::div/div/div/div")).size()>0)				   
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//label[text()='"+field+"']/parent::div/following-sibling::div/div/div/div")));
				   {    if(input.equalsIgnoreCase("Check")) {
					   if (driver.findElements(By.xpath("//label[text()='"+field+"']/parent::div/following-sibling::div/div //*[@data-automationcheckboxchecked='true']")).size()>0)	{}			   
					   else {Thread.sleep(1000);  driver.findElement(By.xpath("//label[text()='"+field+"']/parent::div/following-sibling::div/div/div/div")).click();}
				         }
				   if(input.equalsIgnoreCase("UnCheck")) {
					   if (driver.findElements(By.xpath("//label[text()='"+field+"']/parent::div/following-sibling::div/div //*[@data-automationcheckboxchecked='false']")).size()>0)	{}			   
					   else {Thread.sleep(1000);  driver.findElement(By.xpath("//label[text()='"+field+"']/parent::div/following-sibling::div/div/div/div")).click();}
				         }
				 
				   }
				   
				   
				     
				   
				 // }//if ctr>0
				   ctr++;
	  		   }//for-each	   
			    
		}

	return input; 

	   }		
}
