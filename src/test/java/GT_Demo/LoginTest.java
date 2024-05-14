package GT_Demo;

import base.BaseTest;
import datafactory.GTDF.LoginData;
import dataobjects.GTDO.loginUser;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GtPO.home.HomePO;
import pageobjects.GtPO.overview.OverviewPO;
import pageobjects.GtPO.profile.ProfilePO;
import utilities.Constants;

import static utilities.ExtentReport.extent;
import static utilities.ExtentReport.extentTest;

public class LoginTest extends BaseTest {

    @Test
    public void VerifyThatUserIsAbleToLoginSuccessfully() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        OverviewPO overviewPO = new OverviewPO(driver);
//        Constants.getUserName = "fvdkfvnkfdv";

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");
    }

    @Test
    public void VerifyThatUserIsAbleToLogoutSuccessFully() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 2: Click on 'Logout' tab");
        profilePO.clickOnLogoutButton();
        Assert.assertEquals(homePO.getLoginText(), Constants.getHomeLoginText, "Login Text is not matched");
    }

    @Test
    public void VerifyThatUserIsNotAbleToLoginWithInvalidUserCredentials() throws InterruptedException {
        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().invalidLogin();

        Reporter.log("Step 1: Enter Invalid Login Credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);
        Assert.assertEquals(homePO.getLoginValidationMessage(), Constants.getLoginValidationText, "Validation message is not matched");
    }
}
