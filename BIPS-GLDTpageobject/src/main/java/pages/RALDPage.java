package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import actiondriver.Action;
import baseclass.BaseClass;
import utils.XL_Data_GLDT;

public class RALDPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	WebElement Frame1;

	@FindBy(xpath = "//span[@class='workarea_header_id']")
	WebElement headerid;

	@FindBy(xpath = "//span[contains(text(),'(RALD-')]")
	WebElement expectedRALD_Case_Id;

	@FindBy(xpath = "//input[@id='79a8ae4c']")
	WebElement best;

	@FindBy(xpath = "//input[@id='2a32f5c8']")
	WebElement base;

	@FindBy(xpath = "(//img[@class='inactvIcon'])[5]")
	WebElement Acheived;

	@FindBy(linkText = "Today")
	WebElement TodayDate2;

	@FindBy(xpath = "//*[@id='e0446e74']")
	WebElement Check_Mark2;

	@FindBy(xpath = "//button[@title='Continue']")
	WebElement Check_Mark2a;

	@FindBy(xpath = "//input[@id='b56200e4']")
	WebElement approvalcolumn;

	@FindBy(xpath = "//button[contains(text(),'Initiate ROPU Process')]")
	WebElement InitiateRopuProcessButton;

	@FindBy(xpath = "//div[@id='modaldialog_hd']")
	WebElement statusPopUp;

	@FindBy(xpath = "//span[contains(text(),'ROPU Process initiated successfully')]")
	WebElement RopuMessage;

	@FindBy(xpath = "//button[@name='OKModalTemplate_pyWorkPage_12']")
	WebElement ok;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement close;

	@FindBy(xpath = "//iframe[@id='PegaGadget2Ifr']")
	WebElement frame2;

	@FindBy(xpath = "//span[contains(text(),'Welcome')]")
	WebElement actualdashBoard;

	@FindBy(xpath = "//button[contains(text(),'Complete')]")
	WebElement complete;

	@FindBy(xpath = "(//span[contains(text(),'Pending-SubCaseProcessing')])[3]")	
	WebElement status;
	
	@FindBy(xpath = "//span[contains(text(),'Welcome')]")	
	WebElement welcome;

	public RALDPage() {
		PageFactory.initElements(driver, this);
	}

	public static String RALD_Case_Id;

	public void capture_RALDCase_id(int SRN, int ERN) throws Exception {
		try {
			action.switchToDefaultFrame(driver);
			action.switchToFrame(driver, Frame1);
			RALD_Case_Id = headerid.getText();
			System.out.println("ActualRALDId:" + RALD_Case_Id);
			String expectedRALDID = expectedRALD_Case_Id.getText();
			System.out.println("Expected RALD ID:" + expectedRALDID);
			Assert.assertEquals(RALD_Case_Id, expectedRALDID);
			RALD_Case_Id = RALD_Case_Id.substring(RALD_Case_Id.lastIndexOf("R")); // Removal of text from left side
			StringBuffer sb = new StringBuffer(RALD_Case_Id);
			sb.deleteCharAt(sb.length() - 1); // Removal of text from right side
			RALD_Case_Id = sb.toString();
			System.out.println("Test Step Passed_Capture_RALDCase_id is" + RALD_Case_Id);
			XL_Data_GLDT.write_Pass_Result(SRN);
			XL_Data_GLDT.write_CaseID(13, RALD_Case_Id);
			XL_Data_GLDT.write_CaseIDAsPrerequiste(24, RALD_Case_Id);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}

	public void clickOnBestDate(int SRN, int ERN) throws Exception {
		try {
			Thread.sleep(3000);
			action.type(best, XL_Data_GLDT.testData);
			Thread.sleep(3000);
			String selectBestDate = best.getAttribute("value");
			System.out.println(selectBestDate);
			Assert.assertEquals(selectBestDate, XL_Data_GLDT.testData);
			System.out.println("The selected Best Date has been verified");

			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}

	public void clickOnBaseDate(int SRN, int ERN) throws Exception {
		try {

			Thread.sleep(3000);
			action.type(base, XL_Data_GLDT.testData);
			Thread.sleep(3000);
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}

	}

	public void clickOnAcheivedDate(int SRN, int ERN) throws Exception {
		try {

			Thread.sleep(5000);
			action.click(driver, Acheived);
			Thread.sleep(3000);
			String selectDate = TodayDate2.getText();
			System.out.println(TodayDate2);
			String expectedDate = "Today";
			Assert.assertEquals(selectDate, expectedDate);
			System.out.println("Entered AcheivedDate is verified:" + selectDate);
			action.click(driver, TodayDate2);
			Thread.sleep(3000);
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}

	public void approvalDate(int SRN, int ERN) throws Exception {

		try {
			action.explicitWait1(driver, Check_Mark2);
			action.click(driver, Check_Mark2);
			// popupScreeen//
			action.explicitWait1(driver, Check_Mark2a);
			boolean Check_Mark2aPopUp = Check_Mark2a.isDisplayed();
			Assert.assertTrue(Check_Mark2aPopUp);
			System.out.println("ApplyChanges PopUp is opened:" + Check_Mark2aPopUp);
			action.click(driver, Check_Mark2a);
			Thread.sleep(3000);
			boolean approvalcolumnDisabled = approvalcolumn.isEnabled();
			Assert.assertTrue(!approvalcolumnDisabled);
			System.out.println("ApprovalDate column is enabled:" + approvalcolumnDisabled);
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}

	public void ROPUProcess(int SRN, int ERN) throws Exception {
		try {
			action.switchToDefaultFrame(driver);
			action.switchToFrame(driver, Frame1);
			Thread.sleep(7000);
			action.click(driver, InitiateRopuProcessButton);
			boolean PopuP = statusPopUp.isDisplayed();
			Assert.assertTrue(PopuP);
			System.out.println("Status PopUp is opened:" + PopuP);
			String actualRopuMessage = RopuMessage.getText();
			String expectedRopuMessage = "ROPU Process initiated successfully";
			Assert.assertEquals(actualRopuMessage, expectedRopuMessage);
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}

	}

	public void clickOnOk(int SRN, int ERN) throws Exception {
		try {
			Thread.sleep(3000);
			action.click(driver, ok);
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}

	public void clickOnCompleteasRA(int SRN, int ERN) throws Exception {
		try {
		Thread.sleep(3000);
		action.switchToDefaultFrame(driver);
		action.switchToFrame(driver, Frame1);
		Thread.sleep(3000);
		action.click(driver, complete);
		String actualstatus = status.getText();
		String expectedstatus = "PENDING-SUBCASEPROCESSING";
		Assert.assertEquals(expectedstatus, actualstatus);
		System.out.println("Status Verified:" + actualstatus);
		XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
		String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
		Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
		jira_ticketPage.Create_JiraTicket(currentMethod);
		XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}

	public void clickOnCloseAsRA(int SRN, int ERN) throws Exception {
		try {
		Thread.sleep(5000);
		action.switchToDefaultFrame(driver);
		action.switchToFrame(driver, Frame1);
		Thread.sleep(3000);
		action.click(driver, close);
		action.switchToDefaultFrame(driver);
		action.switchToFrame(driver, frame2);
		String actualdashBoard=welcome.getText();
		String expectedDashBoard = "Welcome";
		Assert.assertEquals(actualdashBoard, expectedDashBoard);
		System.out.println("Returned to Dashboard has been verified:" + expectedDashBoard);
		XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
		 String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
		 Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
		jira_ticketPage.Create_JiraTicket(currentMethod);
		XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		 }

	}

}
