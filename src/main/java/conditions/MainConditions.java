package conditions;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utill.TestListener;


@Listeners({TestListener.class})
public class MainConditions {

    protected WebDriver driver;

    @BeforeMethod()
    public void getUpBrowser(){
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        DriverManager.closeDriver();
    }
}
