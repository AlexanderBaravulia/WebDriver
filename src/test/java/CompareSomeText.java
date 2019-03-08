import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareSomeText {
    private WebDriver driver;
    private final static String TITLE = "how to gain dominance among developers";
    private final static String CODE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    @Test
    public void createNewPasteTest(){

        driver = DriverManager.getWebDriver();
        driver.get("https://pastebin.com/");
        WebElement codeInput = driver.findElement(By.className("paste_textarea"));
        codeInput.sendKeys(CODE_TEXT);
        WebElement titleInput = driver.findElement(By.name("paste_name"));
        titleInput.sendKeys(TITLE);
        WebElement dropDownTime = driver.findElement(By.xpath("//span[@title=\"Never\"]"));
        dropDownTime.click();
        WebElement timeButton = driver.findElement(By.xpath("//option[text()=\"10 Minutes\"]"));
        timeButton.click();
        WebElement dropDownSyntaxis = driver.findElement(By.xpath("//span[@title=\"None\"]"));
        dropDownSyntaxis.click();
        WebElement dropDownSyntaxisButtonBash = driver.findElement(By.xpath("//li[text()=\"Bash\"]"));
        dropDownSyntaxisButtonBash.click();
        WebElement buttonCreateNewPoste = driver.findElement(By.xpath("//input[@value=\"Create New Paste\"]"));
        buttonCreateNewPoste.click();

        Assert.assertTrue("Title is not as expected", driver.getTitle().contains(TITLE));

        boolean isBashStylePresent;
        try {
            WebElement bashStyle = driver.findElement(By.xpath("//a[@class=\"buttonsm\" and text()=\"Bash\"]"));
            isBashStylePresent = bashStyle.isDisplayed();
        } catch (NoSuchElementException ex){
            isBashStylePresent = false;
        }
        Assert.assertTrue("Bash code style is not present", isBashStylePresent);

        WebElement bashText = driver.findElement(By.id("selectable"));
        Assert.assertEquals("Code is not correct", CODE_TEXT, bashText.getText());


    }
}
