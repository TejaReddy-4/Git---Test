import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;

public class inbox {
	static int min;
	static int max;
	static int random_int;
	//static String task;
    //static String Employee;
	static String nextAwaitingStep;
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
	static List<String> ListoftasksAwaiting=new ArrayList<>();
	static ArrayList<String> Enter1 =new ArrayList<String>();
    static String Supinput1;
    static String Begin_Datei;
	static String End_Datei;
	static String delegatei;
	static String CheckBoxi;
	static String AlternateDelegatei;
	static ArrayList<String> DelegationTasks =new ArrayList<String>();
	

public static void Onboarding(WebDriver driver, String Employee, String task, String... Enter) throws InterruptedException 
		{
			   
			   WebDriverWait wait = new WebDriverWait(driver, 25);
			   Actions a=new Actions(driver);
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
			   //Process Successfully Completed
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));
			   Thread.sleep(2000);
			   if (driver.findElements(By.xpath("//div[text()='Process Successfully Completed']")).size()>0) {return;}		
			   
			   
			   
				for(String ihvhg: Enter) {
					Enter1.add(ihvhg);
				}
			   
				
				
			   
		nextAwaitingStep=Employee;
			   

		while (nextstep != 0) {
		//inbox
			
			if(driver.findElements(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/img")).size()>0) 
			{UpNext = driver.findElement(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/div/div/div/div")).getText();}
			else {UpNext="Default";}

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-automation-id='inbox_preview']/div")));	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='inbox_preview']/div")));


			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); 
		if(driver.findElements(By.xpath("//*[text()='Up Next']/parent::div/parent::div/following-sibling::div[1] //li/img")).size()>0) 
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Home']/div/img")));
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@title='Home']/div/img")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
		}
		
		driver.findElement(By.xpath("//button[@data-automation-id='inbox_preview']/div")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-automation-id, 'inbox_list') and @data-automation-inbox-list-frosting='false']")));
		inbox_list = driver.findElement(By.xpath("//div[contains(@data-automation-id, 'inbox_list')]"));

String onLeave= nextAwaitingStep;
String[] onLeave1=onLeave.split(" ");
String FN=onLeave1[0];
String LN = onLeave1[1];
		
		//nextAwaitingStep = Employee;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and contains(text(), '"+task+"') and @data-automation-id='inbox_row_title']")).size()>0) {nextAwaitingStep=""+nextAwaitingStep+"') and contains(text(), '"+task+"";}
		
		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']")).size()>0) {} //by employee name
		
		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"') and @data-automation-id='inbox_row_title']")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

		//else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+task+"') and @data-automation-id='inbox_row_title']")).size()>0) { nextAwaitingStep = task;} //by task

		else if (inbox_list.findElements(By.xpath("//*[contains(text(), 'FN') and contains(text(), 'onLeave') and contains(text(), 'LN') and @data-automation-id='inbox_row_title']")).size()>0) {nextAwaitingStep = FN + " " + "(onLeave)" + " " + LN; }
		
		else {String[] inboxselection= nextAwaitingStep1.split(" ");                                                           // task separeated by space
		for(String d:inboxselection) {
			nextAwaitingStep=d;
			if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"') and @data-automation-id='inbox_row_title']")).size()>0)
			{ break;}			
		}
		}

System.out.println(nextAwaitingStep);		
		
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
			   ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Approve']")),
			    ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-automation-id='thirdPartyConnection']")),
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='OK']"))));

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();
		

		if(onBehalfof2.contains(UpNext) || onBehalfof2.equalsIgnoreCase(UpNext)) {Boxes(driver, Enter);}
		else if(UpNext == "Default") {Boxes(driver, Enter);}
		
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

		nextAwaitingStep=Employee;
		//choosing the task
	
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+task+"')]")).size()>0) { nextAwaitingStep = task;} //by task

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

			multipleAwaitingActions(driver, Employee, task, Enter);

				
			}
			
			
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
			
				multipleAwaitingActions(driver, Employee, task, Enter);
						
				
			}} 
				
				
				
				

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
				
				multipleAwaitingActions(driver, Employee, task, Enter);
		                
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

		multipleAwaitingActions(driver, Employee, task, Enter);



		}//else


		}//while

		}	//static


