package infokes.step_definitions;

import infokes.Drivers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import infokes.pages.base.BasePageObject;

public class HomeSteps extends BasePageObject {

    public HomeSteps() {
    }

    @Then("User will see the pasien list")
    public void userSeeListOfPatient() {
        this.assertIsDisplayed("TEXT_NAME_OF_PATIENT");
    }

    @Then("User click the detail of patient")
    public void userSeeDetailOfPatientFromList() {
        this.clickOn("TEXT_NAME_OF_PATIENT");
    }

    @And("User see the detail information of patient")
    public void userSeeDetailInformationPatient() {
        this.clickOn("TEXT_DETAIL_INFORMATION_PATIENT");
    }

    @And("User click dropdown of patient")
    public void userCLickDropdownPatient() {
        this.clickOn("BUTTON_DROPDOWN_LIST_PATIENT");
    }

    @And("User see data dropdown of patient")
    public void userSeeDropdownPatient() {
        this.clickOn("TEXT_DETAIL_DROPDOWN_PATIENT");
    }
}
