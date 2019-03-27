package pages.tenminutesmail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class MailPage extends BasePage {

    private final static String PAGE_URL = "https://dropmail.me/ru/";

    @FindBy(className = "email")
    WebElement mailAdress;

    @FindBy (className = "mail-subject")
    List<WebElement> mailSubjects;

    @FindBy(xpath = "//pre[contains(@data-bind, 'html')]")
    WebElement messageBody;

    public MailPage(WebDriver driver){
        super(driver);
    }

    public MailPage open() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getMailAddress(){
       return mailAdress.getText();
    }

    public boolean isMailPresent(String mailSubject) {
        for (int i = 0; i < 10; i++) {
            if (!isMailSubjectPresent()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return  this.mailSubjects.get(0).getText().contains(mailSubject);
            }
        }
        return false;
    }

    public boolean isMailSubjectPresent(){
        return !mailSubjects.isEmpty();
    }

    public String getMessageBody(){
        return messageBody.getText();
    }

}