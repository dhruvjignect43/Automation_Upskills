package pageobjects.GtPO.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class GatewayPO extends BasePO {

    public GatewayPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nrgs-neteller-submit")
    private WebElement sendButton;

    @FindBy(id = "ui-deposit-amount-text")
    private WebElement depositAmountText;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    /**
     * Click on send button
     * @throws InterruptedException Exception
     */
    public void clickOnSendButton() throws InterruptedException {
        selenium.click(sendButton);
    }

    public String getDepositAmount() throws InterruptedException {
        return selenium.getText(depositAmountText);
    }

    /**
     * Click on submit button
     *
     * @throws InterruptedException Exception
     */
    public void clickOnSubmitButton() throws InterruptedException {
        selenium.click(submitButton);
    }
}
