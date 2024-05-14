package pageobjects.accountinfo; //move to loginSignUp folder

import dataobjects.registerUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;
import java.util.List;
import java.util.Random;

public class AccountInfoPO extends BasePO {
    public AccountInfoPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='radio']//input[@value='Mr']")
    private WebElement selectRadioButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement enterPassword;

  /*  @FindBy(id = "password") xpath,css to id convert
    private WebElement abcTextBox;*/

    @FindBy(xpath = "//div//select[@id='days']")
    private WebElement selectDayDropdown1;

    @FindBy(xpath = "//div//select[@id='months']")
    private WebElement selectMonthsDropdown;

    @FindBy(xpath = "//div//select[@id='years']")
    private WebElement selectYearsDropdown;

    @FindBy(css = "#newsletter")
    private WebElement checkBox1; //related content

    @FindBy(css = "#optin")
    private WebElement checkBox2;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement enterFirstName;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement enterLastName;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement enterCompanyName;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement enterAddressName1;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement enterAddressName2;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement enterState;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement enterCity;

    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement enterZipCode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement enterMobileNumber;

    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement clickOnCreateAccountButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement accountCreatedText;


    /**
     * Enter valid account information and create account button.
     *
     * @param registerUserData data
     * @throws InterruptedException
     */
    public void enterValidAccountDetailsAndClickOnCreateAccountButton(registerUser registerUserData) throws InterruptedException{

        List<WebElement> options = driver.findElements(By.xpath("//div[@class='radio-inline']")); //second way
        Random random = new Random();
        int index = random.nextInt(options.size()); //Java helper
        options.get(index).click();
        selenium.enterText(enterPassword, registerUserData.getPassword(),true);
        WebElement dayDropdown = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDayDropdown = new Select(selectDayDropdown1);
        selectDayDropdown.selectByVisibleText("5"); //DF
        WebElement monthDropdown =  driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonthDropdown = new Select(monthDropdown);
        selectMonthDropdown.selectByVisibleText("March");
        WebElement yearDropdown =  driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYearDropdown = new Select(yearDropdown);
        selectYearDropdown.selectByVisibleText("2001");
        selenium.click(checkBox1);
        selenium.click(checkBox2);
        selenium.enterText(enterFirstName, registerUserData.getFirstName(),true);
        selenium.enterText(enterLastName, registerUserData.getLastName(),true);
        selenium.enterText(enterCompanyName, registerUserData.getCompany(),true);
        selenium.enterText(enterAddressName1, registerUserData.getAddress1(),true);
        selenium.enterText(enterAddressName2, registerUserData.getAddress2(),true);
        selenium.enterText(enterState, registerUserData.getState(),true);
        selenium.enterText(enterCity, registerUserData.getCity(),true);
        selenium.enterText(enterZipCode, registerUserData.getZipCode(),true);
        selenium.enterText(enterMobileNumber, registerUserData.getMobileNumber(),true);
        selenium.click(clickOnCreateAccountButton);
    }
    public String getAccountCreatedText(){
        return selenium.getText(accountCreatedText);
    }
}
