package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.GLDTPage;
import pages.HomePage;
import pages.Jira_ticketPage;
import pages.LoginPage;
import pages.RALDPage;
import utils.XL_Data_GLDT;

public class GLDTTestcase5 extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	GLDTPage gldtpage;
	RALDPage raldpage;
	static int first_Row;
	static int last_Row;
	Jira_ticketPage jira_ticket = new Jira_ticketPage();

	String testCaseName = "gldt_HP_02";
	public static String GLDT_Case_Id;

	public void setup1() throws Exception {
		initiate_Chromedriver_Open_URL();

	}

	@Test(priority = 1)
	public void RegulatoryAffairs_Login() throws Exception {

		loginpage = new LoginPage();
		XL_Data_GLDT.get_user_credential(27);
		loginpage.bips_APP_Login(XL_Data_GLDT.userId, XL_Data_GLDT.password);
		System.out.println("Test Step Passed " + new Throwable().getStackTrace()[0].getMethodName() + " Sucessfully ");
	}

	@Test(priority = 2)
	public void openRALDcase() throws Exception {
		homepage = new HomePage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_CaseID(12);
		homepage.Open_Existing_RALDCase(first_Row, last_Row);

	}

	@Test(priority = 3)
	public void captureRALD_id() throws Exception {
		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		raldpage.capture_RALDCase_id(first_Row + 1, last_Row);
	}

	@Test(priority = 4)
	public void click_on_bestid() throws Exception {

		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_Test_Data(14);
		raldpage.clickOnBestDate(first_Row + 2, last_Row);

	}

	@Test(priority = 5)
	public void click_on_baseid() throws Exception {

		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_Test_Data(15);
		raldpage.clickOnBaseDate(first_Row + 4, last_Row);

	}

	@Test(priority = 6)
	public void click_on_Achieveddate() throws Exception {

		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		raldpage.clickOnAcheivedDate(first_Row + 5, last_Row);
	}
	
	@Test(priority = 7)
	public void checkApprovalDate() throws Exception {

		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		raldpage.approvalDate(first_Row + 6, last_Row);
	}
	
	@Test(priority = 8)
	public void initiateropuprocess() throws Exception {

		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		raldpage.ROPUProcess(first_Row + 7, last_Row);
	}
	@Test(priority = 9)
	public void Click_on_ok() throws Exception {

		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		raldpage.clickOnOk(first_Row + 8, last_Row);
	}
	
	@Test(priority = 11)
	public void Click_on_close() throws Exception {

		raldpage = new RALDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		raldpage.clickOnCloseAsRA(first_Row + 10, last_Row);
	}
	@AfterTest
	public void logout() throws Exception {
		homepage = new HomePage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		//driver.switchTo().defaultContent();
		homepage.logout(first_Row + 11, last_Row);
		Thread.sleep(2000);
		driver.quit();
	}


}
