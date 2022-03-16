package vytrack.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrack.tests.base.TestBase;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.ConfigurationReader;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

import java.util.ArrayList;


public class US_52_SelectVehicle_Mode_Anastasia  {

    @BeforeMethod
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        VytrackUtils.loginAsStoreManager();
        BrowserUtils.sleep(2);
    }

   @Test
    public void test1(){

        //locate fleetButton
       WebElement fleetButton = Driver.getDriver().findElement(By.xpath
               ("//li[@class='dropdown dropdown-level-1'][1]"));
       //locate vehicleButton
       WebElement vehicleButton = Driver.getDriver().findElement
               (By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]"));

        // Creating actions object to use JS's methods
       Actions actions = new Actions(Driver.getDriver());

       //Hover over fleetButton
       actions.moveToElement(fleetButton).perform();
       BrowserUtils.sleep(2);

       //Hover over vehicleButton and click it
       actions.moveToElement(vehicleButton).click().perform();
       BrowserUtils.sleep(2);

       //Locate the 1st checkbox"));

       ArrayList<WebElement> allCheckboxes = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/input")));

       //Check if each checkbox is selected
       for (WebElement eachCheckbox : allCheckboxes) {

           Assert.assertFalse(eachCheckbox.isSelected());
           System.out.println("Step 1: All boxes are unchecked");

       }
       BrowserUtils.sleep(2);

       WebElement firstCheckbox = Driver.getDriver().findElement
               (By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/thead[1]/tr/th[1]/div/button/input"));

        //actions.moveToElement(firstCheckbox).click().perform();
         firstCheckbox.click();

      // ArrayList<WebElement> allCheckboxes = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/input")));

       //Check if each checkbox is selected
       for (WebElement eachCheckbox : allCheckboxes) {

           Assert.assertTrue(eachCheckbox.isSelected());
           System.out.println("Step 2: All boxes are checked");
       }
       BrowserUtils.sleep(2);
       firstCheckbox.click();
       BrowserUtils.sleep(2);
       WebElement randomCheckbox = Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div/table/tbody/tr[5]/td[1]/input"));

       randomCheckbox.click();
       BrowserUtils.sleep(2);
       Assert.assertTrue(randomCheckbox.isSelected());
       System.out.println("Step 3: Random box is checked");



           Driver.closeDriver();



   }




}