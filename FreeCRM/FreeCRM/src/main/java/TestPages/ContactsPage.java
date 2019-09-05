package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BrowserSetup;

public class ContactsPage extends BrowserSetup {

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@class='ui linkedin button'][contains(text(),'New')]")
	WebElement newContact;

	@FindBy(xpath="//input[@name='first_name']")
	WebElement first_Name;

	@FindBy(xpath="//input[@name='last_name']")
	WebElement last_Name;

	@FindBy(xpath="//input[@name='value']//preceding::input[10]")
	WebElement email;
	
	@FindBy(xpath="//div[@class='ui right secondary pointing menu toolbar-container']/div/button[2]")
	WebElement save;
	
	public void addContact() {
		newContact.click();
	}
	public void firstName(String fname) {
		first_Name.sendKeys(fname);
	}
	public void lastName(String lname) {
		last_Name.sendKeys(lname);
	}
	public void emailId(String mailID) {
		email.sendKeys(mailID);
	}
	public void save() {
		save.click();
	}
	
}
