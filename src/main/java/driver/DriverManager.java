package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utill.PropertyReader;

import java.util.concurrent.TimeUnit;


public class DriverManager {
    private static final String RESOURCES_PATH = "src\\main\\resources\\";
    private static final int TIMEOUT = 7;
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser");
            switch (browser) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}


