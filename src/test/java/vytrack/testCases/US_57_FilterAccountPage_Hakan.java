package vytrack.testCases;

import org.jsoup.Jsoup;
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

public class US_57_FilterAccountPage_Hakan extends TestBase {

    //Extended TestBase class to use @BeforeMethod, @AfterMethod and Singleton
    //Added a lots of thread.sleep to see how it works and prevent test fails

    //Used data provider to test with each username at one run
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
    public static void test1_8filterItems(String username){

        //To use js ready methods created an actions object
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);

        //Login
        VytrackUtils.loginWithUsername( username );

        BrowserUtils.sleep(2);

        //Locate customer tab frame and move on it (using js method)
        WebElement customerTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]"));

        actions.moveToElement(customerTabFrame).perform();

        BrowserUtils.sleep(2);

        //Locate accounts tab frame and move on it
        WebElement accountsTabFrame = Driver.getDriver().findElement(By.xpath("//li[@data-route='oro_account_index']"));

        actions.moveToElement(accountsTabFrame).perform();

        BrowserUtils.sleep(2);

        //Locate accounts tab and move on it then click it
        WebElement accountsTab = Driver.getDriver().findElement(By.xpath("//li[@data-route='oro_account_index']//span[@class='title title-level-2']"));

        actions.moveToElement(accountsTab).perform();

        accountsTab.click();

        BrowserUtils.sleep(2);

        //Locate filter button and click it
        WebElement filterButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa-filter hide-text']"));

        filterButton.click();

        BrowserUtils.sleep(2);

        //Locate all filter web elements and store then in an arraylist
        ArrayList<WebElement>elementsList = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")));

        BrowserUtils.sleep(2);

        //Created an arraylist to store filter's actual names
        ArrayList<String>actualFilterNames = new ArrayList<>();

        //Get each filter web element and get text from them, then store them in the actualFilterNames arraylist
        for (WebElement each: elementsList){

            //I found this method from Google because normal way was getting me whole text, but I need only one part of it
            //So I googled and found this
            //It is doing very similar thing of webElement.getText(); so it's kinda optional we didn't see it in the class
            actualFilterNames.add(Jsoup.parse(each.getAttribute("outerHTML")).selectFirst("div[class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']").ownText());

        }

        BrowserUtils.sleep(2);

        //Print actual filter names
        System.out.println("actualFilterNames = " + actualFilterNames);

        //Created an arraylist to store expected filter names
        ArrayList<String> expectedFilterNames = new ArrayList<>( Arrays.asList( "Account name", "Contact name", "Contact email", "Contact phone", "Owner", "Business Unit", "Created At", "Updated At" ) );

        //Print expected filters
        System.out.println("expectedFilterNames = " + expectedFilterNames);

        BrowserUtils.sleep(2);

        //Assertion part
        Assert.assertEquals(actualFilterNames, expectedFilterNames);


    }


}
