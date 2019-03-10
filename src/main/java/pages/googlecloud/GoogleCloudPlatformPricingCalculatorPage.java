package pages.googlecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class GoogleCloudPlatformPricingCalculatorPage {

    private WebDriver driver;

    @FindBy(xpath = "//md-tabs-wrapper//md-tab-item//div[@class=\"name ng-binding\"]")
    private List<WebElement> sectionsEngine;

    @FindBy(xpath = "//input[@id=\"input_46\"]")
    private WebElement numberOfInstance;

    @FindBy(id = "select_value_label_40")
    private WebElement operationSystemContainer;

    @FindBy(xpath = "//div[@id=\"select_container_59\"]//md-content/md-option")
    private List<WebElement> operationSystemList;

    @FindBy (id = "select_value_label_41")
    private WebElement vmClassContainer;

    @FindBy(xpath = "//div[@id=\"select_container_63\"]//md-content/md-option")
    private List<WebElement> vmClassList;

    @FindBy (id="select_value_label_42")
    private WebElement instanceTypeContainer;

    @FindBy(xpath = "//div[@id=\"select_container_94\"]//md-optgroup[@label='Standard']/md-option")
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

    @FindBy(id = "select_95")
    private WebElement localSsd;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'supportedSsd')]")
    private List<WebElement> ssdList;

    @FindBy(id = "select_value_label_44")
    private WebElement location;

    @FindBy(id = "//md-option[contains(@ng-repeat,'fullRegionList')]")
    private List<WebElement> locationList;

    @FindBy(id = "select_value_label_45")
    private WebElement committedUsage;

    @FindBy(id = "select_option_100")
    private WebElement committedUsageOption;


    @FindBy(tagName = "iframe")
    private WebElement frame;

    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void switchToFrame() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(frame));
        driver.switchTo().frame(frame);
    }

    public void setEngine(String engineName) {
        for (WebElement engine : sectionsEngine) {
            if (engine.getText().equals(engineName.toUpperCase())) {
                engine.click();
                return;
            }
        }
    }

    public void setNumberOfInstance(String number){
        numberOfInstance.click();
        numberOfInstance.sendKeys(number);
    }

    public void setOperationSystem(String operationSystem) {
        operationSystemContainer.click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElement os : operationSystemList) {
            if (os.getText().equals(operationSystem)) {
                os.click();
                return;
            }
        }

    }

    public void setVmClass (String vmClass){
        vmClassContainer.click();
        try {
            Thread.sleep(3000);

        for (WebElement vmc : vmClassList) {
            if (vmc.getText().equals(vmClass)) {
                clickByJs(vmc);
                Thread.sleep(3000);
                return;
            }
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setInstanceType (String instanceType){
        clickByJs(instanceTypeContainer);
        try {
            Thread.sleep(3000);
        for (WebElement instance : instanceTypeList) {
            if (instance.getText().contains(instanceType)) {
                instance.click();
                Thread.sleep(3000);
                return;
            }
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void selectAddGPUCheckbox(){
        addGpuCheckbox.click();
    }

    public void selectGpuType(String gpyTypeValue){
      //  scrollToElement(gpyType);
        gpyType.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElement gpuType : gpuTypeList) {
            if (gpuType.getText().equals(gpyTypeValue)) {
                gpuType.click();
                return;
            }
        }
    }

    public void setNumberOfGPUs(String number){
        numberOfGpu.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElement gpuNumber : numberOfGpuList) {
            if (gpuNumber.getText().equals(number)) {
                gpuNumber.click();
                return;
            }
        }
    }

    public void setLocalSsd(String ssdValue) {
        scrollToElement(localSsd);
        localSsd.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.attributeContains(localSsd,
                "aria-expanded", "true"));
        for (WebElement ssd : ssdList){
            if (ssd.getText().equals(ssdValue)) {
                ssd.click();
                return;
            }
        }
    }

    public void setLocation(String locationValue) {
        location.click();
        for (WebElement location : locationList) {
            if (location.getText().contains(locationValue)) {
                location.click();
                return;
            }
        }
    }

    private void scrollToElement(WebElement element) {
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
    public void setCommitedUsage(String value){
        committedUsage.click();
        committedUsageOption.click();
    }
}
