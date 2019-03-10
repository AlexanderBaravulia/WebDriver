import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.googlecloud.GoogleCloudHomePage;
import pages.googlecloud.GoogleCloudPlatformPricingCalculatorPage;
import pages.googlecloud.GoogleGpcPricingPage;
import pages.googlecloud.GoogleProductsAndServicesPage;


public class CreateNewOrderTest {

    private WebDriver driver;
    private final static String VM_CLASS_VALUE ="regular";
    private final static String INSTANCE_TYPE = "n1-standard-8";
    private final static String REGION ="Frankfurt";
    private final static String LOCAL_SSD="2x375 GB";
    private final static String COMMITMENT_TERM="1 Year";

    @Test
    public void createTestTree() {

        driver = DriverManager.getWebDriver();
        driver.get("https://cloud.google.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");

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
        calculatorPage.setNumberOfGPUs("8");
        calculatorPage.setLocalSsd(LOCAL_SSD);
        calculatorPage.setLocation(REGION);
        calculatorPage.setCommitedUsage(COMMITMENT_TERM);

//
//        WebElement vmClass = driver.findElement(By.xpath("//div[contains(text(),\"VM class\")]"));
//        Assert.assertTrue(vmClass.getText().contains(VM_CLASS_VALUE),"VM class is not same");
//
//        WebElement instanceType = driver.findElement(By.xpath("//div[contains(text(),\"Instance type:\")]"));
//        Assert.assertTrue(instanceType.getText().contains(INSTANCE_TYPE), "Instance Type is not same");
//
//        WebElement localSsd = driver.findElement(By.xpath("//div[contains(text(),\"Total available local SSD space 2x375 GB\")]"));
//        Assert.assertTrue(localSsd.getText().contains(LOCAL_SSD), "Local SSD is not the same");
//
//        WebElement commitmentTerm = driver.findElement(By.xpath("//div[contains(text(),\"Commitment term: 1 Year\")]"));
//        Assert.assertTrue( commitmentTerm.getText().contains(COMMITMENT_TERM),"Commitment Term is not the same");
//
//        WebElement region = driver.findElement(By.xpath("//div[contains(text(), \"Region:\")]"));
//        Assert.assertTrue(region.getText().contains(REGION), "Region is not the same");
//        }

        }

    @AfterClass
    public void after(){
        driver.quit();
    }
}