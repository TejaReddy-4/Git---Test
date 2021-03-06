import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class isVisibleInViewport {

	public static Boolean isVisibleInViewport(WebElement element) {
		  WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

		   
		  return (Boolean)((JavascriptExecutor)driver).executeScript(
		      "var elem = arguments[0],                 " +
		      "  box = elem.getBoundingClientRect(),    " +
		      "  cx = box.left + box.width / 2,         " +
		      "  cy = box.top + box.height / 2,         " +
		      "  e = document.elementFromPoint(cx, cy); " +
		      "for (; e; e = e.parentElement) {         " +
		      "  if (e === elem)                        " +
		      "    return true;                         " +
		      "}                                        " +
		      "return false;                            "
		      , element);
		

		  
	}
	
	
	
}


