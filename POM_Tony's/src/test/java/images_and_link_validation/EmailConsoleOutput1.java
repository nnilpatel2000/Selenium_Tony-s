package images_and_link_validation;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailConsoleOutput1 {
	
	 WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();

        driver.get("https://adc.d211.org/Page/5209");

        Thread.sleep(3000);

          

        List<WebElement> aTags = driver.findElements(By.tagName("a"));

        for (WebElement e : aTags) {

            String text = e.getText();

            if (text.contains("@")) {

                System.out.println(text);

            }

        }

	}

}