public static void multipleAwaitingActions(WebDriver driver, String Employee, String task, String...Enter) throws InterruptedException
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

		if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+task+"')]")).size()>0) { nextAwaitingStep = task;} //by task

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
		Boxes(driver, Enter);

			
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

		if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep+"')]")).size()>0) {} //by employee name

		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+nextAwaitingStep1+"')]")).size()>0) { nextAwaitingStep = nextAwaitingStep1;} //by task

		else if (inbox_list.findElements(By.xpath("//*[contains(text(), '"+task+"')]")).size()>0) { nextAwaitingStep = task;} //by task

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
				
				while(!(driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size()>0)) {
					a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
				    Thread.sleep(5000);	}
				
				
				
				//start proxy
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Awaiting Action']")));
				nextstep= driver.findElements(By.xpath("//*[text()='Awaiting Action']")).size();
				try {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]/div")).getText();}
				catch(Exception jhv) {nextAwaitingStep1 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[2]/div")).getText();}
		Person2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]")).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='banner'][2]")));
		onBehalfOf22  = driver.findElement(By.xpath("//*[@data-automation-id='banner'][2]")).getText();
		onBehalfOf12= onBehalfOf22.split(":");
		onBehalfof2 =  onBehalfOf12[1].trim();

		if (Person2.contains(onBehalfof2)) {
		}
		else {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			a.moveToElement(driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/following-sibling::td[3]/div //*[@data-automation-id='RELATED_TASK_charm']/parent::li"))).click().build().perform();
				
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Security Profile']"))).build().perform();
			a.moveToElement(driver.findElement(By.xpath("//div[@data-automation-label='Start Proxy']"))).click().build().perform();
			driver.findElement(By.xpath("//button[@data-automation-id='wd-CommandButton_uic_okButton']")).click();}

			//String Step2 = driver.findElement(By.xpath("//*[text()='Awaiting Action']/parent::div/parent::td/preceding-sibling::td[1]")).getText();
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-automation-id='landingPageWelcomeCardHeading']")));
				
			

				
			}
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

			   Enter1.clear();
			   
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
					    field=  field1[0];    field.trim();
					  input= field1[1];       input.trim();
					   
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
						   
