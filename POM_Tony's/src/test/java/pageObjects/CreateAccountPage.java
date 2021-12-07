package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountPage {
	public WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//img[@alt='Close']")
	WebElement welcome;

	@FindBy(how = How.LINK_TEXT, using = "Create an Account")
	WebElement caccount;

	@FindBy(how = How.NAME, using = "fp-input-first_name")
	WebElement fname;

	@FindBy(how = How.NAME, using = "fp-input-last_name")
	WebElement lname;

	@FindBy(how = How.NAME, using = "fp-input-email")
	WebElement email;

	@FindBy(how = How.NAME, using = "reenter-email")
	WebElement re_email;

	@FindBy(how = How.NAME, using = "fp-input-password")
	WebElement password;

	@FindBy(how = How.NAME, using = "re-password")
	WebElement re_password;

	@FindBy(how = How.XPATH, using = "//div[@class='fp-dropdown fp-dropdown-store fp-has-value']")
	WebElement storemenu;

	@FindBy(how = How.XPATH, using = "//span[@class='fp-dropdown-menu']//ul[@class='fp-dropdown-list']//li//a")
	WebElement selectstore;

	@FindBy(how = How.XPATH, using = "//div[@data-role='dropdown-month']")
	WebElement monthmenu;

	@FindBy(how = How.XPATH, using = "//div[@data-role='dropdown-month']//ul[@class='fp-dropdown-list']//li//a")
	WebElement selectmonth;

	@FindBy(how = How.NAME, using = "fp-input-date_of_birth_day")
	WebElement bday;

	@FindBy(how = How.XPATH, using = "//div[@data-role='dropdown-year']")
	WebElement yearmenu;

	@FindBy(how = How.XPATH, using = "//div[@data-role='dropdown-year']//ul[@class='fp-dropdown-list']//li//a")
	WebElement selectyear;

	@FindBy(how = How.NAME, using = "fp-input-address_1")
	WebElement address;

	@FindBy(how = How.NAME, using = "fp-input-city")
	WebElement city;

	@FindBy(how = How.XPATH, using = "//div[@data-role='region']")
	WebElement statemenu;

	@FindBy(how = How.XPATH, using = "//div[@data-role='region']//ul[@class='fp-dropdown-list']//li//a")
	WebElement selectstate;

	@FindBy(how = How.NAME, using = "fp-input-postal_code")
	WebElement pcode;

	@FindBy(how = How.NAME, using = "fp-input-phone")
	WebElement pphone;

	public void closemsg() {

		welcome.click();

	}

	public void createaccount() {

		caccount.click();

	}

	public void firstname(String Fname) {

		fname.sendKeys(Fname);

	}

	public void lastname(String Lname) {

		lname.sendKeys(Lname);

	}

	public void emails(String Email, String Re_email) {

		email.sendKeys(Email);
		re_email.sendKeys(Re_email);

	}

	public void passwords(String Password, String Repassword) {

		password.sendKeys(Password);
		re_password.sendKeys(Repassword);

	}

	public void Storemenu() {

		storemenu.click();

	}

	public void Selectstore(String featurestore) {

		List<WebElement> storelist = driver.findElements(
				By.xpath("//span[contains(@class,'fp-dropdown-menu')]//ul[@class='fp-dropdown-list']//li//a"));

		for (WebElement store : storelist) {

			String storetext = store.getText();

			if (storetext.equals(featurestore)) {
				store.click();
				break;
			}

			System.out.println(storetext);
		}
	}

	public void Monthmenu() {

		monthmenu.click();

	}

	public void Selectmonth(String featuremonth) {

		List<WebElement> monthlist = driver
				.findElements(By.xpath("//div[@data-role='dropdown-month']//ul[@class='fp-dropdown-list']//li//a"));

		for (WebElement month : monthlist) {

			String monthtext = month.getText();

			if (monthtext.equals(featuremonth)) {
				month.click();
				break;
			}

			System.out.println(monthtext);
		}

	}

	public void Day(String day) {

		bday.sendKeys(day);

	}

	public void Yearmenu() {

		yearmenu.click();

	}

	public void Selectyear(String featureyear) {

		List<WebElement> yearlist = driver
				.findElements(By.xpath("//div[@data-role='dropdown-year']//ul[@class='fp-dropdown-list']//li//a"));

		for (WebElement year : yearlist) {

			String yeartext = year.getText();

			if (yeartext.equals(featureyear)) {
				year.click();
				break;
			}

			System.out.println(yeartext);
		}

	}

	public void address(String Address, String City) {

		address.sendKeys(Address);
		city.sendKeys(City);

	}

	public void Statemenu() {

		statemenu.click();

	}

	public void Selectstate(String featurestate) {

		List<WebElement> statelist = driver
				.findElements(By.xpath("//div[@data-role='region']//ul[@class='fp-dropdown-list']//li//a"));

		for (WebElement state : statelist) {

			String statetext = state.getText();

			if (statetext.equals(featurestate)) {
				state.click();
				break;
			}

			System.out.println(statetext);
		}

	}

	public void phone(String code, String phone) {

		pcode.sendKeys(code);
		pphone.sendKeys(phone);

	}

}
