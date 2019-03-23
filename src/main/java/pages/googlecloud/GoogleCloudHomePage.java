package pages.googlecloud;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import pages.BasePage;

public class GoogleCloudHomePage extends BasePage {

    private final static String PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//a[@track-name=\"exploreProducts\"]")
    private WebElement exploreNewProductsButton;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleCloudHomePage open() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public ProductsPage clickExploreNewProductsButton() {
        exploreNewProductsButton.click();
        return new ProductsPage(driver);
    }
}
