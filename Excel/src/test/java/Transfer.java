import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

public class Transfer {
	static String task;
	static String onBehalfOf22;
	static String[] onBehalfOf12;
	static String onBehalfof2;
	static String ManagerChangeJob;
	static String EmployeeChangeJob;
	static WebElement inbox_list;
	static String nextAwaitingStep = EmployeeChangeJob;
	static String nextAwaitingStep1;
	static String ChangeJob;
	static int min;
	static int max;
	static int random_int;
	static String Employee;
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
	static String UpNext;
	static String[] fieldn2;
	static String[] fieldn;
	static String Person2;
	static int ghj=0;
	static String[] inboxselection;
	static String ListoftasksAwaiting1;
	static List<String> ListoftasksAwaiting=new ArrayList<String>();
	static ArrayList<String> Enter1 =new ArrayList<String>();
	static int HomelandingPage=1;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver=new ChromeDriver();
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().window().maximize();

		
		
		Login.credentials(driver, "Transfer");
		
		StartProxy.TeamMember(driver, "Transfer");
		
		task = Task.EnterTask(driver, "Change Job");
			
		//Worker
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Change Job']")));
		Thread.sleep(1000);
		EmployeeChangeJob = inbox.input(driver, "Transfer","Worker");
		driver.findElement(By.xpath("//*[@title = 'OK']")).click();
		
		//Job
		Job(driver);
		
		//Start
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Edit Start Details'] //*[@class='wd-icon-container']")));
		driver.findElement(By.xpath("//*[@aria-label='Edit Start Details'] //*[@class='wd-icon-container']")).click();
		Thread.sleep(1500);
		inbox.input(driver, "Transfer","When do you want this change to take effect?");
		
		//ChangeJob Type
		ChangeJob = ChangeJob(driver);
			
		//Who will be the manager after this change?
		ManagerChangeJob = inbox.input(driver, "Transfer","Who will be the manager after this change?");
		
		//Which team will this person be on after this change?
		inbox.SupervisoryOrganization(driver, "Transfer", "Which team will this person be on after this change?");

		//Where will this person be located after this change?
		inbox.input(driver, "Transfer", "Where will this person be located after this change?");
		
		//Do you want to use the next pay period?
		inbox.input(driver, "Transfer","Do you want to use the next pay period?");
		driver.findElement(By.xpath("//button[@title = 'Start']")).click();
		
		Boxes1(driver);
		
	
		//Onboarding
		//Onboarding(driver, "Transfer", Employee, task);
		

		 
	}

	
public static String ChangeJob(WebDriver driver) throws IOException
	   {
	Actions a=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	
	String ChangeJobS1 = inbox.getExcelData("Transfer", "Field", "Change Job").get(0);
	String[] ChangeJobS2 = ChangeJobS1.split("=");
	String ChangeJobS3 = ChangeJobS2[1];
	
	ChangeJobS2 = ChangeJobS3.split("&");
	String ChangeJob  = ChangeJobS2[0];
	String Type = ChangeJobS2[1];
	
	driver.findElement(By.xpath("//label[text()='Why are you making this change?']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
	a.moveToElement(driver.findElement(By.xpath("//*[@data-automation-label = '"+ChangeJob+"']"))).click().build().perform();
	 a.moveToElement(driver.findElement(By.xpath("//*[@data-automation-label = '"+Type+"']"))).click().build().perform();
	 
	 return ChangeJob;
       }  	
	
public static void Job(WebDriver driver) throws InterruptedException, IOException
{
Actions a=new Actions(driver);
WebDriverWait wait = new WebDriverWait(driver, 5);
driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		

String Job = inbox.getExcelData("Transfer", "Field", "Job").get(0);
String[] JobSplit = Job.split("=");
Job = JobSplit[1];

if(driver.findElements(By.xpath("//label[text()='Job']")).size()>0) {
	if(Job.equalsIgnoreCase("Primary")) 
	{driver.findElement(By.xpath("//label[text()='Job']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 
	a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-id, 'promptOption') and not(contains(@data-automation-label, '+'))]"))).build().perform(); 
	Thread.sleep(500);
	a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-id, 'promptOption') and not(contains(@data-automation-label, '+'))]"))).click().build().perform(); }
	else  {
		driver.findElement(By.xpath("//label[text()='Job']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click(); 
		a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).build().perform();
		Thread.sleep(500);
		a.moveToElement(driver.findElement(By.xpath("//div[contains(@data-automation-label, '"+Job+"')]"))).click().build().perform();
	}
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[@title = 'OK']")).click();	
}
else {}

} 	

public static void Position(WebDriver driver, String Position) throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Position']")));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, 'Position')] //*[contains(@class, 'container')]")));
	driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, 'Position')] //*[contains(@class, 'container')]")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	try {driver.findElement(By.xpath("//label[text()='Position']//parent::div/parent::li/following-sibling::li //input")).sendKeys(Position, Keys.ENTER);}
	catch(Exception Positionexception) {driver.findElement(By.xpath("//*[text()='Position']/parent::div/following-sibling::div //input")).sendKeys(Position, Keys.ENTER);}

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='DELETE_charm']")));	

} 


public static void Manager(WebDriver driver) throws InterruptedException

{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	 Actions a=new Actions(driver);
	 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

	 
	 //Process Successfully Completed
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));
	   if (driver.findElements(By.xpath("//div[text()='Process Successfully Completed']")).size()>0) {return;}	
	   
	   
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();
		ManagerChangeJob = ManagerChangeJob.trim();
		
		if(ManagerChangeJob.equalsIgnoreCase(onBehalfof2) || ManagerChangeJob.contains(onBehalfof2) || onBehalfof2.contains("Jen Christy (1547682)") || onBehalfof2.contains("Heather Link (1547634)")) 
		{if (driver.findElements(By.xpath("//label[text()='What do you want to do with the opening left on your team?']")).size()>0) 
		 { driver.findElement(By.xpath("//*[text()='Next']")).click();}}  */
		
	

			//if (driver.findElements(By.xpath("//label[text()='What do you want to do with the opening left on your team?']")).size()>0) 
			 //{ driver.findElement(By.xpath("//*[text()='Next']")).click();}
			 
           // driver.findElement(By.xpath("//*[text()='Submit']")).click();
           // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Submit']"))));
            //Thread.sleep(1500);
            
            //driver.findElement(By.xpath("//button[@title='Home']/div/img")).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-automation-id='globalSearchInput']")));
            //Thread.sleep(1500);
            
            //StartProxy.TeamMember(driver, ManagerChangeJob);
			
	   if (driver.findElements(By.xpath("//*[text()='Submit']")).size()>0) {
            driver.findElement(By.xpath("//*[text()='Submit']")).click();
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Submit']"))));
            Thread.sleep(1000);}
            
            
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-automation-id='inbox_preview']/div")));	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));
			Thread.sleep(2000);
	
			if(driver.findElements(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/img")).size()>0) 
			{
				UpNext = driver.findElement(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/div/div/div/div")).getText();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
				onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
				onBehalfOf12= onBehalfOf22.split(":");
				onBehalfof2 =  onBehalfOf12[1].trim();
			
				driver.findElement(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/img")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-automation-id='popUpDialog']")));


			WebElement Security_profile = driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"));


			a.moveToElement(Security_profile).build().perform();

			WebElement Start_proxy = driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"));
			//a.moveToElement(Security_profile).click(Start_proxy).build().perform();
			a.moveToElement(Start_proxy).click().build().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")));
			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			nextAwaitingStep= EmployeeChangeJob;
			nextAwaitingStep1=ChangeJob;    }  
			
			
			
else {
		driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));
		//inbox_list = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));
		
		nextAwaitingStep= EmployeeChangeJob;
		nextAwaitingStep1=ChangeJob;
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

		else if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task
		
