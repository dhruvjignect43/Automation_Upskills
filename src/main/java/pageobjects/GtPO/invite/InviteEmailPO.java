package pageobjects.GtPO.invite;

import dataobjects.GTDO.inviteEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.base.BasePO;

import java.time.Duration;

public class InviteEmailPO extends BasePO {
    public InviteEmailPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//div[contains(text(), 'Senden')]/parent::button")
    private WebElement sendButton;

    @FindBy(css = "app-alert[class*='alert-message']")
    private WebElement successPopUp;

    /**
     * Enter valid email.
     *
     * @param inviteEmailData data
     * @throws InterruptedException Exception
     */
    public void enterValidEmailIntoEmailTextBox(inviteEmail inviteEmailData) throws InterruptedException {
        selenium.enterText(emailTextBox, inviteEmailData.getEmail(), true);
        selenium.waitTillElementIsVisible(successPopUp);
//        selenium.click(sendButton);
    }

    /**
     * @return getText alert message.
     * @throws InterruptedException Exception
     */
    public String getSuccessAlertMessage() throws InterruptedException {
        return selenium.getText(successPopUp);
    }

    public void clickOnSendButton() throws InterruptedException {
        selenium.click(sendButton);

    }
}