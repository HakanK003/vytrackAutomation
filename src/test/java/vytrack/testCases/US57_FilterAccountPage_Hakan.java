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
import vytrack.utilities.ConfigurationReader;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class US57_FilterAccountPage_Hakan extends TestBase {

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

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);

        VytrackUtils.loginWithUsername( username );

        BrowserUtils.sleep(2);

        WebElement customerTabFrame = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]"));

        actions.moveToElement(customerTabFrame).perform();

        BrowserUtils.sleep(2);

        WebElement accountsTabFrame = Driver.getDriver().findElement(By.xpath("//li[@data-route='oro_account_index']"));

        actions.moveToElement(accountsTabFrame).perform();

        BrowserUtils.sleep(2);

        WebElement accountsTab = Driver.getDriver().findElement(By.xpath("//li[@data-route='oro_account_index']//span[@class='title title-level-2']"));

        actions.moveToElement(accountsTab).perform();

        accountsTab.click();

        BrowserUtils.sleep(2);

        WebElement filterButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa-filter hide-text']"));

        filterButton.click();

        BrowserUtils.sleep(2);

        ArrayList<WebElement>elementsList = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']")));

        BrowserUtils.sleep(2);

        ArrayList<String>actualFilterNames = new ArrayList<>();

        for (WebElement each: elementsList){

            actualFilterNames.add(Jsoup.parse(each.getAttribute("outerHTML")).selectFirst("div[class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value']").ownText());

        }

        BrowserUtils.sleep(2);

        System.out.println("actualFilterNames = " + actualFilterNames);

        ArrayList<String> expectedFilterNames = new ArrayList<>( Arrays.asList( "Account name", "Contact name", "Contact email", "Contact phone", "Owner", "Business Unit", "Created At", "Updated At" ) );

        System.out.println("expectedFilterNames = " + expectedFilterNames);

        BrowserUtils.sleep(2);

        Assert.assertEquals(actualFilterNames, expectedFilterNames);


    }


}
