package images_and_link_validation;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLinks {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		 driver.get("https://adc.d211.org");
        //   driver.get("https://makemysushi.com/404?");
		// driver.get("https://www.itexps.net/");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String url = ele.getAttribute("href");

			verifyLinkActive(url);

		}
                        // https://youtu.be/WyheLWhk6QE
	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200)
				System.out.println(linkUrl + " >> " + httpURLConnect.getResponseCode() + " >> "
						+ httpURLConnect.getResponseMessage());
			else
				System.err.println(linkUrl + " >> " + httpURLConnect.getResponseCode() + " >> "
						+ httpURLConnect.getResponseMessage());

			httpURLConnect.disconnect();

		} catch (Exception e) {

		}
	}

}
