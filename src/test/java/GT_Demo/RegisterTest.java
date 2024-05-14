package GT_Demo;

import base.BaseTest;
import datafactory.GTDF.RegistrationData;
import dataobjects.GTDO.register;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GtPO.home.HomePO;
import pageobjects.GtPO.register.RegisterPO;
import utilities.Constants;

import static utilities.ExtentReport.extent;
import static utilities.ExtentReport.extentTest;

public class RegisterTest extends BaseTest {

    @Test
    public void VerifyThatUserIsAbleToRegisterYourSelfSuccessFully() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        RegisterPO registerPO = new RegisterPO(driver);
        register registerdata = new RegistrationData().validRegDetails();

        Reporter.log("Step 1: Click on 'Register' button");
        homePO.clickOnRegisterButton();

        Reporter.log("Step 2: Enter valid registration details and click on 'Submit' button.");
        registerPO.enterRegistrationDetails(registerdata);
        Assert.assertEquals(registerPO.getVerificationText(), Constants.getRegistrationTextPopUp, "Registration popup text is not matched.");
    }
}