System.out.println(nextAwaitingStep);		
		
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 


//Archive
Thread.sleep(1500);
try{driver.findElement(By.xpath("//*[contains(text(), 'Archive')]")).click();}
catch(Exception num10) {driver.findElement(By.xpath("//*[contains(text(), 'Archive')]")).click();}
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));


driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
Thread.sleep(1000);

try {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']"))).click().build().perform();}
catch(Exception ede) {Thread.sleep(1000);
	a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']"))).click().build().perform();}

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-inbox-detail-frosting='false']")));


//Overall Process
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-automation-id, 'inbox_task_view') and @data-automation-inbox-detail-frosting='false']")));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")));
Thread.sleep(2000);
//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']"))));
try {driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")).click();}
catch(Exception ede) {Thread.sleep(1000);
driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")).click();}


wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent']")));
WebElement TabContent2 = driver.findElement(By.xpath("//*[@data-automation-id='tabContent']"));

WebElement Process2 = driver.findElement(By.xpath("//*[text() = 'Process']"));

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Process2);
Thread.sleep(2000);

wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]"))));
Thread.sleep(2000);
try {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}
catch(Exception eccs) {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}


//Awaiting Action
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent'and @aria-label='Process'] ")));
//TabContent.findElement(By.xpath("//*[text()='Awaiting Action']"));

Thread.sleep(2000);
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();

if(nextstep == 0) {return;}

((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));

Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
onBehalfOf12= onBehalfOf22.split(":");
onBehalfof2 =  onBehalfOf12[1].trim();   
nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();


driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
			
}


//Inbox
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-automation-id='inbox_preview']/div")));	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));
Thread.sleep(2000);



driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));
inbox_list = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));

try {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}
catch(Exception jki) {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-inbox-detail-frosting='false']")));


//---------------------------------Inbox Tasks--------------------------------------------------
WebDriverWait waitBoxes = new WebDriverWait(driver, 3);
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

waitBoxes.until(ExpectedConditions.or(
	    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Submit']")),
	   ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Done']")),
	    ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-automation-id='thirdPartyConnection']")),
	    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Approve']")),
	    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Next']")),
	    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='OK']"))));

Thread.sleep(2000);


} 

public static void Onboarding(WebDriver driver, String Efield, String Employee,  String task) throws InterruptedException, IOException 
		{
			   
			   WebDriverWait wait = new WebDriverWait(driver, 25);
			   Actions a=new Actions(driver);
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 	
			   //Process Successfully Completed
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));
			   if (driver.findElements(By.xpath("//div[text()='Process Successfully Completed']")).size()>0) {return;}		
			   
			   nextAwaitingStep= EmployeeChangeJob;
				nextAwaitingStep1=ChangeJob;
			   
				Enter1 = inbox.getExcelData(Efield, Efield, Efield+" "+"-"+"Task");
			   System.out.println(Enter1);

			   nextAwaitingStep1= "D$mmy Var!able";
			   
			   
