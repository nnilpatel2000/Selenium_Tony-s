package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;
import pageObjects.CreateAccountPage;

public class CreateAccountSteps {
	public WebDriver driver;
	
	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   cap = new CreateAccountPage(driver);
		   driver.manage().window().maximize();
		driver.get("https://www.tonysfreshmarket.com");

	}

	@Then("user closes welcome message")
	public void user_closes_welcome_message() {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.closemsg();

	}

	@Then("user clicks on create account link")
	public void user_clicks_on_create_account_link() throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(2000);
		cap.createaccount();

	}

	@Then("user enters Firstname as {string}")
	public void user_enters_firstname_as(String fname) throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(1500);
		cap.firstname(fname);

	}

	@Then("user enters Lastname as {string}")
	public void user_enters_lastname_as(String lname) throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(1500);
		cap.lastname(lname);

	}

	@Then("User enters Email and re_enters email address")
	public void user_enters_email_and_re_enters_email_address() {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.emails("tonys@fresh.com", "tonys@fresh.com");
	    
	}

	@Then("User enters password and re_enters password")
	public void user_enters_password_and_re_enters_password() throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(2000);
		cap.passwords("TFM@123", "TFM@123");

	}

	@Then("User clicks store selection dropdown menu")
	public void user_clicks_store_selection_dropdown_menu() throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(2000);
		cap.Storemenu();

	   
	}

	@Then("User selects Store as {string}")
	public void user_selects_store(String store) {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.Selectstore(store);
		//System.out.println(store);

	}

	@Then("User clicks month selection dropdown menu")
	public void user_clicks_month_selection_dropdown_menu() throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(1000);
		cap.Monthmenu();
	    
	}

	@Then("User selects Month as {string}")
	public void user_selects_month(String month) {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.Selectmonth(month);

	}

	@Then("User enters Day as {string}")
	public void user_enters_day_as(String day) {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.Day(day);

	}

	@Then("User clicks year selection dropdown menu")
	public void user_clicks_year_selection_dropdown_menu() {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.Yearmenu();

	}

	@Then("User selects year as {string}")
	public void user_selects_year(String year) {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.Selectyear(year);

	}

	@Then("User enters Address as {string} and City as {string}")
	public void user_enters_address_as_and_city_as(String address, String city) {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.address(address, city);

	}

	@Then("User clicks state selection dropdown menu")
	public void user_clicks_state_selection_dropdown_menu() throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(1000);
		cap.Statemenu();

	}

	@Then("User selects State as {string}")
	public void user_selects_state(String state) {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.Selectstate(state);

	}

	@Then("User enters postal code and phone")
	public void user_enters_postal_code_and_phone() {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		cap.phone("60016", "998877665544");

	}

	@Then("user close the browser")
	public void user_close_the_browser() throws Exception {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		Thread.sleep(2000);
		driver.close();

	}

}
