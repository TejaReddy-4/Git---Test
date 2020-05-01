import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {
	static ArrayList<String> Enter1 =new ArrayList<String>();
	static ArrayList<String> DelegationTasks =new ArrayList<String>();
	static ArrayList<String> DelegationTasks1 =new ArrayList<String>();
	static String Enter[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Enter1 = inbox.getExcelData("Hire", "Hire", "Hire - Task");
		
		System.out.println(Enter1);

	
}}