nextstep = 1;
		while (nextstep != 0) {
		//inbox
			
			UpNext = "Default";
			if(driver.findElements(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/img")).size()>0) 
			{UpNext = driver.findElement(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/div/div/div/div")).getText();}

			if(HomelandingPage  == 1) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Home']/div/img")));
				Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@title='Home']/div/img")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Home']/div/img")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
			HomelandingPage++;}
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-automation-id='inbox_preview']/div")));	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));
			Thread.sleep(500);

			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 	
		
		driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();
		
	

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));
		inbox_list = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));


		//nextAwaitingStep = Employee;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

		else if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

		else {String[] inboxselection= nextAwaitingStep1.split(" ");                                                           // task separeated by space
		for(String d:inboxselection) {
			nextAwaitingStep=d;
			if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']")).size()>0)
			{ break;}			
		}
		}

		System.out.println(nextAwaitingStep + "= NullPointerException");
		
		if(nextAwaitingStep.equals("Var!able")) {}
		 else {


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 


		try {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}
		catch(Exception jki) {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-inbox-detail-frosting='false']")));


		//---------------------------------Inbox Tasks--------------------------------------------------
		WebDriverWait waitBoxes = new WebDriverWait(driver, 3);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		waitBoxes.until(ExpectedConditions.or(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Submit']")),
			   ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Done']")),
			    ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-automation-id='thirdPartyConnection']")),
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='OK']"))));

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();
		
		System.out.println(UpNext);
		if(onBehalfof2.contains(UpNext) || onBehalfof2.equalsIgnoreCase(UpNext)) {Boxes(driver);}
		
		if(UpNext =="Default") {Boxes(driver);}
		
		 }

	
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//----------------------------------------------Archive--------------------------------
		//Inox	   
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));	
		//driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));

		WebElement inbox_list_Archive2 = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));
		//Archive
		Thread.sleep(1500);
		try{driver.findElement(By.xpath("//*[contains(text(), 'Archive')]")).click();}
		catch(Exception num10) {driver.findElement(By.xpath("//*[contains(text(), 'Archive')]")).click();}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));


		nextAwaitingStep= EmployeeChangeJob;
		nextAwaitingStep1=ChangeJob;
		
		//choosing the task
		//nextAwaitingStep = Employee;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

		else if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

		else {inboxselection= nextAwaitingStep1.split(" ");    // task separeated by space

		for(String d:inboxselection) {
			nextAwaitingStep=d;
			
			if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']")).size()>0)
			{ break;}			
		}
		}

		System.out.println("Acrchive ="+nextAwaitingStep+" ");;


		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);

		try {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']"))).click().build().perform();}
		catch(Exception ede) {Thread.sleep(1000);
			a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']"))).click().build().perform();}


		WebElement ArchiveTest=inbox_list_Archive2.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"));

		System.out.println("ArchiveTest = "+ArchiveTest);

		//Overall Process
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-automation-id, 'inbox_task_view') and @data-automation-inbox-detail-frosting='false']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")));
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']"))));
		try {driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")).click();}
		catch(Exception ede) {Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")).click();}


		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent']")));
		WebElement TabContent2 = driver.findElement(By.xpath("//*[@data-automation-id='tabContent']"));

		WebElement Process2 = driver.findElement(By.xpath("//*[text() = 'Process']"));

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Process2);
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]"))));
		Thread.sleep(2000);
		try {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}
		catch(Exception eccs) {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}


		//Awaiting Action
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent'and @aria-label='Process'] ")));
		//TabContent.findElement(By.xpath("//*[text()='Awaiting Action']"));

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();



		if(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()==0) {
			    if(driver.findElements(By.xpath("//*[text()='In Progress']")).size()>0) {
      				
 			    	 if(driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size()>0)
 			    	 {
 			    		//start proxy
 			 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='In Progress']")));
 			 			
 			 		Person2 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]")).getText();
 			 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
 			 		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
 			 		onBehalfOf12= onBehalfOf22.split(":");
 			 		onBehalfof2 =  onBehalfOf12[1].trim();   
 			 		nextstep= driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size();

 			 		//------------------------------------------------if(nextstep>1)--------------------------------------------------------
 			 		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
 			 		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
 			 		if (Person2.contains(onBehalfof2)) {
 			 		}
 			 		else {
 			 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			 			a.moveToElement(driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
 			 			
 			 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
 			 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
 			 			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
 			 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
 			 		}
 			 		
 		
 			    		 
 			    	 }
 			    	
 			    	 else {	
 				while(!(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()>0)) {
 					driver.navigate().refresh();
 					
 					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='tabContent']")));
 					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text() = 'Process']")));
 					Thread.sleep(2000);

 					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]"))));
 					Thread.sleep(2000);
 					try {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}
 					catch(Exception eccs) {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}

 					//Process Tab
 					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent'and @aria-label='Process'] ")));
 				    Thread.sleep(15000);	}
 				nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
 				
 				
 				//start proxy
 				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
 				
 			Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
 			onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
 			onBehalfOf12= onBehalfOf22.split(":");
 			onBehalfof2 =  onBehalfOf12[1].trim();

 			nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
 			try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
 			catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}

 			try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
 			catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
 			if (Person2.contains(onBehalfof2)) {
 			}
 			else {
 				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 				a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
 				
 				a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
 				a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
 				driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
 				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
 			}

 				
 			    }}
			
			
			//if not inprogress, scroll down to the end
			     else {
			    	 a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).click().perform();	 
			    	 a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).sendKeys(Keys.CONTROL, Keys.END).perform(); 
				Thread.sleep(1000);
				wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@data-automation-loadingpanelhidden='true']"))));
				a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).click().perform();	 
				a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).sendKeys(Keys.CONTROL, Keys.END).perform();
				Thread.sleep(1500);
				wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@data-automation-loadingpanelhidden='true']"))));
				
				
				
				
		                  if(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()==0) {
				                          if(driver.findElements(By.xpath("//*[text()='In Progress']")).size()>0) {
				              				
				         			    	 if(driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size()>0)
				         			    	 {
				         			    		//start proxy
				         			 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='In Progress']")));
				         			 			
				         			 		Person2 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]")).getText();
				         			 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
				         			 		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
				         			 		onBehalfOf12= onBehalfOf22.split(":");
				         			 		onBehalfof2 =  onBehalfOf12[1].trim();   
				         			 		nextstep= driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size();

				         			 		//------------------------------------------------if(nextstep>1)--------------------------------------------------------
				         			 		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
				         			 		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
				         			 		if (Person2.contains(onBehalfof2)) {
				         			 		}
				         			 		else {
				         			 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				         			 			a.moveToElement(driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
				         			 			
				         			 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
				         			 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
				         			 			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
				         			 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
				         			 		}
				         			 		
				         		
				         			    		 
				         			    	 }
				         			    	
				         			    	 else {	
				         				while(!(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()>0)) {
				         					driver.navigate().refresh();
				         					
				         					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='tabContent']")));
				         					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				         					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text() = 'Process']")));
				         					Thread.sleep(2000);

				         					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]"))));
				         					Thread.sleep(2000);
				         					try {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}
				         					catch(Exception eccs) {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}

				         					//Process Tab
				         					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent'and @aria-label='Process'] ")));
				         				    Thread.sleep(15000);	}
				         				nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
				         				
				         				
				         				//start proxy
				         				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
				         				
				         			Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
				         			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
				         			onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
				         			onBehalfOf12= onBehalfOf22.split(":");
				         			onBehalfof2 =  onBehalfOf12[1].trim();

				         			nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
				         			try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
				         			catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}

				         			try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
				         			catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
				         			if (Person2.contains(onBehalfof2)) {
				         			}
				         			else {
				         				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				         				a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
				         				
				         				a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
				         				a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
				         				driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
				         				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
				         			}

				         				
				         			    }}} 
				
				
				
				

		         else {
					
					//start proxy
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
					nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
				Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
				onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
				onBehalfOf12= onBehalfOf22.split(":");
				onBehalfof2 =  onBehalfOf12[1].trim();		
				
				nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
				try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
				catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
				
				if (Person2.contains(onBehalfof2)) {
     			}
     			else {
     				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     				a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
     				
     				a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
     				a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
     				driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
     				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
     			}
		                
		               }
			
			
			
		} //else CTRL A + END
			    } //if Awaiting Actons = 0 (Main)




		//Main Else
		else {

			
		//start proxy
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
			
		Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();   
		nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
		nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();

		//------------------------------------------------if(nextstep>1)--------------------------------------------------------

		multipleAwaitingActions(driver);



		}//else


		}//while

		}	//static


public static void Boxes1(WebDriver driver) throws InterruptedException, IOException
{
	
	   WebDriverWait wait = new WebDriverWait(driver, 25);
	   Actions a=new Actions(driver);

	   String Position = inbox.getExcelData("Transfer", "Field", "Position").get(0);
	   
	   Enter1.clear();
	   
		Enter1 = inbox.getExcelData("Transfer", "Transfer", "Transfer - Task");
		
	  
		
	while(Enter1.size()>0) {	
		Thread.sleep(2300);	
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		if(driver.findElements(By.xpath("//*[text()='Submit']")).size()>0) {Manager(driver);}
		
		Iterator<String> i = Enter1.iterator();	
		
		
		//Position
		   
		 if(driver.findElements(By.xpath("//h3[contains(text(), 'Position')]" )).size()>0) {
			  String[] Position1= Position.split("=");
			    //field=  Position1[0];
			  Position= Position1[1];
			 Position(driver, Position);}
		
	if(Enter1.size() == 0) {}
	else {
		   
	
while(i.hasNext()) {
			  String value = i.next();
			   if (value.contains("&")){
					  
					  continue;
					   
				   }
			  
				  if (value.contains(":")){
					   fieldm= value.split(":");
					   field12=  fieldm[0];
					   field13= fieldm[1];
					
			
					   fieldn= field13.split("=");
					    field=  fieldn[0];
					  input= fieldn[1];
					  
					 
					  
					  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
				   
			//Pencil Icon	   
				   if(driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size()>0) { 
					 
					   if(value.contains(field12)) { i.remove();}	
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
					   
					   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
				
					   
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
					   
					  Boolean h = false;
					 while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
					 }
					  
					if(field12.contains("Hourly") || field12.contains("Salary")) {((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));} 
					   
				   if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size() >0) 
				   {driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).click();
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));
				   }}
				   
				   
		//Add button		   
				   else if(driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size()>0) { 
					 
					   if(value.contains(field12)) { i.remove();}
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
					   
					   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
				
					   
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
				
					   
					  Boolean h = false;
					 while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
					 }
					   
					   
					   
				   if (driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size() >0) 
				   {driver.findElement(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).click();
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]"))); }
				    }
	   
				   
				   
	   //Java Script executor
	   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	   
	   
	  
	   if(driver.findElements(By.xpath("//label[text()='"+field+"']")).size()>0) { 
		 
		   
		   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		   
		   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
		   

		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);		  
	 
		 Boolean h = false;
			 while(h==false)
			 {
				h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//label[text()='"+field+"']")));
			 }
	   
	   
	   
	   
			  //input into the box
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			 
				   
			   //Enter Input Box
				   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).size()>0) {
						
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
					   Thread.sleep(1000);
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(input);
					}
				   
				   
				   //Searchbox
				   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).size()>0) {
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
							
							else {try { 	WebDriverWait wait3 = new WebDriverWait(driver, 5);
							wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
						catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
							wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
							
								//Reselecting the option   
							driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
			              
							else { 
								driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }
					         }
						   
						   }
					   
					   
					   else {
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
						
						   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(input, Keys.ENTER);
					
						   
						   //wait time
			          try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
					wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
				catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
					wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
					
						//Reselecting the option   
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
	              
					else { 
						driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }}}
		   
		   
		   
		   
		   
		   
		   
		   //Search box with pencil icon edit
		   
				   else if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).size() >0) {
               
			   if (driver.findElements(By.xpath("//*[@data-automation-id='formLabelRequired']  //label[contains(text(), '"+field+"')]/parent::div/following-sibling::div //*[@style='visibility: visible;']")).size() >0) {}
			   else { driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).click();
		              //driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div")).click();
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div //input[@data-automation-id= 'searchBox']")));
			   driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div //input[@data-automation-id= 'searchBox']")).sendKeys(input, Keys.ENTER);
			   
			   
			 //Reselecting the option  
			   try { 	WebDriverWait wait1 = new WebDriverWait(driver, 3);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
			catch(Exception e) { wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
				   
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
         
			else {  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click(); }
			   
			   }
          
		   } 
	   }
	   
	    
					   
				
				  }
				  }//for2 loop
		   


