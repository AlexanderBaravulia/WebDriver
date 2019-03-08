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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateNewOrder {

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
        WebElement buttonExploreAllProducts = driver.findElement(By.xpath("//a[@track-name=\"exploreProducts\"]"));
        buttonExploreAllProducts.click();


        WebElement buttonSeePricing = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[@track-name=\"seePricing\"]")))
                .findElement(By.xpath("//div/a[@track-name=\"seePricing\"]"));
        buttonSeePricing.click();

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs("GCP Pricing  |  Google Cloud"));
        WebElement buttonCalculators = driver.findElement(By.xpath("//a[@track-name=\"pricingNav/calculators\"]"));
        buttonCalculators.click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        WebElement buttonQuantity = driver.findElement(By.xpath("//input[@id=\"input_46\"]"));
        buttonQuantity.sendKeys("4");

        driver.findElement(By.id("select_value_label_40")).click();
        driver.findElement(By.id("select_option_49")).click();
        driver.findElement(By.id("select_value_label_41")).click();
        driver.findElement(By.id("select_option_60")).click();
        driver.findElement(By.id("select_93")).click();
        driver.findElement(By.id("select_option_71")).click();
        driver.findElement(By.xpath("//*[contains(text(),\"Add GPUs.\")]")).click();

        WebElement gpuTypeInput = driver.findElement(By.xpath("//*[@placeholder=\"GPU type\"]//span[@class='md-select-icon']"));
        scrollToElement(gpuTypeInput);
        gpuTypeInput.click();

        driver.findElement(By.xpath("//md-option[@value=\"NVIDIA_TESLA_V100\"]")).click();
        driver.findElement(By.xpath("//*[contains(@aria-label,'Number of GPUs')]")).click();
        driver.findElement(By.xpath("//md-option[contains(@ng-disabled,\"minGPU\") and @value=\"8\"]")).click();
        WebElement ssdSelect = driver.findElement(By.id("select_95"));
        scrollToElement(ssdSelect);
        clickByJs(ssdSelect);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.attributeContains(ssdSelect,"aria-expanded", "true"));
        driver.findElement(By.xpath("//div[contains(text(),\"2x375 GB\")]")).click();

        driver.findElement(By.id("select_value_label_44")).click();
        clickByJs(driver.findElement(By.xpath("//md-option[@id=\"select_option_196\" and @value=\"europe-west3\"]/div")));
        driver.findElement(By.id("select_value_label_45")).click();

        WebElement commitedUsageSelect = driver.findElement(By.id("select_option_100"));
        scrollToElement(commitedUsageSelect);
        commitedUsageSelect.click();
        driver.findElement(By.xpath("//*[@id='select_option_100']/div[.=\"1 Year\"]")).click();

        WebElement vmClass = driver.findElement(By.xpath("//div[contains(text(),\"VM class\")]"));
        Assert.assertTrue(vmClass.getText().contains(VM_CLASS_VALUE),"VM class is not same");

        WebElement instanceType = driver.findElement(By.xpath("//div[contains(text(),\"Instance type:\")]"));
        Assert.assertTrue(instanceType.getText().contains(INSTANCE_TYPE), "Instance Type is not same");

        WebElement localSsd = driver.findElement(By.xpath("//div[contains(text(),\"Total available local SSD space 2x375 GB\")]"));
        Assert.assertTrue(localSsd.getText().contains(LOCAL_SSD), "Local SSD is not the same");

        WebElement commitmentTerm = driver.findElement(By.xpath("//div[contains(text(),\"Commitment term: 1 Year\")]"));
        Assert.assertTrue( commitmentTerm.getText().contains(COMMITMENT_TERM),"Commitment Term is not the same");

        WebElement region = driver.findElement(By.xpath("//div[contains(text(), \"Region:\")]"));
        Assert.assertTrue(region.getText().contains(REGION), "Region is not the same");
        }

        private void scrollToElement(WebElement element){
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView(true);", element);
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void clickByJs(WebElement element){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

    @AfterClass
    public void after(){
        driver.quit();
    }
}