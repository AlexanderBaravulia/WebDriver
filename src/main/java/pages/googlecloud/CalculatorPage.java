package pages.googlecloud;

import driver.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;


public class CalculatorPage extends BasePage {

    public final static String PAGE_URL="https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//md-tabs-wrapper//md-tab-item//div[@class='name ng-binding']")
    private List<WebElement> sectionsEngine;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstance;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operationSystemContainer;

    @FindBy(xpath = "//div[@id='select_container_60']//md-content/md-option")
    private List<WebElement> operationSystemList;

    @FindBy (xpath = "//*[@ng-model='listingCtrl.computeServer.class']")
    private WebElement vmClassContainer;

    @FindBy(xpath = "//div[@id='select_container_64']//md-content/md-option")
    private List<WebElement> vmClassList;

    @FindBy (id="select_value_label_43")
    private WebElement instanceTypeContainer;

    @FindBy(xpath = "//div[@id='select_container_95']//md-optgroup[@label='Standard']/md-option")
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

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement location;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.loadBalancer.location']//*[@ng-repeat='item in listingCtrl.fullRegionList']")
    private List<WebElement> locationList;

    private By frankfurt = By.xpath("//md-option[@id='select_option_197' and @value='europe-west3']");

    @FindBy(id = "select_value_label_46")
    private WebElement committedUsage;

    @FindBy(id = "select_option_101")
    private WebElement committedUsageOption;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][1]")
    private WebElement addToEstimateButton;

    @FindBy (xpath = "//div[contains(text(),'VM class')]")
    private WebElement vmClass;

    @FindBy (xpath ="//div[contains(text(),'Instance type:')]")
    private WebElement instanceType;

    @FindBy (xpath = "//div[contains(text(),'Total available local SSD space')]")
    private WebElement localSsdSpace;

    @FindBy (xpath = "//div[contains(text(),'Commitment term:')]")
    private WebElement commitmentTerm;

    @FindBy (xpath = "//div[contains(text(), 'Region:')]")
    private WebElement region;

    @FindBy (xpath = "//b[contains(text(),'Total Estimated Cost')]")
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
        setOptionFromListByEquals(sectionsEngine,engineName.toUpperCase());
        return this;
    }

    public CalculatorPage setNumberOfInstance(int number){
        numberOfInstance.click();
        numberOfInstance.sendKeys(String.valueOf(number));
        return this;
    }

    public CalculatorPage setOperationSystem(String operationSystem) {
        operationSystemContainer.click();
        Waiter.waitListElementVisible(driver, operationSystemList);
        setOptionFromListByContains(operationSystemList, operationSystem);
        return this;
    }

    public CalculatorPage setVmClass(String vmClass) {
        vmClassContainer.click();
        Waiter.waitListElementVisible(driver, vmClassList);
        setOptionFromListByEquals(vmClassList, vmClass);
        return this;
    }

    public CalculatorPage setInstanceType (String instanceType){
        instanceTypeContainer.click();
        Waiter.waitListElementVisible(driver,instanceTypeList);
        setOptionFromListByContains(instanceTypeList, instanceType);
        return this;
    }

    public CalculatorPage selectAddGPUCheckbox(){
        addGpuCheckbox.click();
        return this;
    }

    public CalculatorPage selectGpuType(String gpyTypeValue){
        gpyType.click();
        Waiter.waitListElementVisible(driver, gpuTypeList);
        setOptionFromListByEquals(gpuTypeList, gpyTypeValue);
        return this;
    }

    public CalculatorPage setNumberOfGPUs(int number){
        numberOfGpu.click();
        Waiter.waitListElementVisible(driver, numberOfGpuList);
        setOptionFromListByEquals(numberOfGpuList, String.valueOf(number));
        return this;
    }

    public CalculatorPage setLocalSsd(String ssdValue) {
        scrollToElement(localSsd);
        localSsd.click();
        Waiter.waitAttributeValue(driver,localSsd, "aria-expanded", "true");
        setOptionFromListByEquals(ssdList, ssdValue);
        return this;
    }

    public CalculatorPage setLocation(String locationValue) {
        scrollToElement(addToEstimateButton);
        location.click();
        Waiter.waitAttributeValue(driver,location, "aria-expanded", "true");
        driver.findElement(frankfurt).click();
        return this;
    }
    
    public CalculatorPage setCommitedUsage(){
        Waiter.waitElementVisible(driver, committedUsage);
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

    private void setOptionFromListByEquals(List<WebElement> webElementsList, String option){
        for (WebElement webElement : webElementsList){
            scrollToElement(webElement);
            if (webElement.getText().equals(option)) {
                webElement.click();
                break;
            }
        }
    }

    private void setOptionFromListByContains(List<WebElement> webElementList, String option){
        for (WebElement webElement : webElementList){
            scrollToElement(webElement);
            if (webElement.getText().contains(option)) {
                webElement.click();
                break;
            }
        }
    }
}
