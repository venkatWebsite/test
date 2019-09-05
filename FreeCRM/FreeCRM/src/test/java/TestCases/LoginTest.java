package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BrowserSetup;
import TestPages.ContactsPage;
import TestPages.HomePage;
import TestPages.LoginPage;
import Utilities.ExcelData;

public class LoginTest extends BrowserSetup {

	LoginPage lt;
	HomePage hp;
	ContactsPage cp;
ExcelData ed = new ExcelData();

	@BeforeMethod
	public void startBrowser() {
		initializeBrowser();
		lt = new LoginPage();
		hp = new HomePage();
		cp = new ContactsPage();

	}

	@Test(dataProvider="data")
	public void loginCRM(String fname,String lname,String mailID) throws InterruptedException {

		hp = lt.login(props.getProperty("username"), props.getProperty("password"));
		assertTrue(hp.home(),"Failed not HomePage");
		cp = hp.contactOption();
		cp.addContact();

		cp.firstName(fname);
		cp.lastName(lname);
		cp.emailId(mailID);
		cp.save();
	}
	
	/*@Test
	public void loginCRM1() throws InterruptedException {

		hp = lt.login(props.getProperty("username"), props.getProperty("password"));
		assertTrue(hp.home(),"Failed not HomePage");
		cp = hp.contactOption();
		cp.addContact();

		cp.firstName("dfsdfdsf");
		cp.lastName("dsfsdfsd");
		cp.emailId("dfsdfsdf@dfdsdf.com");
	}
	
	
	@Test
	public void loginCRM2() throws InterruptedException {

		hp = lt.login(props.getProperty("username"), props.getProperty("password"));
		assertTrue(hp.home(),"Failed not HomePage");
		cp = hp.contactOption();
		cp.addContact();

		cp.firstName("dfsdfdsf");
		cp.lastName("dsfsdfsd");
		cp.emailId("dfsdfsdf@dfdsdf.com");
	}*/

	@DataProvider(name="data")
	public Object[][] testData() throws Exception{

    return ed.readData();
	

	}
@AfterMethod
public void Teardown() {
	driver.quit();
}


}
