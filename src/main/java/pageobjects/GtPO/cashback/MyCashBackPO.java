package pageobjects.GtPO.cashback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class MyCashBackPO extends BasePO {
    public MyCashBackPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class*='inner-layout']")
    private WebElement myCashBackText;

    /**
     *
     * @return getText of Cashback.
     */
    public String getMyCashBackText(){
        return selenium.getText(myCashBackText);
    }
}
