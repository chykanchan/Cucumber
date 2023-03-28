package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import baseclass.BaseClass;
import utils.XL_Data_GLDT;

public class Jira_loginPage extends BaseClass {
	
	
		
	@FindBy(xpath="//*[@id='username']")
	WebElement Usernamejira;
	
	@FindBy(xpath="//*[@id=\"login-submit\"]")
	WebElement Loginbutton;
	
	@FindBy(name="password")
	WebElement password;
	
	public Jira_loginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logintojira(String uname ,String pswd) throws Exception {
		try {
			Action action= new Action();
			XL_Data_GLDT.read_URL_Data(2);
			Thread.sleep(5000);
			driver.get(XL_Data_GLDT.testData);
			driver.manage().window().maximize();
			action.explicitWait1(driver,Usernamejira);
			action.type(Usernamejira, uname);
			action.click(driver, Loginbutton);
			action.explicitWait1(driver,password );
			action.type(password, pswd);
			action.click(driver, Loginbutton);
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
			
		
		} catch (IOException e) {
			
		}
		
		
		
	}
	
}
	 