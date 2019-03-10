package pages.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudHomePage {

    @FindBy (xpath = "//a[@track-name=\"exploreProducts\"]")
    private WebElement exploreNewProductsButton;

    public GoogleCloudHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickExploreNewProductsButton(){
        exploreNewProductsButton.click();
    }
}
