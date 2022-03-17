package vytrack.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.ConfigurationReader;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

public class US_49_VehicleContracts_Adrian {


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    @Test
    public void test1() {
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(3);

        //Log into Vytrack as Store Manager
        VytrackUtils.loginAsStoreManager();
        BrowserUtils.sleep(3);

        //Locate the Fleet button
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetButton).perform();
        BrowserUtils.sleep(3);

        //Locate and click on Vehicle Contracts button
        WebElement vehicleContractsButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span"));
        actions.moveToElement(vehicleContractsButton).click().perform();
        BrowserUtils.sleep(3);

        //Confirm that the Vehicle Contracts page is accessible
        WebElement allContracts = Driver.getDriver().findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1"));
        if (allContracts.isDisplayed()){
            System.out.println("Store Manager has access to the Vehicle Contracts page");
        }

    }

    @Test
    public void test2() {

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(3);

        //Log into Vytrack as a Driver
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(3);

        //Locate the Fleet button
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        actions.moveToElement(fleetButton).perform();
        BrowserUtils.sleep(3);

        //Locate and click on Vehicle Contracts button
        WebElement vehicleContractsButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[6]/a/span"));
        actions.moveToElement(vehicleContractsButton).click().perform();
        BrowserUtils.sleep(3);

        //Verify that the Driver cannot access the Vehicle Contracts page
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div"));
        System.out.println(errorMessage.getText());
    }

    @AfterMethod
    public void exitBrowser() {
        Driver.closeDriver();
    }

}
