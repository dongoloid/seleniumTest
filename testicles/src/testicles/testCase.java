package testicles;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

public class testCase {

	private WebDriver driver;
		
	@Test
	public void pageTest(){
		driver.navigate().to("https://addons.mozilla.org/en-us/firefox/addon/selenium-ide/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@placeholder='search for add-ons']")).clear();
	    driver.findElement(By.xpath("//*[@placeholder='search for add-ons']")).sendKeys("sad");
	    driver.findElement(By.xpath("//*[@id='search']/button")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
	}
	
	@BeforeMethod
	public void Setup(){try
	{		
		//System.setProperty("webdriver.chrome.driver", "C:/Users/rhodenel.s.omana/Downloads/installer/chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		   
		driver=new ChromeDriver();
		  String windowsHandle=driver.getWindowHandle();
		  assertEquals(true, windowsHandle.length()>0);
		}
		catch(Exception e)
		{
		     System.out.print("test");
		}
		
	}
	
	@AfterMethod
	public void TearDown(){
		 driver.close();
		 driver.quit();
	}
	
}
