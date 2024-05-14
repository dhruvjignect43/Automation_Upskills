package pageobjects.GtPO.limits;

import dataobjects.GTDO.limit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;

public class DepositLimitPO extends BasePO {
    public DepositLimitPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "select[label*='types-input']")
    private WebElement limitTypeDropDown;

    @FindBy(css = "select[label*='periods-input']")
    private WebElement periodDropDown;

    @FindBy(id = "limit")
    private WebElement limitTextBox;

    @FindBy(xpath = "//div[@class='form-component']")
    private WebElement saveButton;

    @FindBy(css = "app-alert[class*='alert-message']")
    private WebElement successMessageOfLimits;


    /**
     * Select the limit type
     */
    public void selectLimitType(){

        WebElement dropdownElement = driver.findElement(By.cssSelector("select[label*='types-input']"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Einzahlungslimit"); /*options
         Einzahlungslimit ~ Deposit limit
         Verlustlimit ~ Loss limit
         Einsatzlimit ~ Betting limit
         Automatische Auszahlung ~ Automatic withdrawal
         */
    }

    /**
     * Select limit period
     */
    public void selectPeriod(){

        WebElement dropdownElement = driver.findElement(By.cssSelector("select[label*='periods-input']"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Monatlich"); /* options
        Täglich ~ Daily
        Wöchentlich ~ Weekly
        Monatlich ~ Monthly
         */
    }

    /**
     * Add amount of limit
     * @param limitData data
     * @throws InterruptedException Exception
     */
    public void addAmount(limit limitData)throws InterruptedException{
        selenium.enterText(limitTextBox, limitData.getLimits(), true);
    }

    /**
     * Click on 'Save' button.
     * @throws InterruptedException Exception.
     */
    public void clickOnSaveButton() throws InterruptedException{
        selenium.click(saveButton);
    }

     /**
     * @return getText
     */
    public String getDepositLimit() {
        return selenium.getText(successMessageOfLimits);
    }

}