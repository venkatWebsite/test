package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestBase.BrowserSetup;

public class LoginPage extends BrowserSetup {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@name='email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	
	public HomePage login(String Uname,String Pword) {
		userName.sendKeys(Uname);
		password.sendKeys(Pword);
		loginBtn.click();
		return new HomePage();
	}
	
	/*@Test
	public void test() {
		initializeBrowser();
		LoginPage lp = new LoginPage();
		
		lp.login("jjhjhjhjhjhj", "hjjhjh");
	}*/
}
