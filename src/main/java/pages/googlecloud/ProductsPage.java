package pages.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ProductsPage extends BasePage {

    private final static String PAGE_URL = "https://cloud.google.com/products/";

    @FindBy (xpath = "//a[@track-name=\"seePricing\"]")
    private WebElement seePricingButton;

    @Override
    public ProductsPage open() {
        driver.navigate().to(PAGE_URL);
        logger.info("Products page is opened.");
        return this;
    }

    public ProductsPage(WebDriver driver){
        super(driver);
        }

    public PricingPage clickSeePricingButton(){
        seePricingButton.click();
        return new PricingPage(driver);
    }
}
