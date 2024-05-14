package pageobjects.GtPO.player;

import dataobjects.GTDO.phone;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class PlayerAccountPO extends BasePO {
    public PlayerAccountPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberText;

    @FindBy(xpath = "//div[contains(text(),'Bestätigungslink senden')]/parent::button")
    private WebElement saveLinkButton;

    @FindBy(css = "app-alert[class*='alert-message']")
    private WebElement getValidationText;

    /**
     * Contact Number.
     *
     * @param phoneData data
     */
    public void enterPhoneNumber(phone phoneData) {
        selenium.enterText(phoneNumberText, phoneData.getPhoneNum(), true);
        selenium.waitTillElementIsVisible(saveLinkButton);
    }

    /**
     * @return getTextPhoneNumber
     */
    public String getPhoneNumber() {
        return selenium.getText(phoneNumberText);
    }

    /**
     * Click on save button.
     *
     * @throws InterruptedException Exception
     */
    public void clickOnSaveButton() throws InterruptedException {
        selenium.click(saveLinkButton);
    }
}

