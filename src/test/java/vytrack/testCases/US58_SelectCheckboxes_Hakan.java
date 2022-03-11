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

public class US58_SelectCheckboxes_Hakan extends TestBase {

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

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);

        VytrackUtils.loginWithUsername( username );

        BrowserUtils.sleep(2);

        WebElement fleetTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));

        actions.moveToElement(fleetTabFrame).perform();

        BrowserUtils.sleep(2);

        WebElement vehicleCostsTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item' and .='Vehicle Costs']"));

        actions.moveToElement(vehicleCostsTabFrame).perform();

        BrowserUtils.sleep(2);

        vehicleCostsTabFrame.click();

        BrowserUtils.sleep(2);

        ArrayList<String> expectedColumnsTitles = new ArrayList<>( Arrays.asList("TYPE", "TOTAL PRICE", "DATE") );

        ArrayList<WebElement> columnsTitlesWebElements = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th[contains(@class, 'shortenable-label')]")));

        BrowserUtils.sleep(2);

        ArrayList<String> actualColumnsTitles = new ArrayList<>();

        for (WebElement each : columnsTitlesWebElements) {

            actualColumnsTitles.add(each.getText().trim());

        }

        System.out.println("expectedColumnsTitles = " + expectedColumnsTitles);

        System.out.println("actualColumnsTitles = " + actualColumnsTitles);


        Assert.assertEquals(actualColumnsTitles, expectedColumnsTitles);

    }



    @Test(dataProvider = "dataForTests")
    public void test2_checkCheckboxes(String username){

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);

        VytrackUtils.loginWithUsername( username );

        BrowserUtils.sleep(2);

        WebElement fleetTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));

        actions.moveToElement(fleetTabFrame).perform();

        BrowserUtils.sleep(2);

        WebElement vehicleCostsTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown-menu-single-item' and .='Vehicle Costs']"));

        actions.moveToElement(vehicleCostsTabFrame).perform();

        BrowserUtils.sleep(2);

        vehicleCostsTabFrame.click();

        BrowserUtils.sleep(2);

        WebElement firstCheckbox = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//button[@data-toggle='dropdown']/input[@data-select]"));

        firstCheckbox.click();

        ArrayList<WebElement> otherCheckboxes = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']")));

        BrowserUtils.sleep(2);

        for (WebElement eachCheckbox : otherCheckboxes) {

            Assert.assertTrue(eachCheckbox.isSelected());

        }

    }

}
