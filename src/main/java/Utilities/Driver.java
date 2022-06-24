package Utilities;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AbstractClass;
import Utilities.readProperties;
public class Driver {

    private static WebDriver driver;


    public static WebDriver getDriver() {
        Logger logger = LoggerHelper.getLogger(LoggerHelper.class);
        if (driver == null) {
           String driver_path= readProperties.getData("driverPath");
            System.setProperty("webdriver.chrome.driver", driver_path);
            driver = new ChromeDriver();

        }
        return driver;
    }

    public static void closeDriver() {
        Logger logger = LoggerHelper.getLogger(LoggerHelper.class);
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Driver closed.");


        }

    }



}
