package pages.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleGpcPricingPage {

    @FindBy(xpath = "//a[@track-name=\"pricingNav/calculators\"]")
    private WebElement calculatorsButton;

    public GoogleGpcPricingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickCaltulatorsButton(){
        calculatorsButton.click();
    }
}
