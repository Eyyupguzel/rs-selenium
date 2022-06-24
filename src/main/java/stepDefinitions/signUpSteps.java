package stepDefinitions;

import Utilities.Driver;
import helper.LoggerHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AbstractClass;
import pages.loginPage;
import pages.signUpPage;

public class signUpSteps extends AbstractClass {



    WebDriver driver;

    pages.signUpPage signUpPage = new signUpPage();
    Logger logger = LoggerHelper.getLogger(LoggerHelper.class);




    @And("Click the sign up tab")
    public void clickTheSignUpTab() {
        signUpPage.clickSignUpTab();
    }

    @And("Enter the unique username {string}")
    public void enterTheUniqueUsername(String username) {
        logger.info("Inside Step - user enters username");
        signUpPage.typeUsername(username);
    }

    @And("Enter the unique email {string}")
    public void enterTheUniqueEmail(String email) {
        logger.info("Inside Step - user enters email");
        signUpPage.typeEmail(email);
    }

    @And("Enter the first password {string}")
    public void enterTheFirst(String password) {
        logger.info("Inside Step - user enters password");
        signUpPage.typePassword(password);
    }

    @And("Enter the password {string} again")
    public void enterTheAgain(String rePassw) {
        logger.info("Inside Step - user enters passsword again");
        signUpPage.typeRePassword(rePassw);
    }
    @When("Click the sign up button")
    public void clickTheSignUpButton() {
        logger.info("Inside Step - user clicks sign up button");
        signUpPage.clickSignUpButton();
    }

    @Then("Verify successs sign up message")
    public void verifySuccesssSignUpMessage() {
        logger.info("Inside Step - user see success sign up message");
        signUpPage.verifySignUpSuccessMessage();
    }
    @Then("Verify error sign up message email already registered")
    public void verifySignUpMessageAlreadyRegisteredEmail() {
        logger.info("Inside Step - user see error sign up message already registered email");
        signUpPage.verifySignUpErrorMessageEmailAlreadyRegistered();
    }
    @Then("Verify error sign up message username already registered")
    public void verifyErrorSignUpMessage() {
        logger.info("Inside Step - user see error sign up message already registered username");
        signUpPage.verifySignUpErrorMessageUsernameAlreadyRegistered();
    }
    @After
    public void sleepDriver() throws InterruptedException {
        logger.info("Inside Step - close browser");

        Thread.sleep(2000);
        Driver.closeDriver();

    }



}
