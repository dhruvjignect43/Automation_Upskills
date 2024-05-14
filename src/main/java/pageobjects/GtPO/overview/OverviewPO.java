package pageobjects.GtPO.overview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class OverviewPO extends BasePO {
    public OverviewPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.status-box-item-name span.status-box-value")
    private WebElement userNameText;

    @FindBy(css = "div.status-box-item.status-box-item-chevron span.status-box-value")
    private WebElement payableMoneyText;

    /**
     *
     * @return getText of pay money.
     */
    public String getPayableMoneyText(){
        return selenium.getText(payableMoneyText);
    }

    /**
     * @return getText of Username
     */
    public String getUserNameText(){
        return selenium.getText(userNameText);
    }
}
