package vytrack.tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import vytrack.utilities.ConfigurationReader;
import vytrack.utilities.Driver;

public abstract class TestBase {

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
