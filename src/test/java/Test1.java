import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Test1 {

    @Test
    public void create() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://pastebin.com/");

        WebElement codeInput = driver.findElement(By.id("paste_code"));
        codeInput.sendKeys("Hello from WebDriver");
        WebElement titleInput = driver.findElement(By.name("paste_name"));
        titleInput.sendKeys("helloweb");
        WebElement timeContainer = driver.findElement(By.cssSelector("[name='paste_expire_date']~span"));
        timeContainer.click();
        WebElement timeButton = driver.findElement(By.xpath("//option[text()=\"10 Minutes\"]"));
        timeButton.click();
        driver.quit();

        }
    }

