import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Request_Absence {
	static String task;
	static String TeamMember;
	static String Reason;
	static String EndDate;
	static int AdditionalJobs;
	static int j=0;
	static int k=0;
	static String Employee;
	static String Absence;
	static String Type;
	static String Begin_Datei;
	static String End_Datei;
	static String delegatei;
	static String CheckBoxi;
	static String AlternateDelegatei;
	static ArrayList<String> DelegationTasks =new ArrayList<String>();
	static String Delegation;
	
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver=new ChromeDriver();
		Actions a=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().window().maximize();
	
//----------------------------------------------------------------------------------------------------------------------------------------	
		
        Login.credentials(driver, "900000019", "Inspire#1");
		
		StartProxy.TeamMember(driver, "George Willard (100148717)");
		
		//Absence Request For
		Employee=inbox.input(driver, "AbsenceRequest =Tim Wynn");
			                                                                                                                                                                         RequestAbsence(driver);  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title = 'Select Date Range']"))); driver.findElement(By.xpath("//span[@title = 'Select Date Range']")).click();	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='From']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']")));
		//From Date
		inbox.input(driver, "From=04/29/2020");
		
		//To Date
		inbox.input(driver, "To=05/03/2020");
		
		//Absence Type
		Type = inbox.input(driver, "Type=Military");                                                                                                                            driver.findElement(By.xpath("//span[@title = 'Next']")).click(); wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='MainContainer']")));
		
        //Enter Quantity Per Day
		QuantityPerDay(driver, "4", "4", "4");                                                                                                                                    driver.findElement(By.xpath("//span[@title = 'Submit']")).click();
		
		//Request Delegation Change
		Delegation(driver, "Begin Date =05/24/2020",  "End Date =05/30/2020",
				           "Delegate to =Tim Wynn",   "Use Default Alternate =Yes",  "Alternate Delegate =Tim Wynn");
		
		//Approvals
		inbox.Onboarding(driver, Employee, "Absence Request", "LOA Task = Request Delegation Change");
		

	
//------------------------------------------------------------------------------------------------------------------------------------------------------		
		
		
		
		
		
		
		
	}
	
	public static void QuantityPerDay(WebDriver driver, String...Quantity) throws InterruptedException
	{
	Actions a=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 25);
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);		
	
	if(driver.findElements(By.xpath("//span[@title = 'Edit Quantity per Day']")).size()>0) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	driver.findElement(By.xpath("//span[@title = 'Edit Quantity per Day']")).click();
	      
	Thread.sleep(500); 
	if(Quantity.length>1) 		
	{int j= 1;
	
		for(String i:Quantity) {
		a.moveToElement(driver.findElement(By.xpath("(//*[@aria-label='row'] //div[@data-automation-id='numericWidget']/div)["+j+"]"))).click().sendKeys(i).build().perform();;
		//a.moveToElement(driver.findElement(By.xpath("(//*[@aria-label='row'] //div[@data-automation-id='numericWidget']/div)["+j+"]"))).sendKeys(i).build().perform();;
	Thread.sleep(1000); j++;	}
	}
	else if(Quantity.length == 1)
	{
		a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-id='numericWidget']/div"))).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-id='numericWidget']/div"))).sendKeys(Quantity).build().perform();
		
	}
	
	driver.findElement(By.xpath("//span[@title = 'Done']")).click();
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@title = 'Done']")));
	}
	
	
    }

	public static String RequestAbsence(WebDriver driver) throws InterruptedException
	{
		//Actions a=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		String onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		String[] onBehalfOf12= onBehalfOf22.split(":");
		String onBehalfof2 =  onBehalfOf12[1].trim();
		
		
		
		if(onBehalfof2.contains(Employee)) 
		{
			task = Task.EnterTask(driver, "Request Absence");
		return 	Absence = "EmployeeAsSelf";
		}
		else {
			task = Task.EnterTask(driver, "Enter Absence");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Worker']")));
			inbox.input(driver, "Worker="+Employee+"");
			driver.findElement(By.xpath("//span[@title = 'OK']")).click();
		return Absence="Manager";
		}
		
		
	}
	public static void Delegation(WebDriver driver, String Begin_Date, String End_Date, String delegate, String CheckBox,  String AlternateDelegate) throws InterruptedException
	{
		DelegationTasks.add(Begin_Date);
		DelegationTasks.add(End_Date);
		DelegationTasks.add(delegate);
		DelegationTasks.add(CheckBox);
		DelegationTasks.add(AlternateDelegate);
		
		
		
		for(String i:DelegationTasks) {
		int j=0;
			
			String[] field1= i.split("=");
		   //String field=  field1[0];
		   String inputdelegation= field1[1];
		
		   if(j==0) {Begin_Datei= inputdelegation; }
		   if(j==1) {End_Datei= inputdelegation;}
		   if(j==2) {delegatei= inputdelegation;}
		   if(j==3) {CheckBoxi= inputdelegation;}
		   if(j==4) {AlternateDelegatei=inputdelegation;}
		   
		j++;}
		
		inbox.Begin_Datei=Begin_Datei;
		inbox.End_Datei=End_Datei;
		inbox.delegatei=delegatei;
		inbox.CheckBoxi=CheckBoxi;
		inbox.AlternateDelegatei=AlternateDelegatei;
		
		
	}
	
}