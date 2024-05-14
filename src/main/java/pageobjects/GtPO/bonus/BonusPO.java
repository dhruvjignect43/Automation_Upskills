package pageobjects.GtPO.bonus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class BonusPO extends BasePO {
    public BonusPO(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div[class*='paragraph']")
    private WebElement bonusPageText;

    /**
     * @return getText of bonus text
     */
    public String getBonusPageText(){
        return selenium.getText(bonusPageText);
    }
}