Iterator<String> j = Enter1.iterator();			   
		   
while(j.hasNext()) {
			   String value = j.next();
			        if (value.contains("&")){
					  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					  fieldm= value.split(":");
					   field12=  fieldm[0];
					   field13= fieldm[1];
		
				
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
						  
					         //Java Script executor
						
							   
							   try {
							   WebDriverWait waitContainer = new WebDriverWait(driver,0);
							   waitContainer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+field12+"']")));}
							   catch(Exception jnkj) {}
							   
					//Pencil Icon	  
							   
						   if(driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size()>0) { 
							 
							   if(value.contains(field12)) { j.remove();}		 
							   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
							   
							   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
							   
							   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
						
							   
							  Boolean h = false;
							 while(h==false)
							 {
								h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
							 }
							   
							   
							   
						   if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size() >0) 
						   { try{driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).click();}
						   catch(Exception jhbhj) {}
						       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));    
						       }}
						   
						   
				//Add button		   
						   else if(driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size()>0) { 
							 
							   if(value.contains(field12)) { j.remove();}	
							   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
							   
							   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
							   
							   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
						
							   
							  Boolean h = false;
							 while(h==false)
							 {
								h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
							 }
							   
							   
							   
						   if (driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size() >0) 
						   {driver.findElement(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).click();
						   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));  }
						   }
			   
						   
							  for(int hj=0; hj<10; hj++) {
								  
								  fieldn3= field13.split("&");
								  try {field3=  fieldn3[hj];}
								  catch(Exception IndexFor) {break;}
								  if(field3 ==null) {break;}
								  
								  
								    fieldn= field3.split("=");
									   field=  fieldn[0];
									   input= fieldn[1];	   
						   
						   
						   
						   
			   //Java Script executor
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			   
			   
			   
			   if(driver.findElements(By.xpath("//label[text()='"+field+"']")).size()>0) { 
				 
				   
				   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
				   
				   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
				   

				   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);		  
			 
				 Boolean h = false;
				while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field+"']")));
					 }
			   
			   
			   
			   
					  //input into the box
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					 
						   
					   //Enter Input Box
						   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).size()>0) {
								Thread.sleep(1500);
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
							   
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(input);
							}
						   
						   
						   //Searchbox
						   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).size()>0) {
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
									
									else {try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
									wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
								catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
									wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
									
										//Reselecting the option   
									driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
									if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
										Thread.sleep(1000);
										driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
					              
									else { 
										driver.findElement(By.xpath("//*[@data-automation-id= 'promptOption' and text()='"+input+"']")).click();          }
							         }
								   
								   }
							   
							   
							   else {
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
								
								   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(input, Keys.ENTER);
							
								   
								   //wait time
					          try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
							wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
						catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
							wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
							
								//Reselecting the option   
							driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
			              
							else { 
								driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }}}
				   
						   
							driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			
			 
					
			                      }
			  		    } //inside for loop
						   
				
							 
					}//if contains ","
				  
				  
				  
		   }//for3 loop
		   
		   
		   
	}//else loop
	
	
	
	System.out.println(Enter1+ "Enter1");	
	
//Submit	
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

	 if(driver.findElements(By.xpath("//*[text()='Next']")).size()>0){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		
		
	}
	 else if(driver.findElements(By.xpath("//*[text()='Submit']")).size()>0) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Submit']")));
		  driver.findElement(By.xpath("//*[text()='Submit']")).click();
		  if(driver.findElements(By.xpath("//*[contains(text(),'Alert')]")).size()>0){
			  driver.findElement(By.xpath("//*[text()='Submit']")).click(); 
		  }
		  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Submit']"))));
		   Thread.sleep(2000); 
		  }  
	else if(driver.findElements(By.xpath("//*[text()='Done']")).size()>0)
	{	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Done']")));
		driver.findElement(By.xpath("//*[text()='Done']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Done']"))));
		Thread.sleep(2000);          driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);}
	else if(driver.findElements(By.xpath("//*[text()='OK']")).size()>0){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='OK']")));
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='OK']"))));
		Thread.sleep(2000); driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);}
	else if(driver.findElements(By.xpath("//*[text()='Approve']")).size()>0){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Approve']")));
		driver.findElement(By.xpath("//*[text()='Approve']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Approve']"))));
		Thread.sleep(2000); driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);}
	
	 if(Enter1.size()==0) {driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);}
	 if(driver.findElements(By.xpath("//*[text()='Submit']")).size()>0) {
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Submit']")));
			  driver.findElement(By.xpath("//*[text()='Submit']")).click();
			  if(driver.findElements(By.xpath("//*[contains(text(),'Alert')]")).size()>0){
				  driver.findElement(By.xpath("//*[text()='Submit']")).click(); 
			  }
			  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Submit']"))));
			   Thread.sleep(2000); 
			   if(Enter1.size()>0) {Manager(driver);}		  
	 } 
	 
}        		

}

