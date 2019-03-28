package pages.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class EmailForm extends BasePage {

    @FindBy (xpath = "//input[@type='email']")
    WebElement emailField;

    @FindBy (xpath = "//button[@aria-label='Send Email']")
    WebElement sendEmailButton;

    public EmailForm(WebDriver driver){
        super(driver);
    }

    @Override
    public BasePage open() {
        logger.warn("Couldn't open mail form.");
        return this;
    }

    public EmailForm addEmail(String email){
        scrollToElement(emailField);
        try {
            Thread.sleep(2000);
            emailField.click();
            emailField.sendKeys(email);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CalculatorPage clickSendEmailAdress(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        scrollToElement(sendEmailButton);
        sendEmailButton.click();
        return new CalculatorPage(driver);
    }
}
