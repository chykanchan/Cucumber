package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import actiondriver.Action;
import baseclass.BaseClass;
import utils.XL_Data_GLDT;


public class ROLDPage extends BaseClass {


Action action= new Action();

    @FindBy(xpath="//iframe[@id='PegaGadget1Ifr']")
     WebElement frame1;
    
    @FindBy(xpath="//iframe[@id='PegaGadget2Ifr']")
     WebElement frame2;
    
    @FindBy(xpath = "//span[@class='workarea_header_id']")
	WebElement headerid;
    
    @FindBy(xpath = "//span[contains(text(),'(ROLD-')]")
	WebElement expectedROLD_Case_Id;
	
	@FindBy(xpath="(//img[@class='inactvIcon'])[1]")
	WebElement Best ;
	
	@FindBy(xpath="(//img[@class='inactvIcon'])[8]")
	WebElement Base ;
	
	@FindBy(xpath="(//img[@class='inactvIcon'])[15]")
	WebElement Acheived ;
	
	@FindBy(xpath="//input[@id='e7ac2b61']")
	WebElement CheckboxPR ;
	
	@FindBy(xpath="//button[@title='Continue']")
	WebElement popupPR ;
	
	@FindBy(xpath="//input[@id='b52b7737']")
	WebElement Checkboxcutoff ;
	
	@FindBy(xpath="//input[@id='17c420e1']")
	WebElement officialPriceUnreimbursed ;
	
	@FindBy(xpath="//input[@id='3cdc2b72']")
	WebElement officialPriceReimbursed ;
	
	@FindBy(xpath="//input[@id='14bd8026']")
	WebElement unReimbursedLaunchDate ;
	
	@FindBy(xpath="//input[@id='c4823044']")
	WebElement reimbursedLauchDate ;
	
	@FindBy(xpath="//button[contains(text(),'Complete')]")
	WebElement CompleteButton ;
	
	@FindBy(xpath="//button[contains(text(),'Close')]")
	WebElement CloseButton ;
	
	@FindBy(xpath = "//input[@id='515edcb6']")
	WebElement PR_Dossier_column;
	
	@FindBy(xpath = "//input[@id='e10075d3']")
	WebElement Cut_Off_Date_for_IPR_column;	

	
	
	@FindBy(linkText="Today")
	WebElement TodayDate ;

	
	public ROLDPage () {
		PageFactory.initElements(driver, this);
	}
	
	public static String ROLD_Case_Id;
	