public static void multipleAwaitingActions(WebDriver driver) throws InterruptedException
{
	 WebDriverWait wait = new WebDriverWait(driver, 25);
	   Actions a=new Actions(driver);
	   
	   
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
onBehalfOf12= onBehalfOf22.split(":");
onBehalfof2 =  onBehalfOf12[1].trim(); 
	   

if(nextstep>1) {

//List<WebElement> NoofAwaitinginproxy = driver.findElements(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]"));

try {
for(int m=0; m<nextstep; m++) {
String ProxyNameinAwating =	driver.findElements(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).get(m).getText();
	if (ProxyNameinAwating.contains(onBehalfof2)) {
	ListoftasksAwaiting1 =driver.findElements(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).get(m).getText();
		ListoftasksAwaiting.add(ListoftasksAwaiting1);
		
	}	
}

}

catch(Exception IndexOutOfBounds) {ListoftasksAwaiting.clear();
	for(int m=0; m<nextstep; m++) { 
		String ProxyNameinAwating =	driver.findElements(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).get(m).getText();
			if (ProxyNameinAwating.contains(onBehalfof2)) {
			ListoftasksAwaiting1 =driver.findElements(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).get(m).getText();
				ListoftasksAwaiting.add(ListoftasksAwaiting1);
				
			}	
		}	
	
	
	
}


System.out.println(ListoftasksAwaiting);
for(String n:ListoftasksAwaiting) {
	n=nextAwaitingStep1;
	
	
	
	
	
	
	
	
	
	
	
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-automation-id='inbox_preview']/div")));	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));
	Thread.sleep(2000);

	
	
driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));
inbox_list = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));


nextAwaitingStep = Employee;
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

else if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

else if (driver.findElements(By.xpath("//*[contains(text(), '"+task+"')]")).size()>0) { nextAwaitingStep = task;} //by task

else {String[] inboxselection= nextAwaitingStep1.split(" ");                                                           // task separeated by space
for(String d:inboxselection) {
	nextAwaitingStep=d;
	if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']")).size()>0)
	{ break;}			
}
}

System.out.println(nextAwaitingStep);



driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 


try {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}
catch(Exception jki) {a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-inbox-detail-frosting='false']")));

WebDriverWait waitBoxes = new WebDriverWait(driver, 3);
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

waitBoxes.until(ExpectedConditions.or(
	    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Submit']")),
	   ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Done']")),
	    ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-automation-id='thirdPartyConnection']")),
	    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='OK']"))));

Thread.sleep(1500);
Boxes(driver);

	
} //'for' each tasks in the same proxy
	
	
	
	
if(ListoftasksAwaiting.size() >0) {
	

//----------------------------------------------Archive--------------------------------
//Inbox	   
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));	
//driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));

WebElement inbox_list_Archive2 = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));
//Archive
driver.findElement(By.xpath("//*[contains(text(), 'Archive')]")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));


//choosing the task
nextAwaitingStep = Employee;
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

else if (driver.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

else if (driver.findElements(By.xpath("//*[contains(text(), '"+task+"')]")).size()>0) { nextAwaitingStep = task;} //by task

else {String[] inboxselection= nextAwaitingStep1.split(" ");                                                           // task separeated by space
for(String d:inboxselection) {
	nextAwaitingStep=d;
	
	if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']")).size()>0)
	{ break;}			
}
}

System.out.println("Acrchive ="+nextAwaitingStep+" ");;


driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

Thread.sleep(3000);
//wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))));
try {a.moveToElement(inbox_list_Archive2.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}
catch(Exception ede) {Thread.sleep(1000);
	a.moveToElement(inbox_list_Archive2.findElement(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]"))).click().build().perform();}

//Overall Process
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")));
Thread.sleep(2000);
//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']"))));
try {driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")).click();}
catch(Exception ede) {Thread.sleep(1000);
driver.findElement(By.xpath("//*[contains(text(), 'Overall Process')]/parent::div/parent::li //*[@data-automation-id='promptOption']")).click();}


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='tabContent']")));
//TabContent2 = driver.findElement(By.xpath("//*[@data-automation-id='tabContent']"));



driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text() = 'Process']")));
Thread.sleep(2000);

wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]"))));
Thread.sleep(2000);
try {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}
catch(Exception eccs) {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}


//Awaiting Action
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent'and @aria-label='Process'] ")));
//TabContent.findElement(By.xpath("//*[text()='Awaiting Action']"));

Thread.sleep(2000);
driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();



if(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()==0) {
	if(driver.findElements(By.xpath("//*[text()='In Progress']")).size()>0) {
			
	    	 if(driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size()>0)
	    	 {
	    		//start proxy
	 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='In Progress']")));
	 			
	 		Person2 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]")).getText();
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
	 		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
	 		onBehalfOf12= onBehalfOf22.split(":");
	 		onBehalfof2 =  onBehalfOf12[1].trim();   
	 		nextstep= driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size();

	 		//------------------------------------------------if(nextstep>1)--------------------------------------------------------
	 		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
	 		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
	 		if (Person2.contains(onBehalfof2)) {
	 		}
	 		else {
	 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 			a.moveToElement(driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
	 			
	 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
	 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
	 			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
	 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
	 		}
	 		

	    		 
	    	 }
	    	
	    	 else {	
		while(!(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()>0)) {
			driver.navigate().refresh();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='tabContent']")));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text() = 'Process']")));
			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]"))));
			Thread.sleep(2000);
			try {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}
			catch(Exception eccs) {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}

			//Process Tab
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent'and @aria-label='Process'] ")));
		    Thread.sleep(15000);	}
		nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
		
		
		//start proxy
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
		
	Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
	onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
	onBehalfOf12= onBehalfOf22.split(":");
	onBehalfof2 =  onBehalfOf12[1].trim();

	nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
	try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
	catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}

	try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
	catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
	if (Person2.contains(onBehalfof2)) {
	}
	else {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
		
		a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
		driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
	}

		
	    }}
	else {
		a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).click().perform();	 
   	 a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).sendKeys(Keys.CONTROL, Keys.END).perform(); 
	Thread.sleep(1000);
	wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@data-automation-loadingpanelhidden='true']"))));
	a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).click().perform();	 
	a.moveToElement(driver.findElement(By.xpath("//*[text()='Process History']/parent::table/tbody/tr[1]/td[3]"))).sendKeys(Keys.CONTROL, Keys.END).perform();
	Thread.sleep(1500);
	wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@data-automation-loadingpanelhidden='true']"))));
		
		if(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()==0) {
		if(driver.findElements(By.xpath("//*[text()='In Progress']")).size()>0) {
				
		    	 if(driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size()>0)
		    	 {
		    		//start proxy
		 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='In Progress']")));
		 			
		 		Person2 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]")).getText();
		 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		 		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		 		onBehalfOf12= onBehalfOf22.split(":");
		 		onBehalfof2 =  onBehalfOf12[1].trim();   
		 		nextstep= driver.findElements(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div")).size();

		 		//------------------------------------------------if(nextstep>1)--------------------------------------------------------
		 		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
		 		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
		 		if (Person2.contains(onBehalfof2)) {
		 		}
		 		else {
		 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 			a.moveToElement(driver.findElement(By.xpath("//*[text()='In Progress']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
		 			
		 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
		 			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
		 			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
		 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
		 		}
		 		
	
		    		 
		    	 }
		    	
		    	 else {	
			while(!(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()>0)) {
				driver.navigate().refresh();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='tabContent']")));
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text() = 'Process']")));
				Thread.sleep(2000);

				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]"))));
				Thread.sleep(2000);
				try {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}
				catch(Exception eccs) {driver.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();}

				//Process Tab
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-automation-id='tabContent'and @aria-label='Process'] ")));
			    Thread.sleep(15000);	}
			nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
			
			
			//start proxy
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
			
		Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();

		nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}

		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
		if (Person2.contains(onBehalfof2)) {
		}
		else {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
			
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
		}

			
		    }}
		
		}
		
		else {
			
			//start proxy
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
			nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
		Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();

		//String Step2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]")).getText();
		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
		if (Person2.contains(onBehalfof2)) {
		}
		else {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
			
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
		}
			
			
			
			
		}
	
	
	
	
	
	
	
	}
	


} //if awaiting =0
		
		else {
			
			//start proxy
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
			nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
		Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();

		//String Step2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]")).getText();
		try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
		catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
		if (Person2.contains(onBehalfof2)) {
		}
		else {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
			
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
		}
			
			
			
			
		}
		
		
		
	
	
	

}//if list >0

