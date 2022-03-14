package vytrack.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrack.tests.base.TestBase;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.ConfigurationReader;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

public class US_51_ViewEditCarIcons extends TestBase{

    @Test
    public void test1(){
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(5);
    }




}
