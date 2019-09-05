package TestPages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import TestBase.BrowserSetup;

public class HomePage extends BrowserSetup {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@id='main-nav']/a[3]")
	WebElement contacts;
	
	
	
	public ContactsPage contactOption() {
		
		contacts.click();
		
		return new ContactsPage();
	}

	public boolean home() {
		boolean tilte =driver.getTitle().equalsIgnoreCase("CRM");
		return tilte;
	}
	
	
}
