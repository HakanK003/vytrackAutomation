package vytrack.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import vytrack.tests.base.TestBase;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class US_50_ViewVehicleModelsPage  extends TestBase {

    /* TestBase-content
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }
    @AfterMethod
    public void tearDown(){
       Driver.closeDriver();
   }
     */

    @Test
    public static void test1_StoreManagerVehicleModelsView(){
        Actions actions=new Actions(Driver.getDriver());// to use actions methods we first have to create action object
        BrowserUtils.sleep(2);

        //login 1st step
        VytrackUtils.loginAsStoreManager();
        BrowserUtils.sleep(2);

        //Locate "Fleet" tab 2nd step
        WebElement fleetTab=Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));

        // move to Fleet and click on it 3rd step
        actions.moveToElement(fleetTab).perform();
        BrowserUtils.sleep(2);

        // locate "Vehicle Models"under Fleet Tab 4th step
        WebElement vehicleModelsTab=Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[9]/a/span"));

        // move to Vehicle Models and click on it/ 5th step
        actions.moveToElement(vehicleModelsTab).perform();
        BrowserUtils.sleep(2);
        vehicleModelsTab.click();
        BrowserUtils.sleep(3);

        //verify if Store Manager can see 10 columns under Vehicle Models Page/ 6th step
        ArrayList<String> columnName= new ArrayList<>( Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI",
                "CO2 FEE (/MONTH)", "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS") );

        // find the table header row with all column names// 7th step
        WebElement tableHeaderRow=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']"));

        //find "ModelName"
        WebElement modelName=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[2]/a/span[1]"));
        System.out.println( "MODEL-NAME: " + modelName.getText());
        Assert.assertEquals(modelName.getText(), columnName.get(0));

        // find "Make"
        WebElement makeTab=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[3]/a/span[1]"));
        System.out.println( "MAKE: " + makeTab.getText() );
        Assert.assertEquals(makeTab.getText(), columnName.get(1));

        //find "CanBeRequested"
        WebElement canBeRequested=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[4]/a/span[1]"));
        System.out.println( "CAN-BE-REQUESTED: " + canBeRequested.getText());
        Assert.assertEquals(canBeRequested.getText(), columnName.get(2));

        // find "CVVI"
        WebElement cvvi=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[5]/a/span[1]"));
        System.out.println( "CVVI: " + cvvi.getText() );
        Assert.assertEquals(cvvi.getText(), columnName.get(3));

        //find "CO2 FEE(/MONTH)"
        WebElement co2=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[6]/a/span[1]"));
        System.out.println( "C02 FEE (/MONTH): " + co2.getText());
        Assert.assertEquals(co2.getText(), columnName.get(4));

        // find "COST (DEPRECATED)"
        WebElement cost=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[7]/a/span[1]"));
        System.out.println( "COST (DEPRECATED): " + cost.getText() );
        Assert.assertEquals(cost.getText(), columnName.get(5));

        // find "TOTAL COST (DEPRECIATED)"
        WebElement totalCost=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[8]/a/span[1]"));
        System.out.println( "TOTAL COST (DEPRECIATED): " + totalCost.getText() );
        Assert.assertEquals(totalCost.getText(), columnName.get(6));

        // find "CO2 EMISSIONS"
        WebElement co2emissions=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[9]/a/span[1]"));
        System.out.println( "CO2 EMISSIONS: " + co2emissions.getText() );
        Assert.assertEquals(co2emissions.getText(), columnName.get(7));

        // find "FUEL TYPE"
        WebElement fuelType=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[10]/a/span[1]"));
        System.out.println( "FUEL TYPE: " + fuelType.getText() );
        Assert.assertEquals(fuelType.getText(), columnName.get(8));

        // find "VENDORS"
        WebElement vendors=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[11]/a/span[1]"));
        System.out.println( "VENDORS: " + vendors.getText() );
        Assert.assertEquals(vendors.getText(), columnName.get(9));

        BrowserUtils.sleep(5);
    }

    @Test
    public static void test2_SalesManagerVehicleModelsView(){
        Actions actions=new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        //login 1st step
        VytrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(2);

        //Locate "Fleet" tab 2nd step
        WebElement fleetTab=Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));

        //move to Fleet and click on it 3rd step
        actions.moveToElement(fleetTab).perform();
        BrowserUtils.sleep(2);

        // locate "Vehicle Models"under Fleet Tab 4th step
        WebElement vehicleModelsTab=Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[9]/a/span"));

        // move to Vehicle Models and click on it/ 5th step
        actions.moveToElement(vehicleModelsTab).perform();
        BrowserUtils.sleep(2);
        vehicleModelsTab.click();
        BrowserUtils.sleep(3);

        //verify if Store Manager can see 10 columns under Vehicle Models Page/ 6th step
        ArrayList<String> columnName= new ArrayList<>( Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI",
                "CO2 FEE (/MONTH)", "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS") );

        // find the table header row with all column names// 7th step
        WebElement tableHeaderRow=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']"));

        //find "ModelName"
        WebElement modelName=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[2]/a/span[1]"));
        System.out.println( "MODEL-NAME: " + modelName.getText());
        Assert.assertEquals(modelName.getText(), columnName.get(0));

        // find "Make"
        WebElement makeTab=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[3]/a/span[1]"));
        System.out.println( "MAKE: " + makeTab.getText() );
        Assert.assertEquals(makeTab.getText(), columnName.get(1));

        //find "CanBeRequested"
        WebElement canBeRequested=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[4]/a/span[1]"));
        System.out.println( "CAN-BE-REQUESTED: " + canBeRequested.getText());
        Assert.assertEquals(canBeRequested.getText(), columnName.get(2));

        // find "CVVI"
        WebElement cvvi=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[5]/a/span[1]"));
        System.out.println( "CVVI: " + cvvi.getText() );
        Assert.assertEquals(cvvi.getText(), columnName.get(3));

        //find "CO2 FEE(/MONTH)"
        WebElement co2=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[6]/a/span[1]"));
        System.out.println( "C02 FEE (/MONTH): " + co2.getText());
        Assert.assertEquals(co2.getText(), columnName.get(4));

        // find "COST (DEPRECATED)"
        WebElement cost=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[7]/a/span[1]"));
        System.out.println( "COST (DEPRECATED): " + cost.getText() );
        Assert.assertEquals(cost.getText(), columnName.get(5));

        // find "TOTAL COST (DEPRECIATED)"
        WebElement totalCost=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[8]/a/span[1]"));
        System.out.println( "TOTAL COST (DEPRECIATED): " + totalCost.getText() );
        Assert.assertEquals(totalCost.getText(), columnName.get(6));

        // find "CO2 EMISSIONS"
        WebElement co2emissions=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[9]/a/span[1]"));
        System.out.println( "CO2 EMISSIONS: " + co2emissions.getText() );
        Assert.assertEquals(co2emissions.getText(), columnName.get(7));

        // find "FUEL TYPE"
        WebElement fuelType=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[10]/a/span[1]"));
        System.out.println( "FUEL TYPE: " + fuelType.getText() );
        Assert.assertEquals(fuelType.getText(), columnName.get(8));

        // find "VENDORS"
        WebElement vendors=Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[11]/a/span[1]"));
        System.out.println( "VENDORS: " + vendors.getText() );
        Assert.assertEquals(vendors.getText(), columnName.get(9));

        BrowserUtils.sleep(5);
    }

    @Test
    public static void test3_DriversVehicleModelsView(){
        Actions actions=new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        //login 1 step
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(2);

        //Locate "Fleet" tab 2nd step
        WebElement fleetTab=Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));

        //move to Fleet and click on it 3rd step
        actions.moveToElement(fleetTab).perform();
        BrowserUtils.sleep(2);

        // locate "Vehicle Models"under Fleet Tab 4th step
        WebElement vehicleModelsTab=Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[9]/a/span"));

        // move to Vehicle Models and click on it/ 5th step
        actions.moveToElement(vehicleModelsTab).perform();
        BrowserUtils.sleep(2);
        vehicleModelsTab.click();
        BrowserUtils.sleep(3);

        //verify that driver receives warning message "You do not have permission to perform this action." / 6th step
        WebElement popUpMessage=Driver.getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div"));
        String expectedPopUpMessage="You do not have permission to perform this action.";
        String actualPopUpMessage=popUpMessage.getText();
        Assert.assertEquals(actualPopUpMessage,expectedPopUpMessage);
        BrowserUtils.sleep(5);



    }


}
