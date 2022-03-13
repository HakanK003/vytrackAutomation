package vytrack.testCases;

import com.sun.jna.Structure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import vytrack.tests.base.TestBase;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

public class AlenaUS27_OdometerPage extends TestBase {

    @Test
    public static void noManagersAccess(){
        //# Truck Drivers:   user 150        user155
        //# Store Managers: storemanager99   storemanager100
        //# Sales Managers:  salesmanager267   salesmanager270

        Actions actions = new Actions(Driver.getDriver());

        VytrackUtils.loginWithUsername("storemanager99");
        BrowserUtils.sleep(3);

        WebElement fleetTab = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        actions.moveToElement(fleetTab).perform();
        BrowserUtils.sleep(3);

        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item' and .='Vehicle Odometer']"));
        vehicleOdometer.click();
        BrowserUtils.sleep(3);

        String expectedMessage = "You do not have permission to perform this action";
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

        String actualMessage = errorMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public static void driverAccess(){

        Actions actions = new Actions(Driver.getDriver());

        VytrackUtils.loginWithUsername("user155");
        BrowserUtils.sleep(3);

        WebElement fleetTab = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        actions.moveToElement(fleetTab).perform();
        BrowserUtils.sleep(3);

        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item' and .='Vehicle Odometer']"));
        vehicleOdometer.click();
        BrowserUtils.sleep(3);

        WebElement defaultPage1 = Driver.getDriver().findElement(By.xpath("//input[@value=\"1\"]"));
        //String actualResult = defaultPage1;
        System.out.println(defaultPage1);
        String expectedResult = "1";

        Assert.assertTrue(expectedResult.equals(defaultPage1.getText()));




    }






}
