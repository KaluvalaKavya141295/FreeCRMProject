package com.automationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.automationFramework.util.TestUtil;
import com.automationFramework.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//create a constructor
	public TestBase() {
		try {
		prop=new Properties();
		FileInputStream fo=new FileInputStream("C:\\Users\\K Yadava Reddy\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\automationFramework\\config\\config.properties");
		prop.load(fo);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//create an initialization method
	public static void initialization() {
		//read the browser
		String browsername = prop.getProperty("browser");
		if (browsername.equals("firefox")) {
			System.setProperty("Webdriver.gecko.driver", "C:\\Webdrivers\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		else if (browsername.equals("chrome")) {
			System.setProperty("Webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
			driver=new ChromeDriver();
			}
		else if (browsername.equals("IE")) {
			System.setProperty("Webdriver.ie.driver", "C:\\Webdrivers\\InternetExplorer.exe");
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("No browser present");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void register_url() {
		driver.get(prop.getProperty("register_url"));
		
	}
	

}
