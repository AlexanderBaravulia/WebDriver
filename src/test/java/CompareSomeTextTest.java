import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.pastebin.PastebinHomePage;
import pages.pastebin.PastebinPostePage;

public class CompareSomeTextTest {
    private WebDriver driver;
    private final static String TITLE = "how to gain dominance among developers";
    private final static String CODE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    @Test
    public void createNewPasteTest(){

        driver = DriverManager.getDriver();
        driver.get("https://pastebin.com/");

        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage.setNewPastText(CODE_TEXT);
        pastebinHomePage.setTitle(TITLE);
        pastebinHomePage.setTime("10 Minutes");
        pastebinHomePage.setSyntax("Bash");
        pastebinHomePage.clickNewPostButton();
        PastebinPostePage pastebinPostePage = new PastebinPostePage(driver);

        Assert.assertTrue(driver.getTitle().contains(TITLE),"Title is not as expected");
        Assert.assertEquals( CODE_TEXT, pastebinPostePage.getTextFromTextArea(),"Code is not correct");
        Assert.assertTrue( pastebinPostePage.isBashStylePresent(), "Bash code style is not present");
    }

    @AfterClass
    public void after(){
        driver.quit();
    }
}


