package vytrack.US27_Alena_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vytrack.utilities.Driver;

public class GoToFleetTab {

    public  GoToFleetTab(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1'][1]")
    public WebElement fleetTab;




}
