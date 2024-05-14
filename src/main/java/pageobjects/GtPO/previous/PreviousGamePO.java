package pageobjects.GtPO.previous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;

public class PreviousGamePO extends BasePO {
    public PreviousGamePO(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "shortcutDate")
    private WebElement previousGameDropDown;

    @FindBy(xpath = "//div[@class='content']/div")
    private WebElement validationMessage;

    /**
     * Previous game dropdown.
     *
     * @throws InterruptedException Exception
     */
    public void clickAndSelectPreviousGameDropDown() throws InterruptedException {
        WebElement depositType = driver.findElement(By.id("shortcutDate"));
        Select limitDropdown = new Select(depositType);
        limitDropdown.selectByVisibleText("Heute");
        selenium.click(previousGameDropDown);
    }

    /**
     * Validation Text.
     *
     * @return getText
     * @throws InterruptedException Exception
     */
    public String getValidationMessageText() throws InterruptedException {
        return selenium.getText(validationMessage);
    }
}