	public void capture_ROLDCase_id(int SRN, int ERN) throws Exception {
		try {
			action.switchToDefaultFrame(driver);
			action.switchToFrame(driver, frame1);
			ROLD_Case_Id = headerid.getText();
			System.out.println("ActualROLDId:" + ROLD_Case_Id);
			String expectedROLDID = expectedROLD_Case_Id.getText();
			System.out.println("Expected RALD ID:" + expectedROLDID);
			Assert.assertEquals(ROLD_Case_Id, expectedROLDID);
			ROLD_Case_Id = ROLD_Case_Id.substring(ROLD_Case_Id.lastIndexOf("R")); // Removal of text from left side
			StringBuffer sb = new StringBuffer(ROLD_Case_Id);
			sb.deleteCharAt(sb.length() - 1); // Removal of text from right side
			ROLD_Case_Id = sb.toString();
			System.out.println("Test Step Passed_Capture_ROLDCase_id is" + ROLD_Case_Id);
			XL_Data_GLDT.write_Pass_Result(SRN);
			XL_Data_GLDT.write_CaseID(25, ROLD_Case_Id);
			//XL_Data_GLDT.write_CaseIDAsPrerequiste(24, ROLD_Case_Id);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
		
	}
	
	
	
	
	public void bestDate_ePAF_Submission_Date(int SRN, int ERN) throws Exception{
		try {
			 Thread.sleep(5000);
			 action.click(driver, Best);
		     Thread.sleep(5000);
		     action.click(driver, TodayDate);
			 XL_Data_GLDT.write_Pass_Result(SRN);
		  
		    
		    
		    
//			action.type(Best, XL_Data_GLDT.testData);
//			Thread.sleep(3000);
//			String selectBestDate = Best.getAttribute("value");
//			System.out.println(selectBestDate);
//			Assert.assertEquals(selectBestDate, XL_Data_GLDT.testData);
//			System.out.println("The selected Best Date has been verified");

			//XL_Data_GLDT.write_Pass_Result(SRN);
			
			
			

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
		
	}
	public void baseDate_ePAF_Submission_Date(int SRN, int ERN) throws Exception{
		
//		action.click(driver, Base);
//		Thread.sleep(3000);
//		action.click(driver, TodayDate);
		
		try {
			Thread.sleep(3000);
			 action.click(driver, Base);
		     Thread.sleep(3000);
		     action.click(driver, TodayDate);
			 XL_Data_GLDT.write_Pass_Result(SRN);

//			Thread.sleep(3000);
//			action.type(Base, XL_Data_GLDT.testData);
//			Thread.sleep(3000);
//			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}
	
    public void AcheivedDate_ePAF_Submission_Date(int SRN, int ERN) throws Exception{
    	try {
    	Thread.sleep(5000);
		action.click(driver, Acheived);
		Thread.sleep(3000);
		String selectDate = TodayDate.getText();
		System.out.println(TodayDate);
		String expectedDate = "Today";
		Assert.assertEquals(selectDate, expectedDate);
		System.out.println("Entered AcheivedDate is verified:" + selectDate);
		action.click(driver, TodayDate);
		Thread.sleep(3000);
		XL_Data_GLDT.write_Pass_Result(SRN);	

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}
    
public void Checkbox_PR_Dossier_Submission_Date_Column(int SRN, int ERN) throws Exception{
	try {
	
		action.click(driver, CheckboxPR);
		Thread.sleep(5000);		
		boolean Check_Mark1aPopUp = popupPR.isDisplayed();
		Assert.assertTrue(Check_Mark1aPopUp);
		System.out.println("ApplyChanges PopUp is opened:" + Check_Mark1aPopUp);
		action.click(driver, popupPR);
		Thread.sleep(3000);
//			boolean PR_DossierDisabled = PR_Dossier_column.isEnabled();
//			Assert.assertTrue(!PR_DossierDisabled);
//			System.out.println("ApprovalDate column is enabled:" + PR_DossierDisabled);
			XL_Data_GLDT.write_Pass_Result(SRN);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
		
	}

public void checkbox_Cut_Off_Date_for_IPR_Column(int SRN, int ERN) throws Exception{
	try {
		
		action.click(driver, Checkboxcutoff);
		Thread.sleep(5000);
		
		boolean Check_Mark2aPopUp = popupPR.isDisplayed();
		Assert.assertTrue(Check_Mark2aPopUp);
		System.out.println("ApplyChanges PopUp is opened:" + Check_Mark2aPopUp);
		action.click(driver, popupPR);
		Thread.sleep(3000);
//		boolean Cut_Off_Date_for_IPR_Disabled = Cut_Off_Date_for_IPR_column.isEnabled();
//		Assert.assertTrue(!Cut_Off_Date_for_IPR_Disabled);
//		System.out.println("ApprovalDate column is enabled:" + Cut_Off_Date_for_IPR_Disabled);
		XL_Data_GLDT.write_Pass_Result(SRN);
	
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	
}

public void checkbox_officialPriceUnreimbursed(int SRN, int ERN) throws Exception{
	
	try {
		
		action.click(driver, officialPriceUnreimbursed);
		Thread.sleep(3000);
		action.explicitWait1(driver, popupPR);
		boolean Check_Mark3aPopUp = popupPR.isDisplayed();
		Assert.assertTrue(Check_Mark3aPopUp);
		System.out.println("ApplyChanges PopUp is opened:" + Check_Mark3aPopUp);
		action.click(driver, popupPR);
		XL_Data_GLDT.write_Pass_Result(SRN);
	
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	
}

public void checkbox_officialPriceReimbursed(int SRN, int ERN) throws Exception{
    try {
    	Thread.sleep(3000);
	
		action.click(driver, officialPriceReimbursed);
		Thread.sleep(3000);
		
		boolean Check_Mark4aPopUp = popupPR.isDisplayed();
		Assert.assertTrue(Check_Mark4aPopUp);
		System.out.println("ApplyChanges PopUp is opened:" + Check_Mark4aPopUp);
		action.click(driver, popupPR);
		Thread.sleep(3000);
		XL_Data_GLDT.write_Pass_Result(SRN);
	
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	
}

public void checkbox_Unreimbursed(int SRN, int ERN) throws Exception{
    try {
    	//action.explicitWait1(driver, unReimbursedLaunchDate);
		action.click(driver, unReimbursedLaunchDate);
		Thread.sleep(3000);
		//action.explicitWait1(driver, popupPR);
		boolean Check_Mark5aPopUp = popupPR.isDisplayed();
		Assert.assertTrue(Check_Mark5aPopUp);
		System.out.println("ApplyChanges PopUp is opened:" + Check_Mark5aPopUp);
		action.click(driver, popupPR);
		Thread.sleep(3000);
		XL_Data_GLDT.write_Pass_Result(SRN);
	
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	
}

public void checkbox_Reimbursed(int SRN, int ERN) throws Exception{
	
	try {
		Thread.sleep(3000);
		
		action.click(driver, reimbursedLauchDate);
		Thread.sleep(3000);
		
		boolean Check_Mark5aPopUp = popupPR.isDisplayed();
		Assert.assertTrue(Check_Mark5aPopUp);
		System.out.println("ApplyChanges PopUp is opened:" + Check_Mark5aPopUp);
		action.click(driver, popupPR);
		Thread.sleep(3000);
		XL_Data_GLDT.write_Pass_Result(SRN);
	
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	
}


public void CompleteButton(int SRN, int ERN) throws Exception{
	try {
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	action.switchToFrame(driver,frame1 );
	Thread.sleep(3000);
	action.click(driver, CompleteButton);
	} catch (Exception e) {
		String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
		Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
		jira_ticketPage.Create_JiraTicket(currentMethod);
		XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

	}
	
}

public void CloseButton() throws InterruptedException{
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	action.switchToFrame(driver,frame1 );
	Thread.sleep(3000);
	action.click(driver, CloseButton);
	
	
}





		
	

}
