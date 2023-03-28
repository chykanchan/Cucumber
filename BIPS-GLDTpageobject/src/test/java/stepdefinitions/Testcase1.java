package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testCases.GLDTTestcae1;

public class Testcase1 extends GLDTTestcae1{
		
		
	@Given("User is in login page")
	public void user_is_in_login_page() throws Exception {
		setup1();
	}
	
	
	@Given("User Gives valid username and password")
	public void user_gives_valid_username_and_password() throws Exception{
		make_Cell_Empty();
		TAMAManager_login();
	}

	@And("User click on Initiate Tab")
	public void user_click_on_initiate_tab() throws Exception {
	
		click_on_InitiateProcess_TAB();
		
	    
	}

	@And("User clicks on GLDT_Module")
	public void user_clicks_on_gldt_module() throws Exception { 
		click_on_GLDT_Module();
		captureGLDT_id();
	}

	@When("User Enters product")
	public void user_enters_product() throws Exception {
		selectproduct();
	    
	}

	@And("User Enters reason")
	public void user_enters_reason() throws Exception {
		enterReason();
	    
	}

	@And("User Enters region")
	public void user_enters_region() throws Exception {
		select_Region();
	    
	}

	@And("User Enters ropu")
	public void user_enters_ropu() throws Exception {
		select_ROPU();
	    
	}

	@And("User Enters country")
	public void user_enters_country() throws Exception {
		select_Country();
	    
	}

	@And("User Clicks on Initiate RA Process")
	public void user_clicks_on_initiate_ra_process() throws Exception {
		InitiateRAProcessbutton();
	    
	}

	@And("User Clicks on Continue")
	public void user_clicks_on_continue() throws Exception {
		Continuebutton();
	    
	}

	@Then("Initialisation need to be completed and logout")
	public void initialisation_need_to_ne_completed() throws Exception {
		logout();
	}

}



