/*package turkishairline;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TurkishAirlinesDatePickerTest {

	*//**
	 * Created by ONUR BASKIRT on 13.08.2016.
	 *//*
	public class TurkishAirlinesDatePickerTest {
	 
	    static WebDriver driver;
	    private String today;
	 
	    //Setup Driver
	    @BeforeClass
	    public static void setupTest() {
	        driver = new FirefoxDriver();
	        //driver.navigate().to("http://www.turkishairlines.com/tr-tr/");
	        driver.navigate().to("https://www.turkishairlines.com/en-int/");
	        
	        driver.manage().window().maximize();
	    }
	 
	    @Test
	    public void datePickerTest() {
	        //Declare a implicit wait for synchronisation
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	        //Get Today's number
	        today = getCurrentDay();
	        System.out.println("Today's number: " + today + "\n");
	 
	        //Click and open the datepickers
	        driver.findElement(By.xpath("//*[fusion_builder_container hundred_percent="yes" overflow="visible"][fusion_builder_row][fusion_builder_column type="1_1" background_position="left top" background_color="" border_size="" border_color=/"/" border_style="solid" spacing="yes" background_image=/"/" background_repeat=/"no-repeat/" padding=/"/" margin_top=/"0px/" margin_bottom=/"0px/" class=/"/" id=/"/" animation_type=/"/" animation_speed=/"0.3/" animation_direction=/"left/" hide_on_mobile=/"no/" center_content="no" min_height="none"][@id='godate']")).click();
	 
	        //This is from date picker table
	        WebElement dateWidgetFrom = driver.findElement(By.xpath(".//*[@id='calendar-100000000']/div[3]/table/tbody"));
	 
	        //This are the rows of the from date picker table
	        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
	 
	        //This are the columns of the from date picker table
	        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
	 
	        //DatePicker is a table. Thus we can navigate to each cell
	        //and if a cell matches with the current date then we will click it.
	        for (WebElement cell: columns) {
	            
	            //If you want to click 18th Date
	            if (cell.getText().equals("18")) {
	            
	            //Select Today's Date
	            if (cell.getText().equals(today)) {
	                cell.click();
	                break;
	            }
	        }
	 
	        //Wait for 4 Seconds to see Today's date selected.
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    //Close Driver
	    @AfterClass
	    public static void quitDriver() {
	        driver.quit();
	    }
	 
	    //Get The Current Day
	    private String getCurrentDay (){
	        //Create a Calendar Object
	        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	 
	        //Get Current Day as a number
	        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	        System.out.println("Today Int: " + todayInt +"\n");
	 
	        //Integer to String Conversion
	        String todayStr = Integer.toString(todayInt);
	        System.out.println("Today Str: " + todayStr + "\n");
	 
	        return todayStr;
	    }
	}
}
*/