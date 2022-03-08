package vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackUtils {


    public static void loginAsDriver() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement logInBtn = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        logInBtn.click();

    }


    public static void loginAsStoreManager() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("store_manager_username"));

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement logInBtn = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        logInBtn.click();


    }

    public static void loginAsSalesManager() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement logInBtn = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        logInBtn.click();
    }


}