//----------------------------------------------------------Request Delegation--------------------------------------------------------						   
						   
							if(driver.findElements(By.xpath("//span[@title = 'Request Delegation Change']")).size()>0 && driver.findElements(By.xpath("//button[@data-automation-id='addRow']")).size()>0) 
							{
								//Add row
								driver.findElement(By.xpath("//button[@data-automation-id='addRow']")).click();
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='dateSectionMonth']")));
								Thread.sleep(1000);
								
								//Begin Date
								WebElement h1 = driver.findElement(By.xpath("//td[contains(@headers, 'columnheader1')]"));
								String[] spaces = Begin_Datei.split("/"); 
					        	String Month= spaces[0];
					        	String Day = spaces[1];
					        	String year = spaces[2];
					        	a.moveToElement(h1.findElement(By.xpath("//label[text()='Begin Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).click().build().perform();
					        	Thread.sleep(500);
					        	a.moveToElement(h1.findElement(By.xpath("//label[text()='Begin Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).sendKeys(Month).build().perform();
					        	Thread.sleep(500);
					        	a.moveToElement(h1.findElement(By.xpath("//label[text()='Begin_Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionDay']"))).click().sendKeys(Day).build().perform();
					        	a.moveToElement(h1.findElement(By.xpath("//label[text()='Begin_Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionYear']"))).click().sendKeys(year).build().perform();
								
					        	//End Date
					        	WebElement h2 = driver.findElement(By.xpath("//td[contains(@headers, 'columnheader2')]"));
								String[] spaces1 = End_Datei.split("/"); 
					        	String Month1= spaces1[0];
					        	String Day1 = spaces1[1];
					        	String year1 = spaces1[2];
					        	a.moveToElement(h2.findElement(By.xpath("//label[text()='End Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).click().build().perform();
					        	Thread.sleep(500);
					        	a.moveToElement(h2.findElement(By.xpath("//label[text()='End Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).sendKeys(Month1).build().perform();
					        	Thread.sleep(500);
					        	a.moveToElement(h2.findElement(By.xpath("//label[text()='End Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionDay']"))).click().sendKeys(Day1).build().perform();
					        	a.moveToElement(h2.findElement(By.xpath("//label[text()='End Date']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionYear']"))).click().sendKeys(year1).build().perform();
					        	
					         	WebElement columndriver1 = driver.findElement(By.xpath("//td[contains(@headers, 'columnheader4)]"));
					        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", columndriver1);
					        	Thread.sleep(1500);
					        	//columndriver.findElement(By.xpath("//td[contains(@headers, 'columnheader8')]")).sendKeys(Keys.CONTROL, Keys.HOME);
					        	//((JavascriptExecutor) driver)
					            //.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
					        	//Thread.sleep(2000);
					        	
								//Delegate
								driver.findElement(By.xpath("//label[text()='Delegate']/parent::div/following-sibling::div/div/div/div/div/div //input")).click();
								driver.findElement(By.xpath("//label[text()='Delegate']/parent::div/following-sibling::div/div/div/div/div/div //input")).sendKeys(delegatei);
								
								//Use Default Alternate
								if (CheckBoxi.equalsIgnoreCase("Yes")) {
								driver.findElement(By.xpath("//label[text()='Use Default Alternate']/parent::div/following-sibling::div/div/div/input")).click();}
								
								else {
								//Alternate Delegate
								driver.findElement(By.xpath("//label[text()='Alternate Delegate']/parent::div/following-sibling::div/div/div/div/div/div //input")).click();
								driver.findElement(By.xpath("//label[text()='Alternate Delegate']/parent::div/following-sibling::div/div/div/div/div/div //input")).sendKeys(AlternateDelegatei);}
								
							}
					
					   
					   

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
			else if(driver.findElements(By.xpath("//*[text()='Approve']")).size()>0){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Approve']")));
				driver.findElement(By.xpath("//*[text()='Approve']")).click();
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
	

public static String input(WebDriver driver, String... Enter) throws InterruptedException 
   {
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 5);
Actions a=new Actions(driver);


if(Enter.length == 0) {}
	else {
		
		   int ctr=0;
		   for(String i: Enter) {
			  // if (ctr>0) {
			   
			   if (i.contains(":")) {
					  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					  fieldm= i.split(":");
					   field12=  fieldm[0];
					   field13= fieldm[1];
			   
					   field1= field13.split("=");
						  field=  field1[0];
						input= field1[1];
			                     
						//Pencil Icon	   
						   if(driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size()>0) { 
							 
							   
							   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
							   
							   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
							   Thread.sleep(500);
							   
							   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
						
							   
							  Boolean h = false;
							 while(h==false)
							 {
								h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
							 }
							   
							   
							   
						   if (driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).size() >0) 
						   { try{driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")).click();}
						   catch(Exception jhbhj) {}
						   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));     }}
						   
						   
				//Add button		   
						   else if(driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size()>0) { 
							 
							   
							   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
							   
							   WebElement Task = driver.findElement(By.xpath("//*[text()='"+field12+"']"));
							   Thread.sleep(500);
							   
							   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
						
							   
							  Boolean h = false;
							 while(h==false)
							 {
								h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field12+"']")));
							 }
							   
							   
							   
						   if (driver.findElements(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).size() >0) 
						   {driver.findElement(By.xpath("//*[text()='"+field12+"']/parent::div/following-sibling::div[2] //*[@title='Add']")).click();
						   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title, 'Undo' ) and contains(@title, '"+field12+"')] //*[contains(@class, 'container')]")));     }
						   }
			   
			   
			   }
			   else {
			   field1= i.split("=");
			  field=  field1[0];
			input= field1[1];}
			   
			   
			   
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			   
			  if(driver.findElements(By.xpath("//*[text()='"+field+"']")).size() > 0) {
			   
			    WebElement Task = driver.findElement(By.xpath("//*[text()='"+field+"']"));
				   
				   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Task);
				   
				   Boolean h = false;
					 while(h==false)
					 {
						h= isVisibleInViewport.isVisibleInViewport(driver.findElement(By.xpath("//*[text()='"+field+"']")));
					 }
			   
			    
			   if(field.equalsIgnoreCase("Team Member Type")) {driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);}
			   else {driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);}   
				   				  
			
			/*   if(field.equalsIgnoreCase("Type")) { 
				   
				   driver.findElement(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/parent::div //*[text()='"+field+"']/parent::div/parent::li //*[@placeholder='Search']")).click();
				   driver.findElement(By.xpath("//*[text()='"+Enter[0]+"']/parent::div/parent::div //*[text()='"+field+"']/parent::div/parent::li //*[@placeholder='Search']")).sendKeys(input);
				   
			   }*/
			   
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
						wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
					catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
						wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
						
							//Reselecting the option   
						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
						if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
							Thread.sleep(1000);
							driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
		              
						else { Thread.sleep(1000);
							driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }
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
				wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")));}
			catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
				wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }}
				
					//Reselecting the option   
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).size()>0) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+input+"')]")).click();}
              
				else { 
					driver.findElement(By.xpath("//*[contains(text(),'"+input+"')]")).click();          }}}  

