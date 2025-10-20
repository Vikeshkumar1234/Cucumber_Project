package common_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Loading_Browser_Page {
	   public static WebDriver dr;
       public static void Chrome_browser()
       {
    	   dr=new ChromeDriver();
       }
       public static void edge_browser()
       {
    	   dr=new EdgeDriver();
       }
       public static void firefox_browser()
       {
    	   dr=new FirefoxDriver();
       }
}
