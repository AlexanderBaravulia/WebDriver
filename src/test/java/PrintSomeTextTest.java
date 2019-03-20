import driver.DriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.pastebin.PastebinHomePage;

public class PrintSomeTextTest {
    private WebDriver driver;

    @Test
    public void create() {
        driver = DriverManager.getDriver();
        driver.get("https://pastebin.com/");

        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.setNewPastText("Hello from WevDriver");
        pastebinHomePage.setTitle("helloweb");
        pastebinHomePage.setTime("10 Minutes");
        driver.quit();

        }
    }

