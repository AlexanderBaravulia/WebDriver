package pages.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleProductsAndServicesPage {

    @FindBy (xpath = "//a[@track-name=\"seePricing\"]")
    private WebElement seePricingButton;

    public GoogleProductsAndServicesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickSeePricingButton(){
        seePricingButton.click();
    }
}
