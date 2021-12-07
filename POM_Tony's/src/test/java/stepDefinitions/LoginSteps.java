package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
	
	public static WebDriver driver;
	public LoginPage lp;
	public static String title;
	public static String title1;
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lp = new LoginPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	
	}

	@Then("User closes welcome message")
	public void user_closes_welcome_message() throws Exception {
		Thread.sleep(2500);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.closemsg();
		
	}

	@Then("User clicks Sign in")
	public void user_clicks_sign_in() throws Exception {
		Thread.sleep(1500);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.sign();
	    
	}

	@When("user gets the title of the Login page")
	public void user_gets_the_title_of_the_login_page() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		title = lp.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	    
	}

	@Then("Login page title should be {string}")
	public void login_page_title_should_be(String expectedTitleName) {
		
		Assert.assertTrue(title.contains(expectedTitleName));
	   
	}

	@Then("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws Exception {
		Thread.sleep(1500);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.enterloginvalue(email, password);
	   
	}

	@Then("Create an account here link should be displayed")
	public void create_an_account_here_link_should_be_displayed() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(lp.iscreateaccountLinkExist());
	   
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue(lp.isForgotPwdLinkExist());
	}

	@Then("User click on Login")
	public void user_click_on_login() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.login();
	   
	}

	@Then("Home Page Title should be {string}")
	public void home_page_title_should_be(String expectedName) throws Exception {
		Thread.sleep(1500);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		title1 = driver.getTitle();
		System.out.println("Page title is: " + title1);
		Assert.assertTrue(title1.contains(expectedName));
		
	    
	}

	@When("User click on Sign out link")
	public void user_click_on_sign_out_link() throws Exception {
		Thread.sleep(1500);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.signout();
	    
	}

	@Then("Close browser")
	public void close_browser() {
		
		driver.close();
	   
	}


}
