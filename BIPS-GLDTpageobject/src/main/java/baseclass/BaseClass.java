package baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.XL_Data_GLDT;

public class BaseClass {

	public static WebDriver driver;

	@BeforeSuite
	public void initiate_Chromedriver_Open_URL() throws Exception {
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\PA0128\\eclipse-workspace\\BIPS-Cucumber\\src\\test\\resources\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		XL_Data_GLDT.read_URL_Data(1);
		driver.manage().window().maximize();
		driver.get(XL_Data_GLDT.testData);
	}

}
