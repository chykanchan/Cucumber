package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import baseclass.BaseClass;
import pages.GLDTPage;
import pages.HomePage;
import pages.Jira_ticketPage;
import pages.LoginPage;
import utils.XL_Data_GLDT;

public class GLDTTestcae1 extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	GLDTPage gldtpage;
	Jira_ticketPage jira_ticket = new Jira_ticketPage();
	static int first_Row; 
	static int last_Row; 
	String testCaseName = "gldt_HP_01";
	public static String GLDT_Case_Id;
	

	public void setup1() throws Exception {
		initiate_Chromedriver_Open_URL();

	}

	public static void make_Cell_Empty() throws Exception {
		int starting_TestCase_Row = 1;
		int ending_TestCase_Row = 89;
		XL_Data_GLDT.delete_Cell_Content_Data(starting_TestCase_Row, ending_TestCase_Row);
		System.out.println("Test Step Passed " + new Throwable().getStackTrace()[0].getMethodName() + " Sucessfully ");

	}

	@Test(priority = 1)
	public void TAMAManager_login() throws Exception {

		loginpage = new LoginPage();
		XL_Data_GLDT.get_user_credential(39);
		loginpage.bips_APP_Login(XL_Data_GLDT.userId, XL_Data_GLDT.password);
		System.out.println("Test Step Passed " + new Throwable().getStackTrace()[0].getMethodName() + " Sucessfully ");
	}
	
	@Test(priority = 2)
	public void click_on_InitiateProcess_TAB() throws Exception {
		
			homepage = new HomePage();			
			XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
			first_Row = XL_Data_GLDT.first_Row;
			last_Row = XL_Data_GLDT.last_Row;
			homepage.clickonInitiateProcess(first_Row, last_Row);			
	}

	@Test(priority = 3)
	public void click_on_GLDT_Module() throws Exception {
			homepage = new HomePage();
			XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
			first_Row = XL_Data_GLDT.first_Row;
			last_Row = XL_Data_GLDT.last_Row;
			homepage.clickGLdtModule(first_Row + 1, last_Row);
					
	}
	@Test(priority = 4)
	public void captureGLDT_id() throws Exception {
		
			gldtpage = new GLDTPage();
			XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
			first_Row = XL_Data_GLDT.first_Row;
			last_Row = XL_Data_GLDT.last_Row;
			gldtpage.capture_GLDTCase_id1(first_Row + 2, last_Row);					
			
			}

	@Test(priority = 5)
	public void selectproduct() throws Exception {
		gldtpage = new GLDTPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;		
		XL_Data_GLDT.read_Test_Data(4);
		Thread.sleep(4000);
		gldtpage.selectionOfProduct(first_Row + 3, last_Row);	

	}

	@Test(priority = 6)
	public void enterReason() throws Exception {
		gldtpage = new GLDTPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_Test_Data(5);
		Thread.sleep(7000);
		gldtpage.selectionOfReason(first_Row + 4, last_Row);
		
	}

	@Test(priority = 7)
	public void select_Region() throws Exception {
		gldtpage = new GLDTPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_Test_Data(6);		
		gldtpage.selectionofRegion(first_Row + 5, last_Row);

	}

	@Test(priority = 8)
	public void select_ROPU() throws Exception {
		gldtpage = new GLDTPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_Test_Data(7);		
		gldtpage.selectionofRopu(first_Row + 6, last_Row);

	}

	@Test(priority = 9)
	public void select_Country() throws Exception {
		gldtpage = new GLDTPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_Test_Data(8);		
		gldtpage.selectionofCountry(first_Row + 7, last_Row);
		Thread.sleep(5000);
		

	}

	@Test(priority = 10)
	public void InitiateRAProcessbutton() throws Exception {
		gldtpage = new GLDTPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		gldtpage.clickOnInitiateprocessbutton(first_Row + 8, last_Row);
		

	}

	@Test(priority = 11)
	public void Continuebutton() throws Exception {
		gldtpage = new GLDTPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		gldtpage.ClickonContinue(first_Row + 9, last_Row);
		
	}

	@AfterTest
	public void logout() throws Exception {
		homepage = new HomePage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		homepage.logout(first_Row + 10, last_Row);
		Thread.sleep(2000);
		driver.quit();
	}

}
