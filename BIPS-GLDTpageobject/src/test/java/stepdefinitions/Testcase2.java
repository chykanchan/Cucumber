package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testCases.GLDTTestcase2;

public class Testcase2 extends GLDTTestcase2{
	
	@Given("User login as RA user")
	public void user_login_as_ra_user() throws Exception {
		setup1();
		RegulatoryAffairs_Login();
	}
	
	@And("User clicks on GLDT parentcase id")
	public void user_clicks_on_gldt_parentcase_id() throws Exception {
		openRALDcase();
		captureRALD_id();
	    
	}

	@And("User selects  best Submission date")
	public void user_selects_best_submission_date() throws Exception {
		click_on_bestid();
		
	   
	}

	@And("User selects  base Submission date")
	public void user_selects_base_submission_date() throws Exception {
		click_on_baseid();
	    
	}

	@And("User selects  Achieved Submission date")
	public void user_selects_achieved_submission_date() throws Exception {
		click_on_Achieveddate();
	   
	}

	@And("User clicks on Not Applicable check box in Approval Date column.")
	public void user_clicks_on_not_applicable_check_box_in_approval_date_column() throws Exception {
		checkApprovalDate();
	}

	@When("User clicks on Initiate ROPU Process button.")
	public void user_clicks_on_initiate_ropu_process_button() throws Exception {
		initiateropuprocess();
	}

	@And("User clicks on Ok in the pop up dialog.")
	public void user_clicks_on_ok_in_the_pop_up_dialog() throws Exception {
		Click_on_ok();
	    
	}

	@And("User clicks on complete button")
	public void user_clicks_on_complete_button() throws Exception {
		Click_on_complete();	    
	}

	@And("User clicks on close button")
	public void user_clicks_on_close_button() throws Exception {
		Click_on_close();
	   
	}

	@Then("ROPU process intiated and loggedout")
	public void ropu_process_intiated_and_loggedout() throws Exception {
		logout();
	   
	}

}
