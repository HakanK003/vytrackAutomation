package vytrack.US27_Alena_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vytrack.utilities.Driver;

public class VehicleOdometerPage {

        public VehicleOdometerPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "\"//li[@class='dropdown-menu-single-item' and .='Vehicle Odometer']\"")
    public WebElement vehicleOdometer;
}
