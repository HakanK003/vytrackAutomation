package vytrack.testCases;

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

import java.util.ArrayList;
import java.util.Arrays;

public class US_58_SelectCheckboxes_Hakan extends TestBase {

    //Extended TestBase class to use @BeforeMethod, @AfterMethod and Singleton
    //Added a lots of thread.sleep to see how it works and prevent test fails

    //Used data provider to test with each username at one run
    @DataProvider(name="dataForTests")
    public Object[][] provideData(){
        return new Object[][]{

                {"user184"},
                {"user190"},

                {"storemanager100"},
                {"salesmanager270"},

                {"storemanager99"},
                {"salesmanager267"},
        };
    }


    @Test(dataProvider = "dataForTests")
    public void test1_checkThreeColumns(String username){

        //To use js ready methods created an actions object
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);

        //Login
        VytrackUtils.loginWithUsername( username );

        BrowserUtils.sleep(2);

        //Locate fleet tab frame and move on it (using js method)
        WebElement fleetTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));

        actions.moveToElement(fleetTabFrame).perform();

        BrowserUtils.sleep(2);

        //Locate vehicle costs tab frame and move on it then click it
        WebElement vehicleCostsTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item' and .='Vehicle Costs']"));

        actions.moveToElement(vehicleCostsTabFrame).perform();

        BrowserUtils.sleep(2);

        vehicleCostsTabFrame.click();

        BrowserUtils.sleep(2);

        //Created an arraylist to store expected columns titles
        ArrayList<String> expectedColumnsTitles = new ArrayList<>( Arrays.asList("TYPE", "TOTAL PRICE", "DATE") );

        //Created an arraylist to store columns titles web elements
        ArrayList<WebElement> columnsTitlesWebElements = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th[contains(@class, 'shortenable-label')]")));

        BrowserUtils.sleep(2);

        //Created an arraylist to store actual columns titles
        ArrayList<String> actualColumnsTitles = new ArrayList<>();

        //Get each title web element then get the text (titles) and trim to get rid of extra spaces
        for (WebElement each : columnsTitlesWebElements) {

            actualColumnsTitles.add(each.getText().trim());

        }

        //Print expected columns titles
        System.out.println("expectedColumnsTitles = " + expectedColumnsTitles);

        //Print actual columns titles
        System.out.println("actualColumnsTitles = " + actualColumnsTitles);

        //Assertion part
        Assert.assertEquals(actualColumnsTitles, expectedColumnsTitles);

    }



    @Test(dataProvider = "dataForTests")
    public void test2_checkCheckboxes(String username){

        //To use js ready methods created an actions object
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);

        //Login
        VytrackUtils.loginWithUsername( username );

        BrowserUtils.sleep(2);

        //Locate fleet tab frame and move on it (using js method)
        WebElement fleetTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));

        actions.moveToElement(fleetTabFrame).perform();

        BrowserUtils.sleep(2);

        //Locate vehicle costs tab frame and move on it then click it
        WebElement vehicleCostsTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item' and .='Vehicle Costs']"));

        actions.moveToElement(vehicleCostsTabFrame).perform();

        BrowserUtils.sleep(2);

        vehicleCostsTabFrame.click();

        BrowserUtils.sleep(2);

        //Located first checkbox then click it
        WebElement firstCheckbox = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//button[@data-toggle='dropdown']/input[@data-select]"));

        firstCheckbox.click();

        //Located other checkboxes and stored then in an arraylist
        ArrayList<WebElement> otherCheckboxes = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']")));

        BrowserUtils.sleep(2);

        //Check each checkbox if they are selected (Assertion part)
        for (WebElement eachCheckbox : otherCheckboxes) {

            Assert.assertTrue(eachCheckbox.isSelected());

        }

    }

}
