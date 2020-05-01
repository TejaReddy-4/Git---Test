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

public class Create_Position {
static String task;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome Driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
WebDriver driver=new ChromeDriver();
Actions a=new Actions(driver);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 25);
driver.manage().window().maximize();

Login.credentials(driver, "Create Position");


StartProxy.TeamMember(driver, "Create Position");


//-------------------------------------------Create Position----------------------------------------------------------------------

task = Task.EnterTask(driver, "Create Position");

inbox.SupervisoryOrganization(driver, "Create Position", "Supervisory Organization");

searchBox(driver, "Position Request Reason");

inputBox(driver, "Job Posting Title");

inputBox(driver, "Number of Positions");

inbox.input(driver, "Create Position", "Availability Date");

inbox.input(driver, "Create Position", "Earliest Hire Date");

searchBox(driver, "Job Family");

searchBox(driver, "Job Profile");

searchBox(driver, "Location");

searchBox(driver, "Time Type");

searchBox(driver, "Worker Type");

searchBox(driver, "Worker Sub-Type");

driver.findElement(By.xpath("//*[text() = 'Submit']")).click();

inbox.Onboarding(driver, "Create Position", "Employee", "Create Position");



}
	

   public static void searchBox(WebDriver driver, String Efield2) throws InterruptedException, IOException
   {
	   WebDriverWait wait = new WebDriverWait(driver, 20);
	   Actions a=new Actions(driver);
	   
	   String SearchBox = inbox.getExcelData("Create Position", "Field", Efield2).get(0);
		String[] SearchBoxSplit = SearchBox.split("=");
		String field = SearchBoxSplit[0];
		String enter = SearchBoxSplit[1];
	   
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
	   
   public static void inputBox(WebDriver driver, String Efield2) throws InterruptedException, IOException 
	   {
	   
		String inputBox = inbox.getExcelData("Create Position", "Field", Efield2).get(0);
		String[] inputBoxSplit = inputBox.split("=");
		String field = inputBoxSplit[0];
		String enter = inputBoxSplit[1];
		
		   Thread.sleep(1000);
		   WebDriverWait wait = new WebDriverWait(driver, 20);
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")));
		   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).clear();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div/div/div/input")).sendKeys(enter);
	   }  
	   
   public static void SupervisoryOrganization(WebDriver driver, String Name)
   {
	   WebDriverWait wait = new WebDriverWait(driver, 25);
	   Actions a=new Actions(driver);
	   String selectedItem = driver.findElement(By.xpath("//div[@data-automation-id='selectedItem']")).getText();
	   
	   if(selectedItem.contains(Name))
	   {   
		 //Submit
		   driver.findElement(By.xpath("//div[@data-automation-id='dropDownCommandButton']")).click();
	   }   else {
	   driver.findElement(By.xpath("//div[@data-automation-id='DELETE_charm']")).click();
	   driver.findElement(By.xpath("//input[@data-automation-id='searchBox']")).sendKeys(Name, Keys.ENTER);

	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@data-automation-label='"+Name+"']")));
	   driver.findElement(By.xpath("//p[@data-automation-label='"+Name+"']")).click();

	   //Submit
	   driver.findElement(By.xpath("//div[@data-automation-id='dropDownCommandButton']")).click();
	   }
   }  
      
   public static void inbox(WebDriver driver, String... Enter) throws InterruptedException 
   {
	   

	   
	   
	   Thread.sleep(1000);
	   WebDriverWait wait = new WebDriverWait(driver, 20);
	   Actions a=new Actions(driver);

	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title, 'Details and Process')]/div")));	   	   
driver.findElement(By.xpath("//*[contains(@title, 'Details and Process')]/div")).click();


WebElement TabContent = driver.findElement(By.xpath("//*[@data-automation-id='tabContent']"));

WebElement Process = driver.findElement(By.xpath("//*[text() = 'Process']"));

((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Process);
TabContent.findElement(By.xpath("//*[@data-automation-id='tabLabel' and contains(text(),'Process')]")).click();

Thread.sleep(3000);
TabContent.findElement(By.xpath("//*[text()='Awaiting Action']"));

String Person = TabContent.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
String onBehalfOf2  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
String[] onBehalfOf1= onBehalfOf2.split(":");
String	onBehalfof =  onBehalfOf1[1].trim();

String Step = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]")).getText();

if (Person.contains(onBehalfof)) {
}
else {
	a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
	a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
	a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
	driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();
	
}


//inox
driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));
WebElement inbox_list = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));

a.moveToElement(inbox_list.findElement(By.xpath("//*[contains(text(), '"+task+"')]"))).click().build().perform();


//Inbox Tasks
if(Enter.length == 0) {}
else {
	   for(String i:Enter) {
		   String[] field1= i.split("=");
		   String field=  field1[0];
		   String input= field1[1];
		   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
		   Thread.sleep(1000);
		   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
		   
		   try { if (driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).isDisplayed() == true)
			   driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).click();
		   //driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div")).click();
			   driver.findElement(By.xpath("//*[text() = '"+field+"' and @data-automation-id='formLabel']/parent::div/following-sibling::div/div //input[@data-automation-id= 'searchBox']")).sendKeys(input, Keys.ENTER); }  catch(Exception e) {}
		 
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='listbox' and @data-automation-id='selectedItemList']")));
		   try{if (driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).isDisplayed() == true)
		   {driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}} catch(Exception e) {} 
	   }	   

}

//Submit
try { if (driver.findElement(By.xpath("//*[text()='Submit']")).isDisplayed() == true)
	   driver.findElement(By.xpath("//*[text()='Submit']")).click();  } 
finally {driver.findElement(By.xpath("//*[text()='Done']")).click();}



   }
   
   
}
   

