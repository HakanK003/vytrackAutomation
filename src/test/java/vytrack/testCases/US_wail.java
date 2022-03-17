package vytrack.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrack.tests.base.TestBase;
import vytrack.utilities.BrowserUtils;
import vytrack.utilities.ConfigurationReader;
import vytrack.utilities.Driver;
import vytrack.utilities.VytrackUtils;

public class US_wail extends TestBase {


    @Test
    public void testOne() {

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(3);

        // log in as Store manager
        VytrackUtils.loginAsStoreManager();
        BrowserUtils.sleep(3);

        //locate activities
        WebElement locateActivities = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"));
        actions.moveToElement(locateActivities).click().perform();
        BrowserUtils.sleep(3);

        //click the calendar event
        WebElement clickCalendarButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]/a/span"));
        actions.moveToElement(clickCalendarButton).click().perform();
        BrowserUtils.sleep(3);

        //Click the “Create Calendar Event” button
        WebElement clickCreatCalendarEvent = Driver.getDriver().findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[2]/div/a"));
        actions.moveToElement(clickCreatCalendarEvent).click().perform();
        BrowserUtils.sleep(3);

        //Check the Repeat checkbox
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//*[@id=\"recurrence-repeat-view1284\"]"));
        actions.moveToElement(checkBox).click().perform();
        BrowserUtils.sleep(3);

        //Users enter an INVALID integer (x<1 || x>99)
        WebElement invalidInteger = Driver.getDriver().findElement(By.xpath("//div[@class='recurrence-subview-control__item'][1]//input[@class='recurrence-subview-control__number']"));
        String invalidInt = invalidInteger.getAttribute("value");
        invalidInteger.sendKeys(Keys.BACK_SPACE, "0", Keys.ENTER);
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//span[.='The value have not to be less than 1.']"));
        String expectedErrorMessage = "The value have not to be less than 1.";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);


    }
}
