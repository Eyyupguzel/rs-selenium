package stepDefinitions;

import Utilities.Driver;
import Utilities.readProperties;
import helper.LoggerHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AbstractClass;
import pages.loginPage;

import java.util.concurrent.TimeUnit;


public class loginSteps extends AbstractClass {

    WebDriver driver;

    loginPage loginPage = new loginPage();
    Logger logger = LoggerHelper.getLogger(LoggerHelper.class);



    @Given("Go to the goart website")
    public void goToTheGoartWebsite() {

        logger.info("Inside Step - market place website is open ");

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(readProperties.getData("URL"));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        logger.info("GOART Marketplace website opened.");
    }

    @Then("Verify I am in the login page")
    public void verifyIAmInTheLoginPage() {
        logger.info("Inside Step - user is on login page");
        loginPage.verifyLoginPage();

    }

    @And("Type to email {string} and password {string}")
    public void type_to_and(String email, String password) {
        logger.info("Inside Step - user enters email and password");

        loginPage.typeTheEmail(email);
        loginPage.typeThePassword(password);

    }
    @And("Type to {string} and {string} outline")
    public void typeToAndOutline(String emailUsername, String password) {
        logger.info("Inside Step - user enters username and password");
        loginPage.typeTheEmailandPasswordOutline(emailUsername, password);
    }


    @And("Click remember me button")
    public void click_remember_me_button() {
        logger.info("Inside Step - clicks remember me button.");

        loginPage.clickRememberMeCheckBox();

    }
    @When("Click login button")
    public void clickLoginButton() {
        logger.info("Inside Step - clicks login button.");

        loginPage.clickLoginButton();
    }

    @Then("Verify I am in the home page")
    public void verifyIAmInTheDashboardPage() {
        logger.info("Inside Step - user is on home page");

        loginPage.verifyHomedPage();
    }

    @Then("Verify username or password is wrong error message")
    public void verifyUsernameOrPasswordIsWorngErrorMessage() {
        logger.info("Inside Step - user see error message");
        loginPage.verifyLoginErrorMessage();
    }

    @After
    public void sleepDriver() throws InterruptedException {
        logger.info("Inside Step - close browser");

        Thread.sleep(2000);
        Driver.closeDriver();

    }


    @And("Click sign in button")
    public void clickSignInButton() {
        logger.info("Inside Step - clicks sign in button.");
        loginPage.clickSignInButton();
    }

    @And("Type to username {string} and password {string}")
    public void typeToUsernameAndPassword(String username, String password) {

        logger.info("Inside Step - user enters email and password");

        loginPage.typeTheUsername(username);
        loginPage.typeThePassword(password);
    }

    @Then("Verify required error message")
    public void verifyUsernameRequiredErrorMessage() {
        logger.info("Inside Step - user see rewuired error message");
        loginPage.verifyRequiredErrorMessage();
    }


}
