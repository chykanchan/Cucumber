package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import actiondriver.Action;
import baseclass.BaseClass;
import utils.XL_Data_GLDT;

public class HomePage extends BaseClass {
	Action action = new Action();
	
	@FindBy(xpath="//iframe[@id='PegaGadget1Ifr']")
    WebElement frame1;

	@FindBy(xpath = "//iframe[@src='about:blank']")
	WebElement FrameSRC;

	@FindBy(xpath = "(//*[@class='layout-group-item-title'])[2]")
	WebElement InitiateProcesssection;

	@FindBy(xpath = "//div[6]//span/button[contains(text(),'GLDT - Global Launch Date Tracker')]")
	WebElement Gldt;

	@FindBy(xpath = "//div[contains(text(),'GLDT-')]")
	List<WebElement> gldtIDs;
	
	@FindBy(xpath = "//div[contains(text(),'RALD-')]")
	List<WebElement> raldIDs;

	@FindBy(name="CaseManagerPortalHeader_pyDisplayHarness_8")
	WebElement profileImg;

	@FindBy(xpath = "//span[text()='Log off']")
	WebElement logOff;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	static SoftAssert softAssert = new SoftAssert();

	public void clickonInitiateProcess(int SRN, int ERN) throws Exception {

		try {

			action.switchToFrame(driver, FrameSRC);
			action.click(driver, InitiateProcesssection);
			boolean gldtPresence = action.isDisplayed(driver, Gldt);
			softAssert.assertTrue(gldtPresence);
			System.out.println("GLDT module Assert check" + gldtPresence);
			softAssert.assertAll();
			XL_Data_GLDT.write_Pass_Result(SRN);
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);
		}

		catch (AssertionError e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);
		}

	}

	public void clickGLdtModule(int SRN, int ERN) throws Exception {

		try {

			action.explicitWait(driver, Gldt);
			action.click(driver, Gldt);
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);
		}

	}

	public void Open_Existing_RALDCase(int SRN, int ERN) throws Exception {
		try {
			action.switchToFrame(driver, FrameSRC);
			action.explicitWait0(driver, gldtIDs);
			int j = gldtIDs.size();
			for (int i = 1; i <= j; i++) {
				String actualgldt = driver.findElement(By.xpath("(//div[contains(text(),'GLDT-')])[" + i + "]"))
						.getText();

				if (actualgldt.equalsIgnoreCase(XL_Data_GLDT.testData)) {
					WebElement openCaseID = driver.findElement(By.xpath("(//div[contains(text(),'GLDT-')])"));
					openCaseID.click();

					break;
				}
			}

			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}
	
	public void Open_Existing_ROLDCase(int SRN, int ERN) throws Exception {
		try {
			action.switchToFrame(driver, FrameSRC);
			action.explicitWait0(driver, raldIDs);
			int j = raldIDs.size();
			for (int i = 1; i <= j; i++) {
				String actualgldt = driver.findElement(By.xpath("(//div[contains(text(),'RALD-')])[" + i + "]")).getText();

				if (actualgldt.equalsIgnoreCase(XL_Data_GLDT.testData)) {
					WebElement openCaseID = driver.findElement(By.xpath("(//div[contains(text(),'RALD-')])"));
					openCaseID.click();

					break;
				}
			}

			XL_Data_GLDT.write_Pass_Result(SRN);


		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}

	public void logout(int SRN, int ERN) throws Exception {
	try {
			
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			action.explicitWait(driver, profileImg);
			action.click(driver, profileImg);
			action.click(driver, logOff);
			String loginPageTitle = driver.getTitle();
			boolean loginPageTitleCheck = loginPageTitle.contains("Login Page");
			Assert.assertTrue(loginPageTitleCheck);
			System.out.println("Page Title Status" + " " + loginPageTitleCheck);
			System.out.println("Log out Verified with Assert");
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
		XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);
		}

	}

}
