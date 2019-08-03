import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps {
	
	WebDriver driver; 
	
	@cucumber.api.java.Before
	public void initialize() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://gmail.com");
	}
	
	
	
	@Given("^the browser is launched and URL is loaded$")
	public void the_browser_is_launched_and_URL_is_loaded() {
	    
		System.out.println(driver);
		
	}

	@When("^I enter valid creds$")
	public void i_enter_valid_creds(){
	   
	    
	    driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("mujahiddin4@gmail.com");
	    driver.findElement(By.xpath("//input[@name=\"pass\"]")).sendKeys("zmsulthana");
	    
	    
	}

	@When("^I hit sign on$")
	public void i_hit_sign_on() {
	   
	  driver.findElement(By.xpath("//input[@id=\'u_0_2\']")).click();
	   
	}

	@Then("^I get Dashboard$")
	public void i_get_Dashboard()  {
	    System.out.println("This is sample");
	    
	}


}
