package demostelerik;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DateTimePicker {

	// Date and Time to be set in textbox
	String dateTime = "01/26/2019 8:30 PM";

	private static WebDriver driver;

	@Test
	public void dateTimePicker() throws Exception {

		// Set path for driver exe
		/*System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();*/

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='optanon-allow-all']")).click();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Find the button to open the calendar
		WebElement selectDatebtn = driver.findElement(By.xpath(
				"//div[@id='example']/div/span//span[@class='k-select']/span[@class='k-link k-link-date']/span"));

		selectDatebtn.click();

		// button to move next in calendar
		WebElement nextLink = driver.findElement(By.xpath(
				"//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));

		// button to click in center of calendar header
		WebElement midLink = driver.findElement(By.xpath("//*[@id=\"datetimepicker\"]"));

		// button to move previous month in calendar
		WebElement previousLink = driver.findElement(By.xpath(
				"//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));

		// Split the date time to get only the date part
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

		// get the year difference between current year and year to set in calander
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);

		int diffmonth = (Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR)) * 12
				- (Calendar.getInstance().get(Calendar.MONTH) + 1 - Integer.parseInt(date_dd_MM_yyyy[0]));

		midLink.click();

		if (yearDiff != 0) {

			// if you have to move next year

			if (yearDiff > 0) {

				// for (int i = 0; i < yearDiff; i++) {
				for (int i = 0; i < diffmonth; i++) {

					System.out.println("Year Diff->" + i);

					nextLink.click();

				}

			}

			// if you have to move previous year

			else if (yearDiff < 0) {

				for (int i = 0; i < (yearDiff * (-1)); i++) {

					System.out.println("Year Diff->" + i);

					previousLink.click();

				}

			}

		}
		Thread.sleep(1000);

		// Get all months from calendar to select correct one

		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath(
				"//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));

		list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();

		Thread.sleep(1000);

		// get all dates from calendar to select correct one
		List<WebElement> list_AllDateToBook = driver.findElements(By.xpath(
				"//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));

		// list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

		/// FOR TIME

		WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

		// click time picker button

		selectTime.click();

		// get list of times

		List<WebElement> allTime = driver.findElements(
				By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));

		dateTime = dateTime.split(" ")[1] + " " + dateTime.split(" ")[2];

		// select correct time

		for (WebElement webElement : allTime) {

			if (webElement.getText().equalsIgnoreCase(dateTime))

			{

				webElement.click();

			}

		}

	}
}
