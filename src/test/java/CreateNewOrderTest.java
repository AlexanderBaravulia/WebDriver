import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googlecloud.GoogleCloudHomePage;
import pages.googlecloud.CalculatorPage;
import pages.googlecloud.PricingPage;
import pages.googlecloud.ProductsPage;
import service.OrderCreator;


public class CreateNewOrderTest extends MainConditions{

    private final static String TOTAL_ESTIMATE = "1,288.75";

    @Test
    public void createTestTree() {

        Order order = OrderCreator.getPredefinedOrder();

        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage (driver);

        ProductsPage productsPage = googleCloudHomePage.open().clickExploreNewProductsButton();
        PricingPage pricingPage = productsPage.clickSeePricingButton();
        CalculatorPage calculatorPage = pricingPage.clickCaltulatorsButton();
        calculatorPage.switchToFrame();
        calculatorPage.setEngine("Compute Engine");
        calculatorPage.setNumberOfInstance("4");
        calculatorPage.setOperationSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        calculatorPage.setVmClass(order.getVmClass());
        calculatorPage.setInstanceType(order.getInstanceType());
        calculatorPage.selectAddGPUCheckbox();
        calculatorPage.selectGpuType("NVIDIA Tesla P100");
        calculatorPage.setNumberOfGPUs("4");
        calculatorPage.setLocalSsd(order.getLocalSsd());
        calculatorPage.setLocation(order.getRegion());
        calculatorPage.setCommitedUsage(order.getCommitmentTerm());
        calculatorPage.clickAddToEstimate();

        Assert.assertTrue(calculatorPage.getVMClassText().contains(order.getVmClass()),"VM class is not same");
        Assert.assertTrue(calculatorPage.getInstanceTypeText().contains(order.getInstanceType()),"Instance Type is not same");
        Assert.assertTrue(calculatorPage.getSsdSpace().contains(order.getLocalSsd()), "Local SSD is not the same");
        Assert.assertTrue(calculatorPage.getCommitmentTerm().contains(order.getCommitmentTerm()),"Commitment Term is not the same");
        Assert.assertTrue(calculatorPage.getRegion().contains(order.getRegion()),"Region is not the same");
        Assert.assertTrue(calculatorPage.getTotalCost().contains(TOTAL_ESTIMATE),"Total estimate is not the same");


        }
    }