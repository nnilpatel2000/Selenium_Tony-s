package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage {
	public WebDriver driver;
	

	public ShoppingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//img[@alt='Close']")
    WebElement welcome;
    
    @FindBy(how = How.XPATH, using = "//a[@class='fp-login-link']")
    WebElement signin;
   
    @FindBy(how = How.NAME, using = "fp-input-email")
    WebElement userName;

    @FindBy(how = How.NAME, using = "fp-input-password")
    WebElement password;
    
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign In')]")
    WebElement submitBtn;
    
    @FindBy(how = How.XPATH, using = "//li[@id='menu-item-67']/a/span")
    WebElement shop;
    
    @FindBy(how = How.XPATH, using = "//div[@data-product-id='1564405684702322348']//span[@class='fp-btn-icon fp-btn-increment']")
    WebElement eggs;
    
    @FindBy(how = How.XPATH, using = "//div[@data-product-id='2311246']//span[@class='fp-btn-icon fp-btn-increment']")
    WebElement limes;
    
    @FindBy(how = How.XPATH, using = "//div[@id='mini-list-indicator']")
    WebElement checkouthover;
    
    @FindBy(how = How.XPATH, using = "//div[@class='row fp-list-header-actions']//div[@class='col-xs-6 col-sm fp-col-checkout']//a[contains(text(),'Checkout')]")
    WebElement checkout;
    
    @FindBy(how = How.XPATH, using = "//span[@class='fp-dropdown fp-dropdown-day']//span[@class='fp-dropdown-icon']")
    WebElement datedd;

    @FindBy(how = How.LINK_TEXT, using = "Fri 09/17")
    WebElement date;
    
    @FindBy(how = How.XPATH, using = "//span[@class='fp-dropdown fp-dropdown-hour']//button[@type='button']")
    WebElement hoursdd;

    @FindBy(how = How.LINK_TEXT, using = "2:00pm-3:00pm")
    WebElement hours;
    
    @FindBy(how = How.NAME, using = "fp-input-fulfillment_note")
    WebElement message;
    
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Begin Checkout']")
    WebElement begincheckout;
    
    @FindBy(how = How.XPATH, using = "//div[@class='row fp-payment-method']//div[@id='input-cardholder_name']//iframe")
    WebElement ccname;
    
    @FindBy(how = How.XPATH, using = "//div[@class='row fp-payment-method']//div[@id='input-cc_number']//iframe")
    WebElement ccnumber;
    
    @FindBy(how = How.XPATH, using = "//div[@class='row fp-payment-method']//div[@id='input-cvv_code']//iframe")
    WebElement cccvv;
    
    @FindBy(how = How.XPATH, using = "//div[@class='row fp-payment-method']//div[@id='input-expiry_date']//iframe")
    WebElement ccexpiry;
    
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Sign Out') and @class='fp-logout-link']")
    WebElement signOut;
    
    
    public void closewelcome() {
    	
    	welcome.click();
 
    }
    
    public void signinlink() {
    	signin.click();
    }
    
    public void enterloginvalue(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
	}
    
    public void login() {
    	submitBtn.click();
    }
    
    public void clickshop() throws Exception {
    	Thread.sleep(5000);
		WebElement elem1 = shop;
		Thread.sleep(4000);

		Actions act = new Actions(driver);
		Action a1 = act.moveToElement(elem1).build();
		a1.perform();
		Thread.sleep(1000);
		elem1.click();
		Thread.sleep(2000);
    }
    
    public void addproduct() throws Exception {
    	eggs.click();
    	Thread.sleep(1000);
    	limes.click();
    	Thread.sleep(5000);
    	
    }
    
    public void hoverandcheckout() throws Exception {
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(1000);
		WebElement elem2 = checkouthover;
		Actions act = new Actions(driver);
		Action a2 = act.moveToElement(elem2).build();
		a2.perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='row fp-list-header-actions']//div[@class='col-xs-6 col-sm fp-col-checkout']//a[contains(text(),'Checkout')]")));
		WebElement elem3 = driver.findElement(By.xpath(
				"//div[@class='row fp-list-header-actions']//div[@class='col-xs-6 col-sm fp-col-checkout']//a[contains(text(),'Checkout')]"));
		elem3.click();
		
		//change xpath to variable
    }
    
    public void Selectday(String Day) {
    	
    	datedd.click();

		List<WebElement> daylist = driver.findElements(
				By.xpath("//span[contains(@class,'fp-dropdown fp-dropdown-day')]//ul[@class='fp-dropdown-list']//li//a"));

		for (WebElement day : daylist) {

			String daytext = day.getText();

			if (daytext.equals(Day)) {
				day.click();
				break;
			}

			System.out.println(daytext);
		}
	}
    
    public void Selecttime(String Time) {
    	hoursdd.click();
		List<WebElement> timelist = driver.findElements(
				By.xpath("//span[contains(@class,'fp-dropdown fp-dropdown-hour')]//ul[@class='fp-dropdown-list']//li//a"));

		for (WebElement time : timelist) {

			String timetext = time.getText();

			if (timetext.equals(Time)) {
				time.click();
				break;
			}

			System.out.println(timetext);
		}
	}
    
    public void typemessage() throws Exception {
    	Thread.sleep(1500);
    	message.click();
    	message.clear();
    	message.sendKeys("Please leave the items at front door. Thank You.");
    }
    
    public void clickbegincheckout() {
    	begincheckout.click();
    }
    
    public void enterccname(String cchname) throws Exception {
    	Thread.sleep(10000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1950)");
		Thread.sleep(1000);
		ccname.sendKeys(cchname);
    }
    
    public void enterccnumber(String ccnum) throws Exception {
    	ccnumber.sendKeys(ccnum);
    	Thread.sleep(1500);
    }
    
    public void entercvv(String cvv) {
    	cccvv.sendKeys(cvv);
    }
    
    public void enterexpiry(String exp) throws Exception {
    	ccexpiry.sendKeys(exp);
    	Thread.sleep(1500);
    }
    
    public void clicksignout() {
    	signOut.click();
    }

}
