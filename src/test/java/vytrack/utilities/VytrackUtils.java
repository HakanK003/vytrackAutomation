package vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VytrackUtils {

    public static void login(String username, String password){

        //go to website
       Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //pass username
        Driver.getDriver().findElement(By.id(""));

        //pass password

     
    }

    public static void loginAsDriver(){}

    public static void loginAsStoreManager(){}

    public static void loginAsSalesManager(){}





}
