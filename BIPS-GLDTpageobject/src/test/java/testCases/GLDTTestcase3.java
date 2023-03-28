package testCases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.HomePage;
import pages.Jira_ticketPage;
import pages.LoginPage;
import pages.ROLDPage;
import utils.XL_Data_GLDT;

public class GLDTTestcase3 extends BaseClass{
	
		
	LoginPage loginpage;
	ROLDPage ROLDPage;
	HomePage homepage;
	static int first_Row;
	static int last_Row;
	Jira_ticketPage jira_ticket = new Jira_ticketPage();
	String testCaseName = "gldt_HP_03";
	
	public void setup1() throws Exception {
		initiate_Chromedriver_Open_URL();
		
	}

	@Test(priority=1)
	public void Ropu_login() throws Exception {
		loginpage =new LoginPage();
		 XL_Data_GLDT.get_user_credential(45);
		 loginpage.bips_APP_Login(XL_Data_GLDT.userId, XL_Data_GLDT.password);
	     System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	      
	}
	
	@Test(priority=2)
	public void Opens_ExistingROLDCase() throws Exception {
		homepage = new HomePage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		XL_Data_GLDT.read_CaseID(24);
		homepage.Open_Existing_ROLDCase(first_Row, last_Row);
		
	}
	
	@Test(priority = 3)
	public void captureROLD_id() throws Exception {
		ROLDPage = new ROLDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		ROLDPage.capture_ROLDCase_id(first_Row + 1, last_Row);
	}
	
	
	@Test(priority=4)
	public void Select_BestDate_ePAF_Submission_Date() throws Exception {
		
		ROLDPage = new ROLDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		ROLDPage.bestDate_ePAF_Submission_Date(first_Row+1, last_Row);
		
	}
	@Test(priority=5)
    public void Select_BaseDate_ePAF_Submission_Date() throws Exception {
		
		ROLDPage = new ROLDPage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		ROLDPage.baseDate_ePAF_Submission_Date(first_Row+2, last_Row);
		
	}
	@Test(priority=6)
    public void Select_AcheivedDate_ePAF_Submission_Date() throws Exception {
	
	ROLDPage = new ROLDPage();
	XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
	first_Row = XL_Data_GLDT.first_Row;
	last_Row = XL_Data_GLDT.last_Row;
	ROLDPage.AcheivedDate_ePAF_Submission_Date(first_Row+3, last_Row);
	
    }
	@Test(priority=7)
    public void Checkbox_PR_Dossier_Submission_Date_Column() throws Exception {
    	
    	ROLDPage = new ROLDPage();
    	XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
    	first_Row = XL_Data_GLDT.first_Row;
    	last_Row = XL_Data_GLDT.last_Row;
    	ROLDPage.Checkbox_PR_Dossier_Submission_Date_Column(first_Row+4, last_Row);
    	
        }
	
	@Test(priority=8)
    public void checkbox_Cut_Off_Date_for_IPR_Column() throws Exception {
    	
    	ROLDPage = new ROLDPage();
    	ROLDPage.checkbox_Cut_Off_Date_for_IPR_Column(first_Row+5, last_Row);
    	
        }
    
	@Test(priority=9)
    public void checkbox_officialPriceUnreimbursed() throws Exception {
 	
 	ROLDPage = new ROLDPage();
 	ROLDPage.checkbox_officialPriceUnreimbursed(first_Row+6, last_Row);
 	
     }
	
	@Test(priority=10)
    public void checkbox_officialPriceReimbursed() throws Exception {
     	
     	ROLDPage = new ROLDPage();
     	ROLDPage.checkbox_officialPriceReimbursed(first_Row+7, last_Row);
     	
         }
    
	@Test(priority=11)
    public void checkbox_Unreimbursed() throws Exception {
     	
     	ROLDPage = new ROLDPage();
     	ROLDPage.checkbox_Unreimbursed(first_Row+8, last_Row);
     	
         }
	
	@Test(priority=12)
    public void checkbox_Reimbursed() throws Exception {
     	
     	ROLDPage = new ROLDPage();
     	ROLDPage.checkbox_Reimbursed(first_Row+9, last_Row);
     	
         }
	@Test(priority=13)
    public void CompleteButton() throws Exception {
     	
     	ROLDPage = new ROLDPage();
     	ROLDPage.CompleteButton(first_Row+10, last_Row);
     	
         }
	@Test(priority=14)
     public void CloseButton() throws Exception {
     	
     	ROLDPage = new ROLDPage();
     	ROLDPage.CloseButton();
     	
         }
	@AfterTest
	public void logout() throws Exception {
		homepage = new HomePage();
		XL_Data_GLDT.read_TestCases_SRN_ERN(testCaseName);
		first_Row = XL_Data_GLDT.first_Row;
		last_Row = XL_Data_GLDT.last_Row;
		homepage.logout(first_Row + 11, last_Row);
		Thread.sleep(2000);
		driver.quit();
		
	}

}