//------------------------------------------------------Calendar---------------------------------------------------				
			   
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			   if(driver.findElements(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).size()>0) 
		        {
					  try { driver.findElement(By.xpath("//div[contains(@title, 'Edit' ) and contains(@title, '"+field+"')] //*[contains(@class, 'container')]")).click(); }
					  catch(Exception Calendar) {}
					   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@class='wd-icon-container']")));
					   Thread.sleep(1000); 
				   
				 if(driver.findElements(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']")).size()>0) 
			        {
		        	String[] spaces = input.split("/"); 
		        	String Month= spaces[0];
		        	String Day = spaces[1];
		        	String year = spaces[2];
		        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).click().build().perform();
		        	Thread.sleep(500);
		        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).sendKeys(Month).build().perform();
		        	Thread.sleep(500);
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
		        
		        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).click().build().perform();
		        	Thread.sleep(500);
		        	a.moveToElement(driver.findElement(By.xpath("//label[text()='"+field+"']//parent::div/following-sibling::div //*[@data-automation-id='dateSectionMonth']"))).sendKeys(Month).build().perform();
		        	Thread.sleep(500);
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
			   
			   
			     
			  }
			 // }//if ctr>0
			   ctr++;
  		   }//for-each	   
		    
	}

return input; 

   }	

