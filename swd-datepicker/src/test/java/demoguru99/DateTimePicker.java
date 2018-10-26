package demoguru99;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateTimePicker {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		//driver.close();
	}
	
	@Test
	public void dateTimePicker() throws Exception {
		driver.get("http://demo.guru99.com/test/");
		
		//Get the input field for the date time picker control
		//WebElement dateBox = driver.findElement(By.xpath("//form[@name='bdate']/input[@name='bdaytime']"));
		WebElement dateBox = driver.findElement(By.cssSelector("[name='bdaytime']"));
		
		//Complete date for 11/31/2018 using mm/dd/yyyy
		dateBox.sendKeys("11312018");
		
		//Move to time field with TAB
		dateBox.sendKeys(Keys.TAB);
		
		//Complete time for 10:50 PM
		dateBox.sendKeys("1050");
	}
}
