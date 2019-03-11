import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.googlecloud.GoogleCloudHomePage;
import pages.googlecloud.GoogleCloudPlatformPricingCalculatorPage;
import pages.googlecloud.GoogleGpcPricingPage;
import pages.googlecloud.GoogleProductsAndServicesPage;


public class CreateNewOrderTest {


    private WebDriver driver;
    private final static String VM_CLASS_VALUE ="Regular";
    private final static String INSTANCE_TYPE = "n1-standard-8";
    private final static String REGION ="Frankfurt";
    private final static String LOCAL_SSD="2x375 GB";
    private final static String COMMITMENT_TERM="1 Year";
    private final static String TOTAL_ESTIMATE = "1,288.75";

    @Test
    public void createTestTree() {

        driver = DriverManager.getChromeDriver();
        driver.get("https://cloud.google.com/");

        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage (driver);
        googleCloudHomePage.clickExploreNewProductsButton();
        GoogleProductsAndServicesPage googleProductsAndServicesPage = new GoogleProductsAndServicesPage(driver);
        googleProductsAndServicesPage.clickSeePricingButton();
        GoogleGpcPricingPage googleGpcPricingPage = new GoogleGpcPricingPage(driver);
        googleGpcPricingPage.clickCaltulatorsButton();
        GoogleCloudPlatformPricingCalculatorPage calculatorPage = new GoogleCloudPlatformPricingCalculatorPage(driver);
        calculatorPage.switchToFrame();
        calculatorPage.setEngine("Compute Engine");
        calculatorPage.setNumberOfInstance("4");
        calculatorPage.setOperationSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        calculatorPage.setVmClass(VM_CLASS_VALUE);
        calculatorPage.setInstanceType(INSTANCE_TYPE);
        calculatorPage.selectAddGPUCheckbox();
        calculatorPage.selectGpuType("NVIDIA Tesla P100");
        calculatorPage.setNumberOfGPUs("4");
        calculatorPage.setLocalSsd(LOCAL_SSD);
        calculatorPage.setLocation(REGION);
        calculatorPage.setCommitedUsage(COMMITMENT_TERM);
        calculatorPage.clickAddToEstimate();

        Assert.assertTrue(calculatorPage.getVMClassText().contains(VM_CLASS_VALUE),"VM class is not same");
        Assert.assertTrue(calculatorPage.getInstanceTypeText().contains(INSTANCE_TYPE),"Instance Type is not same");
        Assert.assertTrue(calculatorPage.getSsdSpace().contains(LOCAL_SSD), "Local SSD is not the same");
        Assert.assertTrue(calculatorPage.getCommitmentTerm().contains(COMMITMENT_TERM),"Commitment Term is not the same");
        Assert.assertTrue(calculatorPage.getRegion().contains(REGION),"Region is not the same");
        Assert.assertTrue(calculatorPage.getTotalCost().contains(TOTAL_ESTIMATE),"Total estimate is not the same");


        }

    @AfterClass
    public void after(){
        driver.quit();
    }
}