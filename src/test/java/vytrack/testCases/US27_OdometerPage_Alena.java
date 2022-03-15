package vytrack.testCases;

import com.sun.jna.Structure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vytrack.tests.base.TestBase;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

public class US27_OdometerPage_Alena extends TestBase {

    @DataProvider(name="dataForTest1")
    public Object[][] provideData(){
        return new Object[][]{

                {"storemanager100"},
                {"salesmanager270"},

                {"storemanager99"},
                {"salesmanager267"},
        };
    }

    @Test(dataProvider = "dataForTest1")
    public static void noManagersAccess(String username){
        //# Truck Drivers:   user 150        user155
        //# Store Managers: storemanager99   storemanager100
        //# Sales Managers:  salesmanager267   salesmanager270

        Actions actions = new Actions(Driver.getDriver());

        VytrackUtils.loginWithUsername(username);
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



    @DataProvider(name = "truckDriverLogin")
    public Object[][] driverData() {
        return new Object[][]{

                {"user150", "UserUser123"},
              //  {"user151", "UserUser123"},
             //   {"user152", "UserUser123"},
             //   {"user153", "UserUser123"},
             //   {"user154", "UserUser123"},
             //   {"user155", "UserUser123"},


        };
    }

        @Test(dataProvider = "truckDriverLogin")
     public static void driverAccess(String user, String password){

        Actions actions = new Actions(Driver.getDriver());

        VytrackUtils.loginWithUsername(user);
        BrowserUtils.sleep(3);

        WebElement fleetTab = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        actions.moveToElement(fleetTab).perform();
        BrowserUtils.sleep(3);

        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item' and .='Vehicle Odometer']"));
        vehicleOdometer.click();
        BrowserUtils.sleep(3);

        WebElement defaultPage1 = Driver.getDriver().findElement(By.xpath("//input[@value=\"1\"]"));
        String actualResult = defaultPage1.getAttribute("value");
        System.out.println(actualResult);
        String expectedResult = "1";

        Assert.assertEquals(actualResult,expectedResult);

      /*  WebElement viewPerPage25 = Driver.getDriver().findElement(By.xpath("//span[@class='caret']"));
        String actualResult25 = viewPerPage25.getText();
        System.out.println(actualResult25);
        String expectedResult25 = "25";

        Assert.assertEquals(actualResult25,expectedResult25);*/






    }






}