public static void SupervisoryOrganization(WebDriver driver, String Name) throws InterruptedException
{
	   WebDriverWait wait = new WebDriverWait(driver, 25);
	   Actions a=new Actions(driver);
	   
	   
	   String[] Supfield1= Name.split("=");
	   String Supfield=  Supfield1[0];
	   String Supinput= Supfield1[1];
	   
	   if(driver.findElements(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div/following-sibling::div/ul/li")).size()>0) {
	   
	   String selectedItem = driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div/following-sibling::div/ul/li")).getText();
	   
	   if(selectedItem.equalsIgnoreCase(Supinput)) {}   
	   else {		   
		   
		   String[] SplitfieldInput= Name.split("=");
		   Supfield= SplitfieldInput[0];
		   Supinput=SplitfieldInput[1];
		   
		   if(Supinput.contains("  ")) {
				Supinput = Supinput.replaceAll("  ", " ");}
		   
			if(Supinput.contains("_")) {
				Supinput1 = Supinput.replaceAll("_", " ");}
			if(Supinput.contains("  ")) {
				Supinput1 = Supinput.replaceAll("  ", " ");}
				
				Supinput1=SplitfieldInput[1];
				Supinput1 = Supinput1.replace("(", "=");

					   String[] SupName1= Supinput1.split("=");					
						String Supoutput = SupName1[1];
						Supoutput = Supoutput.trim();
					   System.out.println(Supoutput);
		    
		   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //*[@data-automation-id='DELETE_charm']")).click();

		   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
			
			   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(Supoutput, Keys.ENTER);
		
			   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
			   //wait time	
		try { 	WebDriverWait wait3 = new WebDriverWait(driver, 3);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")));}
	catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
		
			//Reselecting the option   
		
		if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).size()>0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).click();}
      
		else { 
			
			driver.findElement(By.xpath("//*[contains(text(),'"+Supinput+"')]")).click();          }

	   }
} 

	   else {
		   String[] SplitfieldInput= Name.split("=");
		   Supfield= SplitfieldInput[0];
		   Supinput=SplitfieldInput[1];
		   
		   if(Supinput.contains("  ")) {
				Supinput = Supinput.replaceAll("  ", " ");}
		   
			if(Supinput.contains("_")) {
				Supinput1 = Supinput.replaceAll("_", " ");}
			if(Supinput.contains("  ")) {
			Supinput1 = Supinput.replaceAll("  ", " ");}
				
				Supinput1=SplitfieldInput[1];
				Supinput1 = Supinput1.replace("(", "=");

					   String[] SupName1= Supinput1.split("=");					
						String Supoutput = SupName1[1];
						Supoutput = Supoutput.trim();
					   System.out.println(Supoutput);
					   
		   
		   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
			
			   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(Supoutput, Keys.ENTER);
		
			   
			   //wait time	
		try { 	WebDriverWait wait3 = new WebDriverWait(driver, 3);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")));}
	catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
		
			//Reselecting the option   
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).size()>0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).click();}
      
		else { driver.findElement(By.xpath("//*[contains(text(),'"+Supinput+"')]")).click();    }

	   
	   }
	   

}//SuperOrg Static

public static void SupervisoryOrganization1(WebDriver driver, String Name, String SupOrg) throws InterruptedException
{
	   WebDriverWait wait = new WebDriverWait(driver, 25);
	   Actions a=new Actions(driver);
	   
	   
	   String[] Supfield1= SupOrg.split("=");
	   String Supfield=  Supfield1[0];
	   String Supinput= Supfield1[1];
	   
	   if(driver.findElements(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div/following-sibling::div/ul/li")).size()>0) {
	   
	   String selectedItem = driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div/following-sibling::div/ul/li")).getText();
	   
	   if(selectedItem.equalsIgnoreCase(Supinput)) {}   
	   else {		   

		    
		   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //*[@data-automation-id='DELETE_charm']")).click();

		   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
			
			   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(Name, Keys.ENTER);
		
			   
			   //wait time	
		try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")));}
	catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
		
			//Reselecting the option   
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).size()>0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).click();}
      
		else { 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'"+Supinput+"')]")).click();          }

	   }
} 

	   else {
		  
		   
		 

		   
		 // BWW_0685_GM_Team  (George Willard (100148717))
		 // BWW_0685_GM_Store_Mgmt  (George Willard (100148717)) 
		  

		   
		   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).click();
			
			   driver.findElement(By.xpath("//label[text()='"+Supfield+"']//parent::div/following-sibling::div/div/div/div/div/div/div //input")).sendKeys(Name, Keys.ENTER);
		
			   
			   //wait time	
		try { 	WebDriverWait wait3 = new WebDriverWait(driver, 2);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")));}
	catch(Exception e) { WebDriverWait wait4 = new WebDriverWait(driver, 7);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Search Results']"))); }
		
			//Reselecting the option   
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if(driver.findElements(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).size()>0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@data-automation-id='selectedItem' and contains(@title,'"+Supinput+"')]")).click();}
      
		else {Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(text(),'"+Supinput+"')]")).click();    }

	   
	   }
	   

}//SuperOrg Static