else {
try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
if (Person2.contains(onBehalfof2)) {
}
else {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
	
	a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
	a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
	driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
}

}

}
else {

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
	onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
	onBehalfOf12= onBehalfOf22.split(":");
	onBehalfof2 =  onBehalfOf12[1].trim();
	
	
	try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
	catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
	if (Person2.contains(onBehalfof2)) {
	}
	else {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
		
		a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
		driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
	}	
	
	
}
}  

public static void Boxes(WebDriver driver, String...Enter) throws InterruptedException
{
	
	   WebDriverWait wait = new WebDriverWait(driver, 25);
	   Actions a=new Actions(driver);

	   Enter1.clear();;
	   
		for(String ihvhg: Enter) {
			Enter1.add(ihvhg);
			}
	   
		System.out.println(Enter1);
		
	if(Enter1.size() == 0) {}
	else {
		   for(String i:Enter1) {
		   
			  if (i.contains(":")){
				  
				  continue;
				   
			   }
			   
			   
			   field1= i.split("=");
			    field=  field1[0];
			  input= field1[1];
			      		
			   
	               //Java Script executor
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			   
			  
			   
			   if(driver.findElements(By.xpath("//*[text()='"+field+"']")).size()>0) { 
				 
				   
				   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
				   
				   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
				   
				   Thread.sleep(2000);
				   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);		  
			 
				  Boolean h = false;
					 while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field+"']")));
					 }
			   
			   
			   
			   
					  // Boxes
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					 
						   
//--------------------------------------Enter Input Box----------------------------------------------------
						   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).size()>0) {
								
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(input);
							}
						   
						   
						   
						   
//--------------------------------------------------Searchbox-----------------------------------------------
						   //Searchbox
						   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).size()>0) {
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
									
									else {try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
									wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
								catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
									wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
									
										//Reselecting the option   
									driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
									if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
										Thread.sleep(1000);
										driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
					              
									else { 
										driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }
							         }
								   
								   }
							   
							   
							   else {
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
								
								   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(input, Keys.ENTER);
							
								   
								   //wait time
					          try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
							wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
						catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
							wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
							
								//Reselecting the option   
							driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
			              
							else { 
								driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }}}
				   
//----------------------------------------------------Veteran status---------------------------------------------
						   if (driver.findElements(By.xpath("//*[text()='"+field+"']/parent::div/following-sibling::div //input[@placeholder='Search']")).size()>0)
						   {driver.findElement(By.xpath("//*[text()='"+field+"']/parent::div/following-sibling::div //input[@placeholder='Search']")).click();
						   System.out.println(input);
						   driver.findElement(By.xpath("//*[text()='"+field+"']/parent::div/following-sibling::div //input[@placeholder='Search']")).sendKeys(input, Keys.ENTER);
						   
						 //Reselecting the option  
						   try { 	WebDriverWait wait1 = new WebDriverWait(driver, 3);
							wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
						catch(Exception e) { wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
							   
						driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
						if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
							Thread.sleep(1000);
							driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
			         
						else { 
							driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click(); }
						   
						   
						   
					
						   
						   
						   }
				   
				   
				   
				   
				   
				   
//----------------------------------------Search box with pencil icon edit---------------------------------------------
						   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				   if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).size() >0) {
	                   
					   if (driver.findElements(By.xpath("//*[@data-automation-id='formLabelRequired']  //label[contains(text(), '"+field+"')]/parent::div/following-sibling::div //*[@style='visibility: visible;']")).size() >0) {}
					   else { driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).click();
				              //driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div")).click();
					   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div //input[@data-automation-id= 'searchBox']")));
					   driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div //input[@data-automation-id= 'searchBox']")).sendKeys(input, Keys.ENTER);
					   
					   
					 //Reselecting the option  
					   try { 	WebDriverWait wait1 = new WebDriverWait(driver, 3);
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
					catch(Exception e) { wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
						   
					driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
		         
					else { 
						driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click(); }
					
					   }
	              
				   } 
			   }
			   
			   
				   
			   
			   

//---------------------------------------------------------------calendar----------------------------------------------------------
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
			   
			
			   
//-------------------------------------------------------------------Adobe----------------------------------------------------
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				   if(driver.findElements(By.xpath("//button[@data-automation-id='thirdPartyConnection']")).size()>0) {
					   onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
						onBehalfOf12= onBehalfOf22.split(":");
						onBehalfof2 =  onBehalfOf12[1].trim();
						String[] sign= onBehalfof2.split(" ");
						String signFN=sign[0];
						
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@data-automation-id='thirdPartyConnection']")));
				   driver.findElement(By.xpath("//button[@data-automation-id='thirdPartyConnection']")).click();
				   driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='gwt-Frame WDLH WELH']")));
				   Thread.sleep(12500);
				   driver.findElement(By.xpath("//button[@class='popover coachmark down left sticky']")).click();
				   Thread.sleep(1000);	 
				   driver.findElement(By.xpath("//div[@aria-label='Click here to sign']")).click();
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Type your signature here']")));
				   a.moveToElement(driver.findElement(By.xpath("//input[@aria-label='Type your signature here']"))).click().build().perform();
				   Thread.sleep(2000);
				   a.moveToElement(driver.findElement(By.xpath("//input[@aria-label='Type your signature here']"))).sendKeys(signFN).build().perform();
				   Thread.sleep(2000);
				   driver.findElement(By.xpath("//button[text()='Apply']")).click();
				   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				   try {
				   driver.findElement(By.xpath("//button[text()='Click to Sign']")).click();}
				   catch(Exception kjnj) {
					   a.moveToElement(driver.findElement(By.xpath("//input[@aria-label='Type your signature here']"))).click().build().perform();
					   Thread.sleep(2000);
					   a.moveToElement(driver.findElement(By.xpath("//input[@aria-label='Type your signature here']"))).sendKeys(signFN).build().perform();
					   Thread.sleep(2000);
					   driver.findElement(By.xpath("//button[text()='Apply']")).click();
				   }
				   driver.switchTo().defaultContent();
				   driver.findElement(By.xpath("//*[text()='Submit']")).click();
				   wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Submit']"))));
				   Thread.sleep(1500);
				   break;
				   }
				   
				   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				 //Paycard or I Agree
				   if (driver.findElements(By.xpath("//label[text()='I Agree']/parent::div/following-sibling::div/div/div/div")).size()>0)				   
				   { ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//label[text()='I Agree']/parent::div/following-sibling::div/div/div/div")));
					 Thread.sleep(1000);  driver.findElement(By.xpath("//label[text()='I Agree']/parent::div/following-sibling::div/div/div/div")).click();
				   break;}
				   
				 //Payment Election
				   if (driver.findElements(By.xpath("//label[text()='Check']/preceding-sibling::input")).size()>0)
				   {((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//label[text()='Check']/preceding-sibling::input")));
					 Thread.sleep(1000);
					   driver.findElement(By.xpath("//label[text()='Check']/preceding-sibling::input")).click();
				   break;}
				   
		 
				 //Photo Change
				   if (driver.findElements(By.xpath("//*[text()='Change My Photo']/parent::h2/parent::div/parent::div //*[@class='wd-icon-gear wd-icon']")).size()>0)
				   {driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					   driver.findElement(By.xpath("//*[text()='Change My Photo']/parent::h2/parent::div/parent::div //*[@class='wd-icon-gear wd-icon']")).click();
					   Thread.sleep(1500);
				   a.moveToElement(driver.findElement(By.xpath("//div[text()='Skip This Task']/parent::li"))).click().build().perform();
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@data-automation-id='textAreaField']")));
				   Thread.sleep(1500);
				   driver.findElement(By.xpath("//textarea[@data-automation-id='textAreaField']")).click();
				   a.moveToElement(driver.findElement(By.xpath("//textarea[@data-automation-id='textAreaField']"))).sendKeys("Test").build().perform();
				   break;} 
				   
				   
				   
			
			   
			   

	}//for1 loop
		
