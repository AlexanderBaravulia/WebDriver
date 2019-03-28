package googlecloud;

import conditions.MainConditions;
import model.Order;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.googlecloud.GoogleCloudHomePage;
import pages.googlecloud.CalculatorPage;
import pages.googlecloud.PricingPage;
import pages.googlecloud.ProductsPage;
import pages.tenminutesmail.MailPage;
import service.OrderCreator;


public class GoogleCalculatorTest extends MainConditions {

    private final static String TOTAL_ESTIMATE = "1,187.77";
    private final static String EMAIL_SUBJECT = "Google Cloud Platform Price Estimate";
    private Order order;

    @BeforeClass
    public void before(){
        order = OrderCreator.getPredefinedOrder();
    }

    @Test
    public void checkCalculatorPageAvailableTest(){
        new CalculatorPage(driver).open();
        Assert.assertEquals(driver.getCurrentUrl(), CalculatorPage.PAGE_URL);
    }

    @Test
    public void checkCalculationTest() {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        ProductsPage productsPage = googleCloudHomePage.open().clickExploreNewProductsButton();
        PricingPage pricingPage = productsPage.clickSeePricingButton();
        CalculatorPage calculatorPage = pricingPage.clickCaltulatorsButton();
        calculatorPage.switchToFrame()
                .setEngine(order.getEngineType())
                .setNumberOfInstance(order.getInstanceNumber())
                .setOperationSystem(order.getOperationSystem())
                .setVmClass(order.getVmClass())
                .setInstanceType(order.getInstanceType())
                .selectAddGPUCheckbox()
                .selectGpuType(order.getGpuType())
                .setNumberOfGPUs(order.getNumberOfGPU())
                .setLocalSsd(order.getLocalSsd())
                .setLocation(order.getRegion())
                .setCommitedUsage()
                .clickAddToEstimate();

        softAssert.assertTrue(calculatorPage.getVMClassText().contains(order.getVmClass().toLowerCase()),"VM class is not same");
        softAssert.assertTrue(calculatorPage.getInstanceTypeText().contains(order.getInstanceType()),"Instance Type is not same");
        softAssert.assertTrue(calculatorPage.getSsdSpace().contains(order.getLocalSsd()), "Local SSD is not the same");
        softAssert.assertTrue(calculatorPage.getCommitmentTerm().contains(order.getCommitmentTerm()),"Commitment Term is not the same");
        softAssert.assertTrue(calculatorPage.getRegion().contains(order.getRegion()),"Region is not the same");
        softAssert.assertTrue(calculatorPage.getTotalCost().contains(TOTAL_ESTIMATE),"Total estimate is not the same");
    }

    @Test
    public void getEmailTest() {
        MailPage mailPage = new MailPage(driver);
        mailPage.open();
        User user = new User(mailPage.getMailAddress());
        mailPage.openNewTab();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.open()
                .switchToFrame()
                .setEngine(order.getEngineType())
                .setNumberOfInstance(order.getInstanceNumber())
                .setOperationSystem(order.getOperationSystem())
                .setVmClass(order.getVmClass())
                .setInstanceType(order.getInstanceType())
                .selectAddGPUCheckbox()
                .selectGpuType(order.getGpuType())
                .setNumberOfGPUs(order.getNumberOfGPU())
                .setLocalSsd(order.getLocalSsd())
                .setLocation(order.getRegion())
                .setCommitedUsage()
                .clickAddToEstimate()
                .clickEmailQuote()
                .addEmail(user.getEmailAdress())
                .clickSendEmailAdress()
                .goToFirstTab();

        Assert.assertTrue(mailPage.isMailPresent(EMAIL_SUBJECT), "The letter was not received");
        Assert.assertTrue(mailPage.getMessageBody().contains(TOTAL_ESTIMATE), "The total estimate is not correct");
    }
}