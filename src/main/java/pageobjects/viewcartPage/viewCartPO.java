package pageobjects.viewcartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class viewCartPO extends BasePO {

    public viewCartPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h4//a[text()='Blue Top']")
    private WebElement viewCartText;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    private WebElement crossIcon;

    @FindBy(xpath = "//b[text()='Cart is empty!']")
    private WebElement emptyCartText;

    @FindBy(xpath = "//div//a[text()='Proceed To Checkout']")
    private WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//div//a[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//p//a[@href='/login']")
    private WebElement loginRegisterText;

    /**
     * getText of 'View Cart'.
     *
     * @return
     * @throws InterruptedException
     */
    public String getViewCartText() throws InterruptedException{
        return selenium.getText(viewCartText);
    }

    /**
     *
     * Click on 'Cross' icon button.
     * @throws InterruptedException
     */
    public void clickOnCrossIconOnProduct() throws InterruptedException{
        selenium.click(crossIcon);
    }

    /**
     *
     * getText of 'Empty Cart!!'
     * @return
     * @throws InterruptedException
     */
    public String getEmptyCartText() throws InterruptedException{
        return selenium.getText(emptyCartText);
    }

    /**
     *
     * Click on 'Proceed To Checkout' button.
     * @throws InterruptedException
     */
    public void clickOnProceedToCheckOutButton() throws InterruptedException{
        selenium.click(proceedToCheckOutButton);
    }

    /**
     *
     * Click on 'Register/Login' text link.
     * @throws InterruptedException
     */
    public void clickOnRegisterLoginTextLink() throws InterruptedException{

        selenium.doubleClickOnElement(loginRegisterText);
    }

    /**
     *
     * Click on 'Place Order' button.
     * @throws InterruptedException
     */
    public void clickOnPlaceOrderButton() throws InterruptedException{
        selenium.click(placeOrderButton);
    }
}