for(String i:Enter1) {
			   
			   if (i.contains("&")){
					  
					  continue;
					   
				   }
			   
				  if (i.contains(":")){
					   fieldm= i.split(":");
					   field12=  fieldm[0];
					   field13= fieldm[1];
					
			
					   fieldn= field13.split("=");
					    field=  fieldn[0];
					  input= fieldn[1];
					  
					  
					  
			
				      		
				   
		               //Java Script executor
				   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				   if(driver.findElements(By.xpath("//*[@title='Legal Name Change']")).size()>0) { }
				   
				   else {
				   
			//Pencil Icon	   
				   if(driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size()>0) { 
					 
					   
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
					   
					   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
				
					   
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
				
					   
					  Boolean h = false;
					 while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
					 }
					   
					   
					   
				   if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size() >0) 
				   {driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).click();
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));
				   Thread.sleep(500);}}
				   
				   
		//Add button		   
				   else if(driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size()>0) { 
					 
					   
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
					   
					   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
				
					   
					   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
				
					   
					  Boolean h = false;
					 while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
					 }
					   
					   
					   
				   if (driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size() >0) 
				   {driver.findElement(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).click();
				   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]"))); }
				   Thread.sleep(500); }
	   
				   
				   
	   //Java Script executor
	   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	   
	   
	   
	   if(driver.findElements(By.xpath("//*[text()='"+field+"']")).size()>0) { 
		 
		   
		   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		   
		   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
		   

		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);		  
	 
		  Boolean h = false;
			 while(h==false)
			 {
				h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//label[text()='"+field+"']")));
			 }
	   
	   
	   
	   
			  //input into the box
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			 
				   
			   //Enter Input Box
				   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).size()>0) {
						
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(input);
					}
				   
				   
				   //Searchbox
				   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).size()>0) {
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
							
							else {try { 	WebDriverWait wait3 = new WebDriverWait(driver, 5);
							wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
						catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
							wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
							
								//Reselecting the option   
							driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
			              
							else { 
								driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }
					         }
						   
						   }
					   
					   
					   else {
					   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
						
						   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(input, Keys.ENTER);
					
						   
						   //wait time
			          try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
					wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
				catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
					wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
					
						//Reselecting the option   
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
	              
					else { 
						driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }}}
		   
		   
		   
		   
		   
		   
		   
		   //Search box with pencil icon edit
		   
				   else if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).size() >0) {
               
			   if (driver.findElements(By.xpath("//*[@data-automation-id='formLabelRequired']  //label[contains(text(), '"+field+"')]/parent::div/following-sibling::div //*[@style='visibility: visible;']")).size() >0) {}
			   else { driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).click();
		              //driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div")).click();
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div //input[@data-automation-id= 'searchBox']")));
			   driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div //input[@data-automation-id= 'searchBox']")).sendKeys(input, Keys.ENTER);
			   
			   
			 //Reselecting the option  
			   try { 	WebDriverWait wait1 = new WebDriverWait(driver, 3);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
			catch(Exception e) { wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
				   
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
         
			else {  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click(); }
			   
			   }
          
		   } 
	   }
	   
	    
					   
				  }//Legal name change
				  }
				  }//for2 loop
		   
		   
		   
