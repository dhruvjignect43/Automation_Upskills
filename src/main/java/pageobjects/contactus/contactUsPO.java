package pageobjects.contactus;

import dataobjects.contactUs;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.homepage.HomePO;

public class contactUsPO extends HomePO {
    public contactUsPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement enterName;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement enterEmail;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement enterSubject;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messagebox;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFileButton;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;


    /**
     * Fill the contact us form with valid data.
     *
     * @param contactusdata
     * @throws InterruptedException
     */
    public void enterValidContactUsDetailsAndClickOnSubmitButton(contactUs contactusdata) throws InterruptedException{
    selenium.enterText(enterName,contactusdata.getName(),true);
    selenium.enterText(enterEmail,contactusdata.getEmail(),true);
    selenium.enterText(enterSubject,contactusdata.getSubject(),true);
    selenium.enterText(messagebox,contactusdata.getMessage(),true);
    driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys("C:\\Users\\dhruv\\Desktop\\demo.txt");
    selenium.click(submitButton);
    selenium.acceptAlert();
//    Alert alert = driver.switchTo().alert();
//    alert.accept();
//    selenium.getTextFromAlert();
    }

    /**
     * Without fill the data in contact us form.
     *
     * @throws InterruptedException
     */
    public void clickOnSubmitButtonWithoutFillAnyDetails() throws InterruptedException{
        selenium.click(submitButton);
        driver.switchTo().alert().sendKeys("Press OK to proceed!");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        selenium.getTextFromAlert();
    }
//    public void acceptAlert() throws InterruptedException{
//        selenium.acceptAlert();
//    }
//    public String getValueFromAlert() throws InterruptedException{
//        return selenium.getTextFromAlert();
//    }
//
}
