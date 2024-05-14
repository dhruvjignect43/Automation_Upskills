package pageobjects.payment;

import dataobjects.creditCardDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class paymentPO extends BasePO {
    public paymentPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement nameOnCardTextBox;

    @FindBy(xpath = "//input[@name='card_number']")
    private WebElement cardNumberTextBox;

    @FindBy(xpath = "//input[@name='cvc']")
    private WebElement cvcTextBox;

    @FindBy(xpath = "//input[@name='expiry_month']")
    private WebElement expirationMonth;

    @FindBy(xpath = "//input[@name='expiry_year']")
    private WebElement expirationYear;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h2//b[text()='Order Placed!']")
    private WebElement orderSuccess;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    private WebElement downloadInvoice;


    /**
     * Enter valid 'Credit Card' details.
     *
     * @param creditCardData
     * @throws InterruptedException
     */
    public void enterValidCardDetailsAndClickOnSubmitButton(creditCardDetails creditCardData) throws InterruptedException{
        selenium.enterText(nameOnCardTextBox,creditCardData.getNameOnCard(),true);
        selenium.enterText(cardNumberTextBox,creditCardData.getCardNumber(),true);
        selenium.enterText(cvcTextBox,creditCardData.getCvc(),true);
        selenium.enterText(expirationMonth,creditCardData.getExpiration(),true);
        selenium.enterText(expirationYear,creditCardData.getExpiration(),true);
        selenium.click(submitButton);
    }

    /**
     * getText of 'Order Successfull'
     *
     * @return
     * @throws InterruptedException
     */
    public String getOrderSuccessfullText() throws InterruptedException{
        return selenium.getText(orderSuccess);
    }

    /**
     *
     * Download 'Invoice'
     * @throws InterruptedException
     */
    public void clickOnDownloadInvoiceButton()throws InterruptedException{
        selenium.click(downloadInvoice);
    }
}
