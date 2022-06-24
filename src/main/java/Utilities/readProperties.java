package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readProperties {

    public static String getData(String whichData) {



        String path = "configuration.properties";

        String result = null;

        try {
            InputStream input = new FileInputStream(path);

            Properties prop = new Properties();

            prop.load(input);
            result = prop.getProperty(whichData);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return result;
    }



}
