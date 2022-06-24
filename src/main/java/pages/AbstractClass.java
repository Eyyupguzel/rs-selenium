package pages;

import Utilities.Driver;
import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public abstract class AbstractClass {


    WebDriver driver;
    WebDriverWait wait;
    Logger logger;

    // element bulunana kadar 30 saniye bekleme methodu
    public void waitMethod(int seconds, TimeUnit timeUnit){

        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    public AbstractClass() {

        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        this.logger = LoggerHelper.getLogger(LoggerHelper.class);
        //this.wait = new WebDriverWait(driver,30);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    // element üzerine gelip bekleme methodu
      public void hoverElement(WebElement element) {
          Actions actions = new Actions(driver);
          actions.moveToElement(element).build().perform();
      }
    // bir elementin olmadığının kontolü methodu
    public boolean notFindElement(WebElement webElement) {
      try {
          wait.until(ExpectedConditions.visibilityOf(webElement));
          //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) webElement));
          logger.info("Element " + webElement + " is visible and clickable");
          return false;
      } catch (Exception ignored) {
          return true;
      }
  }
    // element olduğunun kontrolü methodu
    public boolean findElement(WebElement webElement) {


        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) webElement));
            logger.info("Element " + webElement + " is visible and clickable");
            return true;
        } catch (Exception ignored) {
            logger.error(webElement + "is not visible",ignored);
            return false;

        }
    }

    //Bir elemente tıklama methodu
    public void clickOnFunctionalities(WebElement clickElement)  {

             waitMethod(15,TimeUnit.SECONDS);

        //tıklamadan önce görünür ve tıklanabilir olmasını bekler
       try {

            wait.until(ExpectedConditions.visibilityOf(clickElement));
            wait.until(ExpectedConditions.elementToBeClickable(clickElement));
            logger.info(clickElement+"\tis visible and clickable");


        } catch (Exception e)    {

            //System.out.println(e.getMessage());
            logger.error(clickElement+ "\tis not visible.",e);

        }

        clickElement.click();
        logger.info(clickElement+"\tclicked.");
    }

    // bir alana değer yazdırma
    public void sendKeysFunction(WebElement sendkeysElement, String value) {

        waitMethod(15,TimeUnit.SECONDS);

        //yazmadan önce o alanın görünür olmasını bekler
        try {
            wait.until(ExpectedConditions.visibilityOf(sendkeysElement));


            logger.info(sendkeysElement + "\tis visible " + value + "\t value can type.");
        } catch (Exception e) {

            logger.error(sendkeysElement+"\tis not visible ",e);
            //System.out.println(e.getMessage());
        }
        sendkeysElement.sendKeys(value);
        logger.info(sendkeysElement+"\t typed.");
    }

    // görünür olana kadar bekleme methodu
    public void waitUntilVisibility(WebElement waitElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(waitElement));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    //random tıklama methodu
    public void randomMethod( List<WebElement> random) {

        int randomNum = randomGenerator(random.size());
        clickOnFunctionalities(random.get(randomNum));


    }

    //random değer belirleme
    public int randomGenerator(int max) {

        Random random = new Random();
        int randomNum = random.nextInt(max);
        return randomNum;
    }



    //ekranı kaydırma methodu
    public void scrollDown() {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }


    //Açılır seçeneklerde seçtirme methodu
    public void selectInDropDown(WebElement dropdown){
        Select select = new Select(dropdown);
        List<WebElement> list = select.getOptions();

        select.selectByIndex(39);
    }

    // url kontrol methodu
    public void verifyURL(String expectedResult){

        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains( expectedResult ),"URL\t"+URL+"\tnot virified. " );
        logger.info("URL \t"+URL+"\tverified");

    }

    //gelen uyarıyı kabul etme methodu
    public void confirmAlert(){

        driver.switchTo().alert().accept();  //to accept alert (uyarı kabulü)

    }


    //bir değerin kontrolü
    public void verifyValue(WebElement element, String expected) {
        String actual=element.getText();
        Assert.assertEquals(actual,expected,"Value\t"+expected+"\t not verified.");
        logger.info("Value\t" + expected +"\t verified.");

    }


    public String getAmountFromConfirmation(WebElement element) {

        String text = element.getText();

        System.out.println(element.getText() + "<<<<<<<<<<<_-----------------text is here ");


        return text;
    }

    public void verifyTotalPrice( List<WebElement> expected, String  element ){


        boolean isTextExpected = false;

        for (int i = 0; i < expected.size(); i++) {
            String expectedText = expected.get(i).getText();
            System.out.println(expectedText + ">>>>expectedlist");

            System.out.println(element + ">>>>>>>>>>>>>>element");

            if(expectedText.trim().equalsIgnoreCase(element)){
                isTextExpected = true;
                break;
            }else {
                isTextExpected = false;
            }
        }

        if(isTextExpected){
            System.out.println("application is fine");
        }else{
            Assert.assertTrue(false);
        }

    }

    //static bekleme methodu
    public void sleep(int num){

        try{
            Thread.sleep(num * 1000);
            logger.info(num + "\t saniye bekledi.");
        }catch(Exception e){
            logger.error("Bekleyemedi",e);
            //System.out.println(e.getMessage());
        }
    }






     /*  public WebElement findElement(WebElement element){

           return driver.findElement((By) element);
       }


    /*public void clickJS(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        WebElement OSCARS_BUTTON = driver.findElement(By.xpath("//span[@class='ipc-list-item__text' and text()='Oscars']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", OSCARS_BUTTON);
    }
  */


}