public static ArrayList<String> getExcelData(String Efield, String Efield1, String Efield2) throws IOException 
{

	// TODO Auto-generated method stub

	//File Input Stream argument
	ArrayList<String> Values=new ArrayList<String>();
	ArrayList<String> Values2=new ArrayList<String>();
	FileInputStream fis=new FileInputStream("/Users/pos/Documents/Test1.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	int sheets = workbook.getNumberOfSheets();
	
	for(int i=0; i<sheets; i++)
	{
        if(workbook.getSheetName(i).equalsIgnoreCase(Efield)){
		XSSFSheet sheet= workbook.getSheetAt(i);
		
		//Identify Testcases column by scanning the entire 1st row
		Iterator<Row> rows= sheet.iterator();  //sheet is collection of rows (entire row - it checks entire rows to find the row the element present in)
		Row firstrow= rows.next();
		
		Iterator<Cell> ce= firstrow.iterator(); //row is collection of cell
	
		
		int k=0;
		int column=0;
		while(ce.hasNext()) 
		{
			Cell value=ce.next();
			
			if(value.getStringCellValue().equalsIgnoreCase(Efield1))
			{
				column=k;
			
			}
			
		k++;}
		
		
	
		//Iterate through column (By iterating through entire rows and in column)
		while(rows.hasNext()) 
		{
			Row r = rows.next();
			
		
	try { 
			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(Efield2))
			{
		
				
				Iterator<Cell> cv=r.cellIterator();
			
				
				while(cv.hasNext()) 
				{
					Cell c=cv.next();
					
					if(c.getCellType()==CellType.STRING) {Values.add(c.getStringCellValue());}
					else {Values.add(NumberToTextConverter.toText(c.getNumericCellValue()));}
				}
			
				
			
				
			for(int q=0; q<Values.size(); q++) 
			{
				String Values1;
				
				if(Values.size()==3) 
				{
					Values1 = Values.get(1) + "=" + Values.get(2);
					
					Values.clear();
					
					Values2.add(Values1);
				}
				else if(Values.size()==4){	
					
					Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3);
				
				Values.clear();
				
				Values2.add(Values1);}
				
               else if(Values.size()==6){	
					
				Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5);
				
				Values.clear();
				
				Values2.add(Values1);}
				
               else if(Values.size()==8){	
					
					Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5)+"&" +Values.get(6)+ "="+Values.get(7);
					
					Values.clear();
					
					Values2.add(Values1);}
				
            else if(Values.size()==10){	
					
					Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5)+"&" +Values.get(6)+ "="+Values.get(7)+"&" +Values.get(8)+ "="+Values.get(9);
					
					Values.clear();
					
					Values2.add(Values1);}
               else if(Values.size()==12){	
					
      						Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5)+"&" +Values.get(6)+ "="+Values.get(7)+"&" +Values.get(8)+ "="+Values.get(9)+"&" +Values.get(10)+ "="+Values.get(11);
      						
      						Values.clear();
      						
      						Values2.add(Values1);} 
			
			}
			
			for(String g: Values2) 
			{
				if (g.contains("&0"))
				{
				String h = g.replaceAll("&0=0", "");
				Values2.remove(g);
					Values2.add(h);
				}
			}
			
			for(String g: Values2) 
			{
				
				if (g.contains("=0"))
				{
					if(g.contains("Date") || g.contains("From") || g.contains("To")) {}
					else{String h = g.replaceAll("=0", "");
				Values2.remove(g);
					Values2.add(h);
					}}
			}
			for(String g: Values2) 
			{
				if (g.contains("0:"))
				{
				String h = g.replaceAll("0:", "");
				Values2.remove(g);
					Values2.add(h);
				}
			}
			
			
			}
	
			}
	catch(Exception NoValue) {}
			
		}
		
		
        }
	}
		
return Values2;
}

}