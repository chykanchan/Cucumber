package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import testCases.GLDTTestcase3;

public class Testcase3 extends GLDTTestcase3{
	
	@Given("User is logged in as Ropu User")
	public void user_is_logged_in_as_ropu_user() throws Exception {
		setup1();
		Ropu_login();
	}

	@And("User Opens Existing ROLD Case")
	public void user_opens_existing_rold_case() throws Exception {
		Opens_ExistingROLDCase();
		captureROLD_id();
	}

	@And("selects Best date in ePAF Submission Date  Column.")
	public void selects_best_date_in_e_paf_submission_date_column() throws Exception {
		Select_BestDate_ePAF_Submission_Date();
	    
	}

	@And("selects Base date in ePAF Submission Date Column.")
	public void selects_base_date_in_e_paf_submission_date_column() throws Exception {
		Select_BaseDate_ePAF_Submission_Date();
	}

	@And("selects Acheived date in ePAF Submission Date Column.")
	public void selects_acheived_date_in_e_paf_submission_date_column() throws Exception {
		Select_AcheivedDate_ePAF_Submission_Date();
	}

	@And("clicks on Not Applicable checkbox of P&R Dossier Submission Date Column.")
	public void clicks_on_not_applicable_checkbox_of_p_r_dossier_submission_date_column() throws Exception {
		Checkbox_PR_Dossier_Submission_Date_Column();
	}

	@And("clicks on Not Applicable checkbox of Cut Off Date for IPR Column.")
	public void clicks_on_not_applicable_checkbox_of_cut_off_date_for_ipr_column() throws Exception {
		checkbox_Cut_Off_Date_for_IPR_Column();
	}

	@And("clicks on Not Applicable checkbox of Official Price Publication for unreimbursed launch Date Column.")
	public void clicks_on_not_applicable_checkbox_of_official_price_publication_for_unreimbursed_launch_date_column() throws Exception {
		checkbox_officialPriceUnreimbursed();
	}

	@And("clicks on Not Applicable checkbox of Official Price Publication for reimbursed launch Column.")
	public void clicks_on_not_applicable_checkbox_of_official_price_publication_for_reimbursed_launch_column() throws Exception {
		checkbox_officialPriceReimbursed();
		
	}

	@And("clicks on Not Applicable checkbox of Unreimbursed Launch Date Column.")
	public void clicks_on_not_applicable_checkbox_of_unreimbursed_launch_date_column() throws Exception {
		checkbox_Unreimbursed();
	}

	@And("clicks on Not Applicable checkbox of Reimbursed Launch Date Column.")
	public void clicks_on_not_applicable_checkbox_of_reimbursed_launch_date_column() throws Exception {
		checkbox_Reimbursed();
	}

	@And("Ropu User clicks on Complete button.")
	public void ropu_user_clicks_on_complete_button() throws Exception {
		CompleteButton();
		CloseButton();
		logout();
	}


}
