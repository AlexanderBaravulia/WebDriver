package googlecloud;

import conditions.MainConditions;
import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googlecloud.GoogleCloudHomePage;
import pages.googlecloud.CalculatorPage;
import pages.googlecloud.PricingPage;
import pages.googlecloud.ProductsPage;
import service.OrderCreator;


public class GoogleCalculatorTest extends MainConditions {

    private final static String TOTAL_ESTIMATE = " 1,187.77";

    @Test
    public void createTestTree() {
        Order order = OrderCreator.getPredefinedOrder();

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
                .setCommitedUsage(order.getCommitmentTerm())
                .clickAddToEstimate();

        Assert.assertTrue(calculatorPage.getVMClassText().contains(order.getVmClass().toLowerCase()),"VM class is not same");
        Assert.assertTrue(calculatorPage.getInstanceTypeText().contains(order.getInstanceType()),"Instance Type is not same");
        Assert.assertTrue(calculatorPage.getSsdSpace().contains(order.getLocalSsd()), "Local SSD is not the same");
        Assert.assertTrue(calculatorPage.getCommitmentTerm().contains(order.getCommitmentTerm()),"Commitment Term is not the same");
        Assert.assertTrue(calculatorPage.getRegion().contains(order.getRegion()),"Region is not the same");
        Assert.assertTrue(calculatorPage.getTotalCost().contains(TOTAL_ESTIMATE),"Total estimate is not the same");


        }
    }