package pageobjects.GtPO.register;

import dataobjects.GTDO.register;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;

import java.util.List;
import java.util.Random;

public class RegisterPO extends BasePO {
    public RegisterPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    private WebElement lastNameTextBox;

    @FindBy(id = "dateOfBirthday")
    private WebElement dobTextBox;

    @FindBy(id = "isMaidenName")
    private WebElement radioButton;

    @FindBy(id = "maidenName")
    private WebElement birthName;

    @FindBy(id = "birthCity")
    private WebElement birthCityTextBox;

    @FindBy(id = "nationality")
    private WebElement nationalityDropDown;

    @FindBy(id = "phonePrefix")
    private WebElement phoneDropDown;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberTextBox;

    @FindBy(xpath = "//button[@type='button']/div[contains(text(),'Weiter')]")
    private WebElement submitButton;

    @FindBy(id = "autoCompleteAddress")
    private WebElement addressTextBox;

    @FindBy(xpath = "//a[text()='Manuell eintragen']")
    private WebElement enterManuallyText;

    @FindBy(css = "button[label*='next']")
    private WebElement furtherButton;

    @FindBy(id = "street")
    private WebElement streetTextBox;

    @FindBy(id = "houseNumber")
    private WebElement houseNumTextBox;

    @FindBy(id = "zip")
    private WebElement zipCodeTextBox;

    @FindBy(id = "city")
    private WebElement cityTextBox;

    @FindBy(id = "regionCode")
    private WebElement stateCodeTextBox;

    @FindBy(id = "countryCode")
    private WebElement countryCode;

    @FindBy(id = "nickname")
    private WebElement nickNameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "securityQuestionTag")
    private WebElement securityQuestionDropDown;

    @FindBy(id = "securityAnswer")
    private WebElement securityAnswerTextBox;

    @FindBy(id = "lugasMonthlyDepositLimit")
    private WebElement checkBoxOfApprovalSection;

    @FindBy(id = "monthlyDepositLimit")
    private WebElement monthlyLimitTextBox;

    @FindBy(css = "span[label*='receiveNewsletter-label']")
    private WebElement optionalLimitTextBox1;

    @FindBy(css = "span[label*='smsConsent-label']")
    private WebElement optionalLimitTextBox2;

    @FindBy(css = "span[label*='isBeneficiaryOwnerOfAccount-label']")
    private WebElement optionalLimitTextBox3;

    @FindBy(xpath = "//span[text()='Ich akzeptiere die ']")
    private WebElement optionalLimitTextBox4;

    @FindBy(id = "marketingProfilingAccept")
    private WebElement approvalDropDown;

    @FindBy(xpath = "//div[text()='Registrieren']/parent::button")
    private WebElement submitRegistrationButton;

    @FindBy(xpath = "//a[@role='button']/div[contains(text(),'Identitätverifizierung beginnen')]")
    private WebElement verificationButton;

    @FindBy(css = "div[class*='dialog-header']")
    private WebElement verificationText;


    /**
     * Enter valid user credentials and register user.
     *
     * @param registerUserData Register Data
     * @throws InterruptedException Exception
     */
    public void enterRegistrationDetails(register registerUserData) throws InterruptedException {
        selenium.enterText(firstNameTextBox, registerUserData.getFirstName(), true);
        selenium.enterText(lastNameTextBox, registerUserData.getLastName(), true);
        selenium.enterText(dobTextBox, registerUserData.getDob(), true);
        List<WebElement> options = driver.findElements(By.id("isMaidenName"));
        Random random = new Random();
        int index = random.nextInt(options.size());
        options.get(index).click();
        selenium.enterText(birthName, registerUserData.getBirthName(), true);
        selenium.enterText(birthCityTextBox, registerUserData.getPlaceOfBirth(), true);
        WebElement nationality = driver.findElement(By.id("nationality"));
        Select nationalityDropdown = new Select(nationality);
        nationalityDropdown.selectByVisibleText("Deutschland");
        WebElement countryCode = driver.findElement(By.id("phonePrefix"));
        Select countryCodeDropdown = new Select(countryCode);
        countryCodeDropdown.selectByVisibleText("+49");
        selenium.enterText(phoneNumberTextBox, registerUserData.getTelephoneNum(), true);
        selenium.click(furtherButton);
        selenium.click(enterManuallyText);
        selenium.enterText(streetTextBox, registerUserData.getStreet(), true);
        selenium.enterText(houseNumTextBox, registerUserData.getHouseNum(), true);
        selenium.enterText(zipCodeTextBox, registerUserData.getPostalCode(), true);
        selenium.enterText(cityTextBox, registerUserData.getCity(), true);
        WebElement selectState = driver.findElement(By.id("regionCode"));
        Select selectStateDropDown = new Select(selectState);
        selectStateDropDown.selectByVisibleText("Berlin");
        WebElement selectCountry = driver.findElement(By.id("countryCode"));
        Select countryDropdown = new Select(selectCountry);
        countryDropdown.selectByVisibleText("Deutschland");
        selenium.click(furtherButton);
        selenium.enterText(nickNameTextBox, registerUserData.getNickName(), true);
        selenium.enterText(passwordTextBox, registerUserData.getPlayerPassword(), true);
        selenium.enterText(emailTextBox, registerUserData.getPlayerEmail(), true);
        WebElement selectSecurityDropdown = driver.findElement(By.id("securityQuestionTag"));
        Select securityDropDown = new Select(selectSecurityDropdown);
        securityDropDown.selectByVisibleText("Name meines ersten Haustieres?");
        selenium.enterText(securityAnswerTextBox, registerUserData.getSecurityResponseTextBox(), true);
        selenium.click(furtherButton);
        selenium.enterText(monthlyLimitTextBox, registerUserData.getMonthlyDeposit(), true);
        selenium.click(optionalLimitTextBox1);
        selenium.click(optionalLimitTextBox2);
        selenium.click(optionalLimitTextBox3);
        selenium.click(optionalLimitTextBox4);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(3000);
        WebElement selectRadioButton =  driver.findElement(By.xpath("//span[text()='Ja, ich stimme zu.']"));
        selectRadioButton.click();
//        List<WebElement> radio = driver.findElements(By.id("Ja, ich stimme zu."));
//        Random randomChoose = new Random();
//        int radioIndex = randomChoose.nextInt(radio.size());
//        radio.get(radioIndex).click();
        selenium.click(submitRegistrationButton);
//        selenium.click(verificationButton);
    }

    /**
     * @return getText of RegisterUser
     * @throws InterruptedException Exception
     */
    public String getVerificationText() {
        return selenium.getText(verificationText);
    }
}
