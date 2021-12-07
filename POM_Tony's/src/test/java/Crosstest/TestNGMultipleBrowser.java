package Crosstest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultipleBrowser {

	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("Browser name is : " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\data\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\data\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

	}

	@Test
	public void test() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.tonysfreshmarket.com/");

		driver.findElement(By.xpath("//img[@alt='Close']")).click();

		driver.findElement(By.linkText("Sign In")).click();

		Thread.sleep(1500);

		driver.findElement(By.name("fp-input-email")).click();

		driver.findElement(By.name("fp-input-email")).clear();

		driver.findElement(By.name("fp-input-email")).sendKeys("nnilpatel.2000@gmail.com");

		driver.findElement(By.name("fp-input-password")).click();

		driver.findElement(By.name("fp-input-password")).clear();

		driver.findElement(By.name("fp-input-password")).sendKeys("Nil@12345");

		driver.findElement(By.xpath("//div[@id='account']/div/div[3]/div/div/form/div[2]/button")).click();

		Thread.sleep(5000);

		WebElement elem1 = driver.findElement(By.xpath("//li[@id='menu-item-67']/a/span"));

		Thread.sleep(4000);

		Actions act = new Actions(driver);

		Action a1 = act.moveToElement(elem1).build();

		a1.perform();

		Thread.sleep(1000);

		elem1.click();

		Thread.sleep(2000);

		driver.findElement(

				By.xpath("//div[@data-product-id='1564405684702322348']//span[@class='fp-btn-icon fp-btn-increment']"))

				.click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@data-product-id='2311246']//span[@class='fp-btn-icon fp-btn-increment']"))

				.click();

		Thread.sleep(5000);

		js.executeScript("window.scrollTo(0,0)");

		Thread.sleep(1000);

		WebElement elem2 = driver.findElement(By.xpath("//div[@id='mini-list-indicator']"));

		act = new Actions(driver);

		Action a2 = act.moveToElement(elem2).build();

		a2.perform();

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(

				"//div[@class='row fp-list-header-actions']//div[@class='col-xs-6 col-sm fp-col-checkout']//a[contains(text(),'Checkout')]")));

		WebElement elem3 = driver.findElement(By.xpath(

				"//div[@class='row fp-list-header-actions']//div[@class='col-xs-6 col-sm fp-col-checkout']//a[contains(text(),'Checkout')]"));

		elem3.click();

		driver.findElement(By.xpath("//span[@class='fp-dropdown fp-dropdown-day']//span[@class='fp-dropdown-icon']"))

				.click();

		driver.findElement(By.linkText("Fri 09/17")).click();

		driver.findElement(By.xpath("//span[@class='fp-dropdown fp-dropdown-hour']//button[@type='button']")).click();

		driver.findElement(By.linkText("2:00pm-3:00pm")).click();

		driver.findElement(By.name("fp-input-fulfillment_note")).click();

		driver.findElement(By.name("fp-input-fulfillment_note")).clear();

		driver.findElement(By.name("fp-input-fulfillment_note"))

				.sendKeys("Please leave items at the front door. Thank you.");

		driver.findElement(By.xpath("//button[normalize-space()='Begin Checkout']")).click();

		Thread.sleep(10000);

		js.executeScript("window.scrollBy(0,1950)");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-cardholder_name']//iframe"))

				.click();

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-cardholder_name']//iframe"))

				.sendKeys("nil patel");

		Thread.sleep(1500);

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-cc_number']//iframe"))

				.click();

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-cc_number']//iframe"))

				.sendKeys("1122445566778899");

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-cvv_code']//iframe"))

				.click();

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-cvv_code']//iframe"))

				.sendKeys("007");

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-expiry_date']//iframe"))

				.click();

		driver.findElement(By.xpath("//div[@class='row fp-payment-method']//div[@id='input-expiry_date']//iframe"))

				.sendKeys("10 / 25");

		Thread.sleep(1500);

		driver.findElement(By.xpath("//a[contains(text(), 'Sign Out') and @class='fp-logout-link']")).click();

		Thread.sleep(2000);
	}

	@AfterClass
	public void close() {

		driver.close();
		System.out.println("Test Completed Successfully");

	}

}