for(String i:Enter1) {
			   
			        if (i.contains("&")){
					  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					  fieldm= i.split(":");
					   field12=  fieldm[0];
					   field13= fieldm[1];
		
				
					
						  
					         //Java Script executor
						   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
						   if(driver.findElements(By.xpath("//*[@title='Legal Name Change']")).size()>0) { }
						   
						   else {
							   
							   try {
							   WebDriverWait waitContainer = new WebDriverWait(driver,7);
							   waitContainer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+field12+"']")));}
							   catch(Exception jnkj) {}
							   
					//Pencil Icon	  
							   
						   if(driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size()>0) { 
							 
							   
							   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
							   
							   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
							   
							   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
						
							   
							  Boolean h = false;
							 while(h==false)
							 {
								h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
							 }
							   
							   
							   
						   if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size() >0) 
						   { try{driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).click();}
						   catch(Exception jhbhj) {}
						       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));    }}
						   
						   
				//Add button		   
						   else if(driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size()>0) { 
							 
							   
							   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
							   
							   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
							   
							   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
						
							   
							  Boolean h = false;
							 while(h==false)
							 {
								h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
							 }
							   
							   
							   
						   if (driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size() >0) 
						   {driver.findElement(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).click();
						   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));  }
						   }
			   
						   
							  for(int hj=0; hj<10; hj++) {
								  
								  fieldn3= field13.split("&");
								  try {field3=  fieldn3[hj];}
								  catch(Exception IndexFor) {break;}
								  if(field3 ==null) {break;}
								  
								  
								    fieldn= field3.split("=");
									   field=  fieldn[0];
									   input= fieldn[1];	   
						   
						   
						   
						   
			   //Java Script executor
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			   
			   
			   
			   if(driver.findElements(By.xpath("//*[text()='"+field+"']")).size()>0) { 
				 
				   
				   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
				   
				   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
				   

				   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);		  
			 
				 Boolean h = false;
				while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field+"']")));
					 }
			   
			   
			   
			   
					  //input into the box
					   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					 
						   
					   //Enter Input Box
						   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).size()>0) {
								
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(input);
							}
						   
						   
						   //Searchbox
						   if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).size()>0) {
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
									
									else {try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
									wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
								catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
									wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
									
										//Reselecting the option   
									driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
									if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
										Thread.sleep(1000);
										driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
					              
									else { 
										driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }
							         }
								   
								   }
							   
							   
							   else {
							   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
								
								   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(input, Keys.ENTER);
							
								   
								   //wait time
					          try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
							wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
						catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
							wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
							
								//Reselecting the option   
							driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
			              
							else { 
								driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }}}
				   
						   
							driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					//Government IDS
						/*
						 if( driver.findElements(By.xpath("//*[contains(text(),'Proposed IDs')]")).size()>0) {  
							 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
							 if( driver.findElements(By.xpath("//div[@data-automation-id='selectedItem']")).size()> 0) {break;} 
							
							 
							 if(ghj==0) {
							 a.moveToElement(driver.findElement(By.xpath("//button[@data-automation-id='addRow']/div"))).click().build().perform();
							 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@headers, 'columnheader1')] //input[@placeholder='Search']")));
							 ghj++;}
							             
						   if(field.contains("Country")){
							 a.moveToElement(driver.findElement(By.xpath("//td[contains(@headers, 'columnheader1')] //input[@placeholder='Search']"))).click().sendKeys(input, Keys.ENTER).build().perform();}
							  
						  
						 if(field.equalsIgnoreCase("National ID Type")){
							  a.moveToElement(driver.findElement(By.xpath("//td[contains(@headers, 'columnheader2')] //input[@placeholder='Search']"))).click().sendKeys(input, Keys.ENTER).build().perform();
						;  }
						 
					
						 if(field.equalsIgnoreCase("Add/Edit ID")){
							 if(input.equalsIgnoreCase("Random")) { min = 100000000; max = 999999999; random_int= (int)(Math.random() * (max - min + 1) + min);
							 WebElement wb =driver.findElement(By.xpath("//td[contains(@headers, 'columnheader4')] //input[@data-automation-id='textInputBox']"));
								JavascriptExecutor jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].value='"+random_int+"';", wb);}
							 else {
							WebElement wb =driver.findElement(By.xpath("//td[contains(@headers, 'columnheader4')] //input[@data-automation-id='textInputBox']"));
							JavascriptExecutor jse = (JavascriptExecutor)driver;
							jse.executeScript("arguments[0].value='"+input+"';", wb);}
							
							 }			
						 
						 if(field.contains("Issued Date")){
							
							String[] spaces = input.split("/"); 
				        	String Month= spaces[0];
				        	String Day = spaces[1];
				        	String year = spaces[2];
				        
				        	
				        	WebElement columndriver1 = driver.findElement(By.xpath("//td[contains(@headers, 'columnheader8')]"));
				        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", columndriver1);
				        	Thread.sleep(1000);
				        	//columndriver.findElement(By.xpath("//td[contains(@headers, 'columnheader8')]")).sendKeys(Keys.CONTROL, Keys.HOME);
				        	((JavascriptExecutor) driver)
				            .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
				        	Thread.sleep(2000);
				        	
				        	WebElement columndriver = driver.findElement(By.xpath("//td[contains(@headers, 'columnheader5')]"));
				        	
					        a.moveToElement(columndriver.findElement(By.xpath("//*[@data-automation-id='dateSectionMonth']"))).click().sendKeys(Month).build().perform();
					        a.moveToElement(columndriver.findElement(By.xpath("//*[@data-automation-id='dateSectionDay']"))).click().sendKeys(Day).build().perform();
					        a.moveToElement(columndriver.findElement(By.xpath("//*[@data-automation-id='dateSectionYear']"))).click().sendKeys(year).build().perform();
							
						 }						 
						 if(field.contains("Expiration Date")){
								
								String[] spaces = input.split("/"); 
					        	String Month= spaces[0];
					        	String Day = spaces[1];
					        	String year = spaces[2];
					     
					        	a.moveToElement(driver.findElement(By.xpath("(//*[@data-automation-id='dateSectionMonth'])[2]"))).click().sendKeys(Month).build().perform();
						        a.moveToElement(driver.findElement(By.xpath("(//*[@data-automation-id='dateSectionDay'])[2]"))).click().sendKeys(Day).build().perform();
						        a.moveToElement(driver.findElement(By.xpath("(//*[@data-automation-id='dateSectionYear'])[2]"))).click().sendKeys(year).build().perform();
								
							 }
						 
						 
						
				   
						 }	 */
					 
			   }
			    }
						   
				
					  }//inside for loop
					}//if contains ","
				  
				  
				  
		   }//for3 loop
		   
		   
		   
	}//else loop
	
	
	
	
	
//Submit	
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

	if(driver.findElements(By.xpath("//*[text()='Submit']")).size()>0) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Submit']")));
		  driver.findElement(By.xpath("//*[text()='Submit']")).click();
		  if(driver.findElements(By.xpath("//*[contains(text(),'Alert')]")).size()>0){
			  driver.findElement(By.xpath("//*[text()='Submit']")).click(); 
		  }
		  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Submit']"))));
		   Thread.sleep(2000); 
		   driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);}  
	else if(driver.findElements(By.xpath("//*[text()='Done']")).size()>0)
	{	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Done']")));
		driver.findElement(By.xpath("//*[text()='Done']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Done']"))));
		Thread.sleep(2000);          driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);}
	else if(driver.findElements(By.xpath("//*[text()='OK']")).size()>0){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='OK']")));
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='OK']"))));
		Thread.sleep(2000); driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);}
	else if(driver.findElements(By.xpath("//*[text()='Next']")).size()>0){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(2000); driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
	}
	
	     driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

	     if(driver.findElements(By.xpath("//*[text()='Submit']")).size()>0) {
		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Submit']")));
		  driver.findElement(By.xpath("//*[text()='Submit']")).click();
		   wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Submit']"))));
		   Thread.sleep(2000); 
		   driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);} 
     
	
}        		








//Job Profile
//inbox.Boxes(driver, "Job Profile:Job Profile=Bartender&Job Title=Bartender");

//Location Details
//inbox.Boxes(driver, "Location Details:Location=BWW 0685 Leavenworth, KS");

//Administrative
//inbox.Boxes(driver, "Administrative:Team Member Type=Regular&Time Type=Full time&Pay Rate=Hourly");

//Attachments
//if(driver.findElements(By.xpath("//button[@title = 'Next']")).size()>0) 
//{driver.findElement(By.xpath("//button[@title = 'Next']")).click();}


//Company & Cost Center
//inbox.Boxes(driver, "Company:Company=BWW USA BWW Resources LLC");
//inbox.Boxes(driver, "Cost Center:Cost Center=31000685 LEAVENWORTH, KS");

//Compensation
//driver.findElement(By.xpath("//button[@title = 'Next']")).click();
//inbox.Boxes(driver, "Hourly:Amount=8.00");
 
//Approval
//if(driver.findElements(By.xpath("//button[@title = 'Approve']")).size()>0) 
//{driver.findElement(By.xpath("//button[@title = 'Approve']")).click();}

//Onboarding
//inbox.Onboarding(driver);


}
