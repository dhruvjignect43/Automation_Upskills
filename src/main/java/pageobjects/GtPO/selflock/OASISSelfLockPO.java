package pageobjects.GtPO.selflock;

import dataobjects.GTDO.loginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;

import java.util.List;
import java.util.Random;

public class OASISSelfLockPO extends BasePO {
    public OASISSelfLockPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class*='headline-beta is-first']")
    private WebElement OASISText;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(css = "span[class='inner']")
    private WebElement saveButton;

    @FindBy(css = "button[class*='mode-modal mode-block']")
    private WebElement confirmSelfExecutionButton;

    @FindBy(css = "app-alert[class*='alert-message']")
    private WebElement alertMessageText;


    /**
     *
     * @return getText of OasisSelfLock page.
     */
    public String getTextOfTheOASISSelfLock(){
        return selenium.getText(OASISText);
    }

    /**
     * Select random dropdown and enter invalid password.
     * @param loginUserData Data
     * @throws InterruptedException Exception
     */
    public void selectTheValidDropDownAndEnterTheInvalidPassword(loginUser loginUserData) throws InterruptedException{
        WebElement limitType = driver.findElement(By.id("exclusion"));
        Select limitDropdown = new Select(limitType);
        List<WebElement> limitOptions = limitDropdown.getOptions();
        Random randomLimit = new Random();
        int randomLimitIndex = randomLimit.nextInt(limitOptions.size());
        limitDropdown.selectByIndex(randomLimitIndex);
        selenium.enterText(passwordTextBox,loginUserData.getLoginPassword(),true);
        selenium.waitTillElementIsVisible(saveButton);
        selenium.clickOn(saveButton);
        selenium.waitTillElementIsVisible(confirmSelfExecutionButton);
        selenium.click(confirmSelfExecutionButton);
    }

    /**
     * @return getText of invalid password error message
     */
    public String getErrorMessageText(){
        return selenium.getText(alertMessageText);
    }
 }
