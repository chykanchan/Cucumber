package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import baseclass.BaseClass;
import utils.XL_Data_GLDT;

public class GLDTPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	WebElement frame1;

	@FindBy(xpath = "//span[@class='workarea_header_id']")
	WebElement headerid;

	@FindBy(xpath = "//span[contains(text(),'(GLDT-')]")
	WebElement Expected;

	@FindBy(xpath = "//input[@name='$PpyWorkPage$pProductName'][@id='414e17ce']")
	WebElement selectproduct;

	@FindBy(xpath = "//*[@id='158b841d']")
	WebElement reason;

	@FindBy(xpath = "//*[@class=' layout-body']//div[1][@id='CT']//button")
	List<WebElement> Region;

	@FindBy(xpath = "//div[2]/table//*[@class=' layout-body']//div[1]/span/button")
	List<WebElement> ROPU;

	@FindBy(xpath = "//*[@node_name='CountryCardSelectable']")
	List<WebElement> Country;


	@FindBy(xpath = "//button[@title='Initiate RA Process']")
	WebElement Initiateprocessbutton;

	@FindBy(xpath = "//label[contains(text(),'Please confirm if the correct list of countries ha')]")
	WebElement selectedCountryList_popUp;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement Continuebutton;

	public GLDTPage() {
		PageFactory.initElements(driver, this);
	}

	public static String GLDT_Case_Id;

	public void capture_GLDTCase_id1(int SRN, int ERN) throws Exception {

		try {
			action.switchToDefaultFrame(driver);
			Thread.sleep(5000);
			driver.switchTo().frame(1);			
			GLDT_Case_Id = headerid.getText();
			System.out.println("Actualgldtid:" + GLDT_Case_Id);
			String ExpectedgldId = Expected.getText();
			System.out.println("expectedGldtId:" + ExpectedgldId);
			Assert.assertEquals(GLDT_Case_Id, ExpectedgldId);
			System.out.println("GLDT id is Captured");
			GLDT_Case_Id = GLDT_Case_Id.substring(GLDT_Case_Id.lastIndexOf("G")); // Removal of text from left side
			StringBuffer sb = new StringBuffer(GLDT_Case_Id);
			sb.deleteCharAt(sb.length() - 1); // Removal of text from right side
			GLDT_Case_Id = sb.toString();
			System.out.println("Test Step Passed_Capture_GLDTCase_id " + GLDT_Case_Id);
			XL_Data_GLDT.write_Pass_Result(SRN);
			XL_Data_GLDT.write_CaseID(3, GLDT_Case_Id);
			XL_Data_GLDT.write_CaseIDAsPrerequiste(12, GLDT_Case_Id);
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);
		}

	}

	public void selectionOfProduct(int SRN, int ERN) throws Exception {
		try {
			//driver.switchTo().defaultContent();
			Thread.sleep(5000);
			// action.switchToFrame(driver, frame1);
			action.type(selectproduct, XL_Data_GLDT.testData);
			Thread.sleep(7000);
			action.type1(selectproduct);
			String selectproductValue = selectproduct.getAttribute("value");
			System.out.println(selectproductValue);
			Assert.assertEquals(selectproductValue, XL_Data_GLDT.testData);
			System.out.println("The selected product has been verified");
			XL_Data_GLDT.write_Pass_Result(SRN);
		} catch (Exception|AssertionError e) {
			System.out.println("Assertion error:" + e);
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);
			
		}

	}

	public void selectionOfReason(int SRN, int ERN) throws Exception {
		try {
			action.explicitWait1(driver, reason);
			action.type(reason, XL_Data_GLDT.testData);
			String reasonEnteredCheck = reason.getAttribute("value");
			Assert.assertEquals(reasonEnteredCheck, XL_Data_GLDT.testData);
			System.out.println("The entered reason has been verified Using Assert");
			XL_Data_GLDT.write_Pass_Result(SRN);
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);
		}

	}

	public void selectionofRegion(int SRN, int ERN) throws Exception {
		try {
			Thread.sleep(5000);
			int j = Region.size();
			for (int i = 1; i < j; i++) {
				String Actual_Region_Name = driver
						.findElement(By.xpath("(//*[@class=' layout-body']//div[1][@id='CT']//button)[" + i + "]"))
						.getText();
				if (Actual_Region_Name.equalsIgnoreCase(XL_Data_GLDT.testData)) {
					Thread.sleep(3000);
					driver.findElement(By.xpath("(//*[@class=' layout-body']//div[1][@id='CT']//button)[" + i + "]"))
							.click();
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

	public void selectionofRopu(int SRN, int ERN) throws Exception {
		try {

			Thread.sleep(5000);
			int j = ROPU.size();
			for (int i = 1; i <= j; i++) {
				String Actual_ROPU_Name = driver
						.findElement(
								By.xpath("(//div[2]/table//*[@class=' layout-body']//div[1]/span/button)[" + i + "]"))
						.getText();
				if (Actual_ROPU_Name.equalsIgnoreCase(XL_Data_GLDT.testData)) {
					Thread.sleep(3000);
					driver.findElement(
							By.xpath("(//div[2]/table//*[@class=' layout-body']//div[1]/span/button)[" + i + "]"))
							.click();
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

	public void selectionofCountry(int SRN, int ERN) throws Exception {
		try {

			Thread.sleep(4000);
			int j = Country.size();
			int i;
			for (i = 1; i <= j; i++) {
				String Actual_Country_Name = driver.findElement(By.xpath("(//*[@node_name='CountryCardSelectable']//*[@class='heading_3'])[" + i + "]")).getText();

				if (Actual_Country_Name.equalsIgnoreCase(XL_Data_GLDT.testData)) {
					Thread.sleep(5000);
					WebElement CountryEle = driver.findElement(
							By.xpath("(//*[@node_name='CountryCardSelectable']//*[@class='icons']/img)[" + i + "]"));

					CountryEle.click();

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

	public void clickOnInitiateprocessbutton(int SRN, int ERN) throws Exception {
		try {
			action.click(driver, Initiateprocessbutton);
			Thread.sleep(1000);
			boolean countryListPopUp_Check = selectedCountryList_popUp.isDisplayed();
			System.out.println("Country List pop up has been checked" + " " + countryListPopUp_Check);
			Assert.assertTrue(countryListPopUp_Check);
			XL_Data_GLDT.write_Pass_Result(SRN);
		} catch (AssertionError ae) {
			System.out.println("Assertion error:" + ae);
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}

	}

	public void ClickonContinue(int SRN, int ERN) throws Exception {
		try {
			action.isDisplayed(driver, selectedCountryList_popUp);

			String continueBtnText = Continuebutton.getText();
			Assert.assertEquals(continueBtnText, "Continue");
			action.click(driver, Continuebutton);
			System.out.println("Continue button checked");
			XL_Data_GLDT.write_Pass_Result(SRN);
		} catch (Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_ticketPage jira_ticketPage = new Jira_ticketPage();
			jira_ticketPage.Create_JiraTicket(currentMethod);
			XL_Data_GLDT.write_Fail_Result(SRN, ERN, currentMethod);

		}
	}
}