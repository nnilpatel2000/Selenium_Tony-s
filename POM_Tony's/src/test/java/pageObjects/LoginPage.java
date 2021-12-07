package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.bytebuddy.asm.Advice.This;


public class LoginPage {
	
	public WebDriver driver;
	
	
	 public LoginPage(WebDriver driver) {
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
	    
	    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Create an account here']")
	    WebElement calink;
	    
	    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Forgot your password?']")
	    WebElement fplink;
	    
	    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign In')]")
	    WebElement loginBtn;
	    
	    @FindBy(how = How.XPATH, using = "//a[@class='fp-logout-link']")
	    WebElement signoutBtn;
	    
	    
	    public void closemsg() {
	    	
	    	welcome.click();
	 
	    }
	    
	    public void sign() {
	    	signin.click();
	    }
	    
	    public String getLoginPageTitle() {
			return driver.getTitle();
		}
	    
	    public void enterloginvalue(String username, String pass) {
			userName.sendKeys(username);
			password.sendKeys(pass);
		}
	    
	    public boolean iscreateaccountLinkExist() {
			return calink.isDisplayed();
		}
	    
	    public boolean isForgotPwdLinkExist() {
			return fplink.isDisplayed();
		}
	    
	    
	    public void login() {
	    	loginBtn.click();
	    }
	    
	    public void signout() {
	    	signoutBtn.click();
	    }

	   

}
