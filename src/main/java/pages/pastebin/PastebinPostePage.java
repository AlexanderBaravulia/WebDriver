package pages.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPostePage {

    @FindBy (id = "selectable")
    private WebElement textArea;

    @FindBy (xpath = "//a[@class=\"buttonsm\" and text()=\"Bash\"]")
    private WebElement bashStyle;

    public PastebinPostePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getTextFromTextArea(){
        return textArea.getText();

    }

    public boolean isBashStylePresent(){
        boolean isBashStylePresent;
        try {
            isBashStylePresent = bashStyle.isDisplayed();
        } catch (NoSuchElementException ex){
            isBashStylePresent = false;
        }
        return isBashStylePresent;
    }
}
