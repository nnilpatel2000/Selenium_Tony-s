package images_and_link_validation;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {

	public static void main(String[] args) throws Exception {
		VerifyBrokenImage();

	}

	public static void VerifyBrokenImage() throws Exception {

		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.theworldsworstwebsiteever.com/");
	//	driver.get("https://www.itexps.net/");

		Thread.sleep(13000);

		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		
		for (WebElement image : images) {

			String imageSrc = image.getAttribute("src");
			
		// https://youtu.be/6NXZQYs-Eig
			
			try {
				URL url = new URL(imageSrc);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.connect();
				
				if(httpURLConnection.getResponseCode() == 200)
					System.out.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> " + httpURLConnection.getResponseMessage());
				else
					System.err.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> " + httpURLConnection.getResponseMessage());

				httpURLConnection.disconnect();
			
			} catch (Exception e) {
				
			System.err.println(imageSrc);
			}
		
		}
		
		driver.quit();

	}

}
