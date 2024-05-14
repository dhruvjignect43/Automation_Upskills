package pageobjects.productPage;

import dataobjects.product;
import dataobjects.userCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class ProductPO extends BasePO {
    public ProductPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement submitSearch;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameTextBox;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//textarea[@id='review']")
    private WebElement reviewBox;

    @FindBy(xpath = "//button[@id='button-review']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='features_items']//div[contains(@class,'productinfo') ]/p[text()='Blue Top']")
    private WebElement productText;

    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement enterQty;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//p//u[text()='View Cart']")
    private WebElement viewCartText;

    /**
     *
     * Search 'Invalid Data' into the Search bar.
     * @param productdata
     * @throws InterruptedException
     */
    public void clickOnSearchBarAndEnterInvalidValueAndClickOnSubmitSearchButton(product productdata) throws InterruptedException{
        selenium.enterText(searchBar,productdata.getSearchText(),true);
        selenium.click(submitSearch);
    }

    /**
     * Enter 'Invalid Data' into 'Name', 'Email' and 'ReviewTextBox'.
     *
     * @param signupdata
     * @throws InterruptedException
     */
    public void enterInvalidValueInNameEmailAndReviewTextBoxAndClickOnSubmitButton(userCredentials signupdata ) throws InterruptedException{
        selenium.enterText(nameTextBox,signupdata.getInvalidName(),true);
        selenium.enterText(emailTextBox,signupdata.getInvalidEmail(),true);
        selenium.enterText(reviewBox,signupdata.getInvalidReview(),true);
        selenium.click(submitButton);
    }

    /**
     * Search 'Valid Data' into the Search bar.
     *
     * @param productdata
     * @throws InterruptedException
     */
    public void clickOnSearchBarAndEnterValidValueAndClickOnSubmitSearchButton(product productdata) throws InterruptedException{
        selenium.enterText(searchBar,productdata.getSearchValidText(),true);
        selenium.click(submitSearch);
    }

    /**
     * getText of 'Product'.
     *
     * @return
     * @throws InterruptedException
     */
    public String getProductText() throws InterruptedException{
        return selenium.getText(productText);
    }

    /**
     * Change the 'QTY' of product.
     *
     * @param productdata
     * @throws InterruptedException
     */
    public void changeTheProductQty(product productdata) throws InterruptedException{
        selenium.clearTextBoxUsingKeys(enterQty);
        selenium.enterText(enterQty, productdata.getProductQty(),true);
        selenium.doubleClickOnElement(addToCartButton);
        selenium.click(viewCartText);
    }
}
