
package infokes.step_definitions;

import infokes.Drivers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import infokes.pages.base.BasePageObject;

public class LoginSteps extends BasePageObject {

    public LoginSteps() {
    }

    @When("User is on login page")
    public void userIsOnLoginPage() {
        Drivers.getDriver().get("https://o3.openmrs.org/openmrs/spa/login");
    }

    @And("User fill username with credential {string}")
    public void userFillUsername(String username) {
        waitABit(7);
        this.typeOn("FIELD_USERNAME_MRS", username);
    }

    @And("User click button continue")
    public void userClickContinue() {this.clickOn("BUTTON_CONTINUE_LOGIN_MRS");}

    @And("User fill password with credential {string}")
    public void userFillPasswordWith(String password) {
        this.typeOn("FIELD_PASSWORD_MRS", password);
    }

    @And("User click login")
    public void userClickLogin() {
        this.clickOn("BUTTON_LOGIN_MRS");
    }

    @Then("User is on home page")
    public void userIsOnHomePage() {
        waitABit(10);
        this.assertIsDisplayed("TEXT_HOME_PAGE_MRS");
    }

    @Then("User see restriction invalid credential")
    public void userInvalidCredential() {
        waitABit(2);
        this.assertIsDisplayed("TEXT_INVALID_CREDENTIAL");
    }

}
