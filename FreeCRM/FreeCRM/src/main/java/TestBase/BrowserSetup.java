package TestBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {

	public static WebDriver driver;
	public static Properties props;
	public static BufferedReader reader;

	public BrowserSetup() {
		try {
			reader =new BufferedReader(new FileReader("C:\\Users\\USER\\eclipse-workspace\\FreeCRM\\src\\main\\resources\\Resources\\config.properties"));
			props = new Properties();
			try {
				props.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	
	public void initializeBrowser() {
		String browserName = props.getProperty("browserName");
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
		
		
	}

/*	public static void main(String[] args) {
		
		BrowserSetup ob = new BrowserSetup();
		
		ob.initializeBrowser();
	}
	*/
}
