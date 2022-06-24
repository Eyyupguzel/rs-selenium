package pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUpPage extends AbstractClass {

    WebDriver driver;

    public signUpPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "rc-tabs-0-tab-signup")
    private WebElement signUpTab;
    @FindBy(xpath = "//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']//input[@id='username']")
    private WebElement userName;
    @FindBy(xpath = "//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']//input[@id='email']")
    private WebElement email;
    @FindBy(xpath = "//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']//input[@id='rePassword']")
    private WebElement rePassword;
    @FindBy(xpath = "//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']//button[@type='submit']")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@class='ant-notification-notice ant-notification-notice-success ant-notification-notice-closable']")
    private WebElement signUpSuccessMessageText;
    @FindBy(xpath = "//div[@class='cancel-listing-modal-content mt-24']//h5")
    private WebElement signUpEmailAlreadyRegisteredMessageText;
    @FindBy(xpath = "//div[@class='cancel-listing-modal-content mt-24']//h5")
    private WebElement signUpUsernameAlreadyRegisteredMessageText;


    public void clickSignUpTab(){
        clickOnFunctionalities(signUpTab);
    }
    public void typeUsername(String user){


        sendKeysFunction(userName,user);
    }
    public void typeEmail(String eMail){
        sendKeysFunction(email,eMail);
    }
    public void typePassword(String passw){
        sendKeysFunction(password,passw);
    }
    public void typeRePassword(String repassw){
        sendKeysFunction(rePassword,repassw);
    }
    public void clickSignUpButton(){

        clickOnFunctionalities(signUpButton);
    }
    public void verifySignUpSuccessMessage(){
        String errorMessage = "Success";
        String actual=signUpSuccessMessageText.getText().trim();
        if(errorMessage.equals(actual)){
            System.out.println(actual + "\t --> Alınan hata doğrudur.");
        }else{
            System.out.println(actual + "\t --> Alınan hata yanlıştır.");
        }
    }

    public void verifySignUpErrorMessageEmailAlreadyRegistered(){
        String errorMessage = "entered has already been registered. Please try to register with another email address.";
        String actual=signUpEmailAlreadyRegisteredMessageText.getText().trim();
        if(errorMessage.contains(actual)){
            System.out.println(actual + "\t --> Alınan hata doğrudur.");
        }else{
            System.out.println(actual + "\t --> Alınan hata yanlıştır.");
        }
    }

    public void verifySignUpErrorMessageUsernameAlreadyRegistered(){
        String errorMessage = "entered has already been registered. Please try to register with another email username.";
        String actual=signUpUsernameAlreadyRegisteredMessageText.getText().trim();
        if(errorMessage.contains(actual)){
            System.out.println(actual + "\t --> Alınan hata doğrudur.");
        }else{
            System.out.println(actual + "\t --> Alınan hata yanlıştır.");
        }
    }


}
