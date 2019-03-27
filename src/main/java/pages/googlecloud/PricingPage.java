package pages.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class PricingPage extends BasePage {

    private final static String PAGE_URL = "https://cloud.google.com/pricing/";

    @FindBy(xpath = "//a[@track-name=\"pricingNav/calculators\"]")
    private WebElement calculatorsButton;

    public PricingPage(WebDriver driver){
        super(driver);
    }

    @Override
    public BasePage open() {
        logger.info("Pricing page is opened.");
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CalculatorPage clickCaltulatorsButton(){
        calculatorsButton.click();
        return new CalculatorPage(driver);
    }
}
