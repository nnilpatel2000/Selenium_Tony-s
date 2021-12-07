package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import pageObjects.ShoppingPage;

public class ShoppingSteps {
	public static WebDriver driver;

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cap = new CreateAccountPage(driver);
		driver.manage().window().maximize();
		driver.get("https://www.tonysfreshmarket.com");

	}

	@Then("User closes welcome message box")
	public void user_closes_welcome_message_box() {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.closewelcome();
	}

	@Then("User clicks Sign in link")
	public void user_clicks_sign_in_link() throws Exception {
		Thread.sleep(1500);
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.signinlink();

	}

	@Then("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.enterloginvalue(Email, Password);
	}
	
	@Then("User click on Login button")
	public void user_click_on_Login_button() throws Exception {
		Thread.sleep(1500);
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.login();
	}

	@When("User clicks on Shop")
	public void user_clicks_on_shop() throws Exception {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.clickshop();
		
	}

	@Then("User adds eggs and limes")
	public void user_adds_eggs_and_limes() throws Exception {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.addproduct();
		
	}

	@Then("User hovers and clicks on Checkout button")
	public void user_hovers_and_clicks_on_checkout_button() throws Exception {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.hoverandcheckout();
		
	}

	@Then("User clicks on pick up day dd menu and selects day as {string}")
	public void user_clicks_on_pick_up_day_dd_menu_and_selects_day_as(String Day) {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.Selectday(Day);
		
	}

	@Then("User clicks on time dd menu and selects time as {string}")
	public void user_clicks_on_time_dd_menu_and_selects_time_as(String Time) {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.Selecttime(Time);
		
	}

	@Then("User types instructions")
	public void user_types_instructions() throws Exception {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.typemessage();
		
	}

	@Then("User clicks on begin Checkout button")
	public void user_clicks_on_begin_checkout_button() {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.clickbegincheckout();
		
	}

	@Then("User enters CC holder name as {string}")
	public void user_enters_cc_holder_name_as(String CCName) throws Exception {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.enterccname(CCName);
	}

	@Then("User enters CC number as {string}")
	public void user_enters_cc_number_as(String CCNumber) throws Exception {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.enterccnumber(CCNumber);
		
	}

	@Then("User enters CVV number as {string}")
	public void user_enters_cvv_number_as(String CVV) {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.entercvv(CVV);
	
	}

	@Then("User enters Expiration Date as {string}")
	public void user_enters_expiration_date_as(String Expiry) throws Exception {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.enterexpiry(Expiry);
		
	}
	
	@Then("User click on Sign out")
	public void user_click_sign_out() {
		ShoppingPage shop = PageFactory.initElements(driver, ShoppingPage.class);
		shop.clicksignout();
	}
	
	@Then("User closes the browser")
	public void user_closes_the_browser() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
