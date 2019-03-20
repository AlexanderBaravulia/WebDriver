import driver.DriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
        import org.junit.Test;
        import org.openqa.selenium.WebDriver;
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

        Assert.assertTrue("Title is not as expected", driver.getTitle().contains(TITLE));
        Assert.assertEquals("Code is not correct", CODE_TEXT, pastebinPostePage.getTextFromTextArea());
        Assert.assertTrue("Bash code style is not present", pastebinPostePage.isBashStylePresent());
    }

    @AfterClass
    public void after(){
        driver.quit();
    }
}


