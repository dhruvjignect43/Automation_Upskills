package pageobjects.GtPO.deposit;

import dataobjects.GTDO.limit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

import java.util.List;
import java.util.Random;

public class DepositePO extends BasePO {
    public DepositePO(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div[class='item ng-star-inserted']")
    private WebElement depositAmount;

    @FindBy(css = "input[type='checkbox']")
    private WebElement checkBox;

    @FindBy(css = "div[class*='collapse border")
    private WebElement paymentDropDown;

    @FindBy(xpath = "//app-icon[@class='icon-generalCreditcard']//following::button[1]")
    private WebElement choosePaymentGateWay;

    @FindBy(id = "confirmation-description")
    private WebElement successMessage;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement enterLimitBox;

    @FindBy(css = "div[class*='collapse border']")
    private WebElement gatewayDropDown;

    @FindBy(id = "back-button")
    private WebElement backButton;

    @FindBy(css = "div[class*='step is-active']")
    private WebElement limitPageGetText;

    @FindBy(css = "app-form-fieldset-label[class='ng-star-inserted']")
    private WebElement depositMoneyText;



    /**
     * Enter deposit amount and choose payment_gateway.
     *
     * @throws InterruptedException Exception
     */
    public void enterDepositAmount(limit limitData) throws InterruptedException {

        selenium.clearTextBoxUsingKeys(enterLimitBox);
        selenium.enterText(enterLimitBox,limitData.getDepositLimit(),true);
        selenium.click(paymentDropDown);
//        selenium.click(gatewayDropDown);


//        List<WebElement> options = driver.findElements(By.cssSelector("div[class='item ng-star-inserted']"));
//        Random random = new Random();
//        int index = random.nextInt(options.size());
//        options.get(index).click();
        // blocker
//        selenium.click(checkBox);
//        selenium.click(paymentDropDown);

    }

    /**
     * Select the payment method
     * @throws InterruptedException Exception.
     */
    public void selectValidPaymentGatewayMethod()throws InterruptedException{
        selenium.click(choosePaymentGateWay);
    }


    /**
     *
     * @return getText of deposit money.
     */
    public String getDepositMoneyText(){
        return selenium.getText(depositMoneyText);
    }

    public void clickOnBackButtonOfPaymentGateWay() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 700);");
        selenium.waitTillElementIsVisible(backButton);
        selenium.click(backButton);

    }
    /**
     * @return getText of success message
     * @throws InterruptedException Exception
     */
    public String getLimitPageText() throws InterruptedException {
        return selenium.getText(limitPageGetText);
    }
}
