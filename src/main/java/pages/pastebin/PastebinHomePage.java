package pages.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PastebinHomePage {

    @FindBy(className = "paste_textarea")
    private WebElement textInput;

    @FindBy(name = "paste_name")
    private WebElement titleInput;

    @FindBy(xpath = "//span[@title=\"Never\"]")
    private WebElement pastExpirationDropDown;

    @FindBy(xpath = "//ul[contains(@id,\"select2-paste_expire_date\")]/li")
    private List<WebElement> pastExpirationDateList;

    @FindBy(xpath = "//span[contains(@id,'select2-paste_format')]")
    private WebElement dropDownSyntax;

    @FindBy(xpath = "//ul[contains(@id,'select2-paste_format')]/li")
    private  List<WebElement> syntaxOptionList;

    @FindBy(xpath = "//input[@value=\"Create New Paste\"]")
    private WebElement createNewPostButton;

    public PastebinHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setNewPastText(String text){
        textInput.clear();
        textInput.sendKeys(text);
    }

    public void setTitle(String title){
        titleInput.sendKeys(title);
    }

    public void setTime(String time){
        pastExpirationDropDown.click();
        for(WebElement element : pastExpirationDateList){
           if(element.getText().equals(time)){
               element.click();
               return;
           }
        }
    }

    public void setSyntax(String syntax){
        dropDownSyntax.click();
        for(WebElement element : syntaxOptionList){
            if(element.getText().equals(syntax)){
                element.click();
                return;
            }
        }
    }

    public void clickNewPostButton(){
        createNewPostButton.click();
    }
}
