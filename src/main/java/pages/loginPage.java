package pages;

import Utilities.Driver;
import Utilities.readProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends AbstractClass{

    WebDriver driver;

    public loginPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

        //this.wait = new WebDriverWait(driver,30);
    }



    @FindBy(xpath = "//button[@class='ant-btn ant-btn-secondary']")
    private WebElement signInButton;

    @FindBy(id = "username")
    private WebElement emailBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "remember")
    private WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement textSignIn;
    @FindBy(xpath = "//h3[text()='Something went wrong']")
    private WebElement errorText;
    @FindBy(xpath = "//button[@class='ant-btn ant-btn-primary art-button-block art-button-big-red']")
    private WebElement exploreCollectionsButton;

    @FindBy(xpath = "//div[@class='ant-form-item-explain-error']")
    private WebElement requiredErrorMessage;

    public void clickSignInButton(){
        clickOnFunctionalities(signInButton);
    }


    public void verifyLoginPage(){

        findElement(loginButton);
    }


    public void typeTheEmail(String email){

        email = readProperties.getData("email");

        sendKeysFunction(emailBox, email);
    }

    public void typeTheUsername(String username){

        username = readProperties.getData("username");

        sendKeysFunction(emailBox, username);
    }

    public void typeThePassword(String password){
        password = readProperties.getData("password");

        sendKeysFunction(passwordBox, password);
    }

    public void typeTheEmailandPasswordOutline(String email, String password){
        sendKeysFunction(emailBox, email);
        sendKeysFunction(passwordBox ,password);
    }



    public void clickRememberMeCheckBox(){
     clickOnFunctionalities(rememberMeCheckBox);


    }

    public void clickLoginButton(){

        //wait.until(ExpectedConditions.visibilityOf(signInButton));
        //wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click();", signInButton);
        clickOnFunctionalities(loginButton);
    }

    public void verifyLoginErrorMessage(){

        String errorMessage = "Something went wrong";
        String actual=errorText.getText().trim();
            if(errorMessage.equals(actual)){
                System.out.println(actual + "\t --> Alınan hata doğrudur.");
            }else{
                System.out.println(actual + "\t --> Alınan hata yanlıştır.");
            }


    }
    public void verifyRequiredErrorMessage(){

        String errorMessage = "Required Field!";
        String actual=requiredErrorMessage.getText().trim();
        if(errorMessage.equals(actual)){
            System.out.println(actual + "\t --> Alınan hata doğrudur.");
        }else{
            System.out.println(actual + "\t --> Alınan hata yanlıştır.");
        }


    }
    public void verifyHomedPage(){

        String signInText = "dashboard";

        findElement(exploreCollectionsButton);
    }



}
