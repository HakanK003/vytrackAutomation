package vytrack.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vytrack.pages.LoginPage;
import vytrack.pages.MainPage;
import vytrack.tests.base.TestBase;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_46_ModuleAccessLevel_Maxim extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;


    @DataProvider(name = "truckDriverLogin")
    public Object[][] driverData() {
        return new Object[][]{
                {"user156", "UserUser123"},
                {"user157", "UserUser123"},
                {"user158", "UserUser123"},
                {"user159", "UserUser123"},

        };

    }

    @DataProvider(name = "store_sales_manager_login")
    public Object[][] managerData() {
        return new Object[][]{
                {"storemanager99", "UserUser123"},
                {"storemanager100", "UserUser123"},
                {"salesmanager267", "UserUser123"},
                {"salesmanager268", "UserUser123"},
                {"salesmanager269", "UserUser123"},
                {"salesmanager270", "UserUser123"},

        };

    }

// TESTING  Modules access visibility for DRIVERS
    @Test(dataProvider = "truckDriverLogin")
    public void driverModulesAccessTest(String user, String password) {

        //Create List of expected modules for driver.
        List<String> driverAccessModules = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));

        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginPage.usernameInputBox.sendKeys(user);
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.logInBtn.click();


        // compare all  WevElements text with EXPECTED Modules text (from List);
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(mainPage.modules.get(i).getText().equals(driverAccessModules.get(i)));
        }


        // compare Actual size of  'List of WebElements'  with Expected 'List of modules' size.
        Assert.assertTrue(mainPage.modules.size() == driverAccessModules.size());


    }


    // TESTING  Modules access visibility for DRIVERS
    @Test(dataProvider = "store_sales_manager_login")
    public void managersModulesAccessTest(String user, String password) {

        //Create List of expected modules for driver.
        List<String> managerAccessModules = new ArrayList<>(Arrays.asList("Dashboards","Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));

        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginPage.usernameInputBox.sendKeys(user);
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.logInBtn.click();


        // compare all  WevElements text with EXPECTED Modules text (from List);
        for (int i = 0; i < 8; i++) {
            Assert.assertTrue(mainPage.modules.get(i).getText().equals(managerAccessModules.get(i)));
        }


        // compare Actual size of  'List of WebElements'  with Expected 'List of modules' size.
        Assert.assertTrue(mainPage.modules.size() == managerAccessModules.size());


    }


}
