package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import baseclass.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"txtUserID\"]")
	WebElement enterUsername ;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement enterPassword ;
	
	@FindBy(xpath="//button[@id='sub']")
	WebElement loginButton ;
	
	
	public LoginPage () {
		PageFactory.initElements(driver, this);
	}
	
	public void bips_APP_Login(String usname, String psword) throws Exception{
		try {
			action.type(enterUsername, usname);
			action.type(enterPassword, psword);
			action.click(driver, loginButton);
		}catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);		
		}
		
		
	}	



}
