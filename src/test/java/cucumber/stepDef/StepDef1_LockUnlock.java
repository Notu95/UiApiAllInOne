package cucumber.stepDef;

import io.cucumber.java.en.*;

public class StepDef1_LockUnlock {
	
	
	@Given("load the application")
	public void load_the_application() {
	    
	}

	@Given("some other precondition")
	public void some_other_precondition() {
	    
	}

	@When("I complete action")
	public void i_complete_action() {
	   
	}

	@When("some other action")
	public void some_other_action() {
	    
	}

	@When("yet another action")
	public void yet_another_action() {
	    
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	    
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
	    
	}

	@Given("^load the application (.*)$")
	public void load_the_application_url(String str) {
	    System.out.println(str);
	}

	@When("^I check for the (.*) in step$")
	public void i_check_for_the_in_step(int int1) {
		System.out.println(int1);
	}

	@Then("^I verify the (.*) in step$")
	public void i_verify_the_success_in_step(String str) {
		System.out.println(str);
	}

}
