package pages.googlecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.List;


public class CalculatorPage extends BasePage {

    public final static String PAGE_URL="https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//md-tabs-wrapper//md-tab-item//div[@class=\"name ng-binding\"]")
    private List<WebElement> sectionsEngine;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstance;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operationSystemContainer;

    @FindBy(xpath = "//div[@id=\"select_container_60\"]//md-content/md-option")
    private List<WebElement> operationSystemList;

    @FindBy (xpath = "//*[@ng-model='listingCtrl.computeServer.class']")
    private WebElement vmClassContainer;

    @FindBy(xpath = "//div[@id=\"select_container_64\"]//md-content/md-option")
    private List<WebElement> vmClassList;

    @FindBy (id="select_value_label_43")
    private WebElement instanceTypeContainer;

    @FindBy(xpath = "//div[@id=\"select_container_95\"]//md-optgroup[@label='Standard']/md-option")
    private List<WebElement> instanceTypeList;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'addGPUs')]/div[@md-ink-ripple-checkbox]")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpyType;

    @FindBy(xpath = "//md-option[contains(@ng-disabled,'checkGpuAvailability')]")
    private List<WebElement> gpuTypeList;

    @FindBy(xpath = "//*[contains(@aria-label,'Number of GPUs')]")
    private WebElement numberOfGpu;

    @FindBy(xpath = "//md-option[contains(@ng-disabled,'minGPU')]")
    private List<WebElement> numberOfGpuList;

    @FindBy(id = "select_96")
    private WebElement localSsd;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'supportedSsd')]")
    private List<WebElement> ssdList;

    @FindBy(xpath = "//md-select[@ng-model=\"listingCtrl.computeServer.location\"]")
    private WebElement location;

    @FindBy(xpath = "//*[@ng-model=\"listingCtrl.loadBalancer.location\"]//*[@ng-repeat=\"item in listingCtrl.fullRegionList\"]")
    private List<WebElement> locationList;

    private By frankfurt = By.xpath("//md-option[@id='select_option_197' and @value='europe-west3']");

    @FindBy(id = "select_value_label_46")
    private WebElement committedUsage;

    @FindBy(id = "select_option_101")
    private WebElement committedUsageOption;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][1]")
    private WebElement addToEstimateButton;

    @FindBy (xpath = "//div[contains(text(),\"VM class\")]")
    private WebElement vmClass;

    @FindBy (xpath ="//div[contains(text(),\"Instance type:\")]")
    private WebElement instanceType;

    @FindBy (xpath = "//div[contains(text(),\"Total available local SSD space\")]")
    private WebElement localSsdSpace;

    @FindBy (xpath = "//div[contains(text(),\"Commitment term:\")]")
    private WebElement commitmentTerm;

    @FindBy (xpath = "//div[contains(text(), 'Region:')]")
    private WebElement region;

    @FindBy (xpath = "//b[contains(text(),\"Total Estimated Cost\")]")
    private WebElement totalCost;

    @FindBy (id = "email_quote")
    private WebElement emailQuoteButton;


    @Override
    public CalculatorPage open() {
        driver.navigate().to(PAGE_URL);
        logger.info("Calculator page is opened.");
        return this;
    }

    public CalculatorPage(WebDriver driver) {
        super(driver);
        }

    public CalculatorPage switchToFrame() {
        driver.switchTo().frame("idIframe");
        return this;
    }

    public CalculatorPage setEngine(String engineName) {
        for (WebElement engine : sectionsEngine) {
            if (engine.getText().equals(engineName.toUpperCase())) {
                engine.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage setNumberOfInstance(String number){
        numberOfInstance.click();
        numberOfInstance.sendKeys(number);
        return this;
    }

    public CalculatorPage setOperationSystem(String operationSystem) {
        operationSystemContainer.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(operationSystemList.get(0)));
        for (WebElement os : operationSystemList) {
            if (os.getText().contains(operationSystem)) {
                os.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage setVmClass (String vmClass) {
        vmClassContainer.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(vmClassList));
        for (WebElement vmc : vmClassList) {
            if (vmc.getText().equals(vmClass)) {
                            vmc.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage setInstanceType (String instanceType){
        instanceTypeContainer.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(instanceTypeList.get(0)));
        for (WebElement instance : instanceTypeList) {
            if (instance.getText().contains(instanceType)) {
                instance.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage selectAddGPUCheckbox(){
        addGpuCheckbox.click();
        return this;
    }

    public CalculatorPage selectGpuType(String gpyTypeValue){
        gpyType.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(gpuTypeList.get(0)));
         for (WebElement gpuType : gpuTypeList) {
            if (gpuType.getText().equals(gpyTypeValue)) {
                gpuType.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage setNumberOfGPUs(String number){
        numberOfGpu.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(numberOfGpuList.get(0)));
        for (WebElement gpuNumber : numberOfGpuList) {
            if (gpuNumber.getText().equals(number)) {
                gpuNumber.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage setLocalSsd(String ssdValue) {
        scrollToElement(localSsd);
        localSsd.click();
        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.attributeContains(localSsd, "aria-expanded", "true"));
        for (WebElement ssd : ssdList){
            scrollToElement(ssd);
            if (ssd.getText().equals(ssdValue)) {
                ssd.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage setLocation(String locationValue) {
        scrollToElement(addToEstimateButton);
        location.click();
        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.attributeContains(location, "aria-expanded", "true"));
        driver.findElement(frankfurt).click();
//        for (WebElement location : locationList) {
//            if (location.getText().contains(locationValue)) {
//                JavascriptExecutor executor = (JavascriptExecutor)driver;
//                executor.executeScript("arguments[0].click();", location);
//                break;
//            }
//        }
        return this;
    }
    
    public CalculatorPage setCommitedUsage(String value){
        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.visibilityOf(committedUsage));
        committedUsage.click();
        committedUsageOption.click();
        return this;
    }

    public CalculatorPage clickAddToEstimate(){
        scrollToElement(addToEstimateButton);
        addToEstimateButton.click();
        return this;
    }

    public EmailForm clickEmailQuote(){
        emailQuoteButton.click();
        return new EmailForm(driver);

    }

    public String getVMClassText(){
        return vmClass.getText();

    }




    public String getInstanceTypeText(){
        return instanceType.getText();
    }

    public String getSsdSpace(){
        return localSsdSpace.getText();
    }

    public String getCommitmentTerm(){
        return commitmentTerm.getText();
    }

    public String getRegion(){
        return region.getText();
    }

    public String getTotalCost(){
        return totalCost.getText();
    }
}
