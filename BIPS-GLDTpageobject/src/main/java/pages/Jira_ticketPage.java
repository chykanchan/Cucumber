package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import baseclass.BaseClass;
import utils.ScreenCapture;
import utils.XL_Data_GLDT;

public class Jira_ticketPage extends BaseClass{
	
	Action action= new Action();	
	
	@FindBy(xpath="//button[@id='createGlobalItem']")
	WebElement Create_Mainbutton;
	
	@FindBy(xpath="//*[@id=\"jira\"]/div[16]/div[52]/div/div[3]/div/div/section")
	WebElement CreateIssue_inpopup;

	@FindBy(xpath="//input[@id='summary-field']")
	WebElement SummaryField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Create_poupbutton;
	
	@FindBy(xpath="//span[contains(text(),'View issue')]")
	WebElement ViewIssue;
	
	@FindBy(xpath="/html/body/div[5]/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/div[1]/div/div/div/nav/ol/div[2]/li/a/span")
	WebElement Jira_Text;
	
		
	public Jira_ticketPage() {
		PageFactory.initElements(driver, this);
	}
	
	public static String Jira_Id;
	public void Create_JiraTicket(String currentMethod) throws Exception {
		action.implicitWait(driver, 20);
		ScreenCapture.main(null);		
		Thread.sleep(2000);
		XL_Data_GLDT.get_user_credential(1);
		Jira_loginPage jira_loginPage = new Jira_loginPage();
		jira_loginPage.logintojira(XL_Data_GLDT.userId, XL_Data_GLDT.password);	
		Thread.sleep(5000);
		action.explicitWait(driver, Create_Mainbutton);
		String ParentWindow = driver.getWindowHandle();
		action.click(driver, Create_Mainbutton);
		for (String Child_Window : driver.getWindowHandles()) { 
				driver.switchTo().window(Child_Window);
				action.explicitWait(driver, CreateIssue_inpopup);
				SummaryField.sendKeys(Keys.TAB);
				Actions actions = new Actions(driver);
				actions.keyDown(Keys.CONTROL);
				actions.sendKeys("v");
				actions.keyUp(Keys.CONTROL);
				actions.build().perform();
				Thread.sleep(5000);
				action.click(driver, SummaryField);
				SummaryField.sendKeys(currentMethod);
				action.explicitWait1(driver, Create_poupbutton);
				action.click(driver, Create_poupbutton);
				action.explicitWait(driver, ViewIssue);
				action.click(driver, ViewIssue);
				action.explicitWait(driver,Jira_Text);
				Jira_Id = Jira_Text.getText();
				System.out.println("Jira Id: "+Jira_Id);
		}		
		driver.manage().deleteAllCookies();
		try {

			Thread.sleep(15000); // wait 15 seconds to clear cookies.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	//driver.quit();
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
