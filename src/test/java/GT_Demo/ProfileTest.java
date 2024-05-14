package GT_Demo;

import base.BaseTest;
import datafactory.GTDF.*;
import dataobjects.GTDO.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GtPO.bonus.BonusPO;
import pageobjects.GtPO.cashback.MyCashBackPO;
import pageobjects.GtPO.deposit.DepositePO;
import pageobjects.GtPO.home.HomePO;
import pageobjects.GtPO.invite.InviteEmailPO;
import pageobjects.GtPO.limits.DepositLimitPO;
import pageobjects.GtPO.overview.OverviewPO;
import pageobjects.GtPO.player.PlayerAccountPO;
import pageobjects.GtPO.previous.PreviousGamePO;
import pageobjects.GtPO.profile.ProfilePO;
import pageobjects.GtPO.selflock.OASISSelfLockPO;
import pageobjects.GtPO.transactions.TransactionPO;
import utilities.Constants;

import static utilities.ExtentReport.extent;
import static utilities.ExtentReport.extentTest;

public class ProfileTest extends BaseTest {

    @Test
    public void VerifyThatUserIsAbleToInviteFriendsUsingValidEmailAddress() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        InviteEmailPO inviteEmailPO = new InviteEmailPO(driver);
        inviteEmail inviteEmailData = new InviteEmailData().validEmail();
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click On invite friends tab");
        profilePO.clickOnInviteFriendsTab();

        Reporter.log("Step 4: Enter valid email and click on 'Send' button");
        inviteEmailPO.enterValidEmailIntoEmailTextBox(inviteEmailData);
        inviteEmailPO.clickOnSendButton();
        Assert.assertEquals(inviteEmailPO.getSuccessAlertMessage(), Constants.getAlertPopUpText, "Success toaster is displayed");
    }

    @Test
    public void VerifyThatValidationMessageIsDisplayedWhenUserEnterSameEmailWithinOneMinute() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        InviteEmailPO inviteEmailPO = new InviteEmailPO(driver);
        inviteEmail inviteEmailData = new InviteEmailData().validEmail();
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 2: Click On invite friends tab");
        profilePO.clickOnInviteFriendsTab();

        Reporter.log("Step 3: Enter valid email and click on 'Send' button");
        inviteEmailPO.enterValidEmailIntoEmailTextBox(inviteEmailData);
        inviteEmailPO.clickOnSendButton();

        Reporter.log("Step 4: Again click on 'Send' button");
        inviteEmailPO.clickOnSendButton();
        Assert.assertEquals(inviteEmailPO.getSuccessAlertMessage(), Constants.getAlertPopUpTextOneMin, "Alert popup text is not matched");
    }

    @Test
    public void VerifyThatUserIsAbleToAddPhoneNumber() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        phone phoneData = new PhoneNumberData().validPhoneNum();
        PlayerAccountPO playerAccountPO = new PlayerAccountPO(driver);
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on player account tab");
        profilePO.clickOnPlayerAccountTab();

        Reporter.log("Step 4: Enter valid mobile number");
        playerAccountPO.enterPhoneNumber(phoneData);
        playerAccountPO.clickOnSaveButton();
        Assert.assertNotNull(playerAccountPO.getPhoneNumber(), "Phone number data is not null");
    }

    @Test
    public void verifyThatUserIsAbleToAddDepositSuccessfully() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        DepositePO depositePO = new DepositePO(driver);
        limit limitData = new LimitData().depositLimit();
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 2: Click on Deposit Tab");
        profilePO.clickOnDepositTab();

        Reporter.log("Step 3: Enter the deposit amount and select the gateway");
        depositePO.enterDepositAmount(limitData);

        Reporter.log("Step 4: Select valid gateway method");
        depositePO.selectValidPaymentGatewayMethod();

        Reporter.log("Step 5: Click on 'Back' button");
        depositePO.clickOnBackButtonOfPaymentGateWay();
        Assert.assertEquals(depositePO.getLimitPageText(), Constants.getDepositHeadingText, "Deposit limit is not matched");
    }

    @Test
    public void VerifyThatUserIsAbleToSearchTheGame() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        search searchdata = new SearchGameData().nameOfGame();

        Reporter.log("Step 1: Search the game name into the search bar");
        homePO.clickOnSearchBarAndInputWithTheValidNameOfGame(searchdata);
//        String getSearchedText =  "Book of Ra™ Deluxe";
//        Assert.assertEquals(homePO.getSearchedText(),getSearchedText, "Searched text is not matched");
    }

    @Test
    public void VerifyThatUserIsAbleToSetTheLimit() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        DepositLimitPO depositLimitPO = new DepositLimitPO(driver);
        limit limitdata = new LimitData().depositLimit();
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on limit tab");
        profilePO.clickOnLimitTab();
        homePO.scrollDownPage();

        Reporter.log("Step 4: Set the limit and click on 'Save' button");
        depositLimitPO.selectLimitType();
        depositLimitPO.selectPeriod();
        depositLimitPO.addAmount(limitdata);
        depositLimitPO.clickOnSaveButton();
        Assert.assertEquals(depositLimitPO.getDepositLimit(), Constants.getSuccessMessageOfLimits, "Success toaster text is not matched");
    }

    @Test
    public void VerifyThatUserIsAbleToSeeTheTransactionBySelectingTheValidValueFromTheDropDown() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        TransactionPO transactionPO = new TransactionPO(driver);
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on 'Transaction Tab' from the 'Profile' section");
        profilePO.clickOnTransactionTab();

        Reporter.log("Step 4: Select the value form the dropdown");
        transactionPO.selectTheValueFromTheDropDown();
        Assert.assertNotNull(transactionPO.getTransactionText(), "The value is null");
    }

    @Test
    public void VerifyThatUserIsAbleToSeeThePreviousGameHistory() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        PreviousGamePO previousGamePO = new PreviousGamePO(driver);
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on 'Transaction Tab' from the 'Profile' section");
        profilePO.clickOnPreviousTab();

        Reporter.log("Step 4: Select the value form the dropdown");
        previousGamePO.clickAndSelectPreviousGameDropDown();
        Assert.assertEquals(previousGamePO.getValidationMessageText(), Constants.getTextValidationPreviousGame, "Message toaster text is not matched");
    }

    @Test
    public void VerifyBonusHistoryPageLoadsCorrectlyOrNot() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        ProfilePO profilePO = new ProfilePO(driver);
        BonusPO bonusPO = new BonusPO(driver);
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on 'Bonus History' tab from the 'Profile' section");
        profilePO.clickOnBonusHistoryTab();
        Assert.assertEquals(bonusPO.getBonusPageText(), Constants.getBonusHistoryText, "Bonus page text is not matched");
    }

    @Test
    public void VerifyThatPayMoneyAndPayableMoneyAreSame() throws InterruptedException {

        ProfilePO profilePO = new ProfilePO(driver);
        OverviewPO overviewPO = new OverviewPO(driver);
        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on 'Overview' tab");
        profilePO.clickOnOverViewTab();
        Assert.assertEquals(overviewPO.getPayableMoneyText(), homePO.getPayMoneyText(), "Money value is different");
    }

    @Test
    public void VerifyThatDepositPageIsDisplayed() throws InterruptedException {

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        DepositePO depositePO = new DepositePO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on deposit button from the header and navigate to the respected page");
        HomePO.clickOnDepositButton();
        Assert.assertEquals(depositePO.getDepositMoneyText(), Constants.getDepositText, "Deposit Text is not matched");
    }

    @Test
    public void VerifyThatMyCashBackPageIsDisplayed() throws InterruptedException {

        ProfilePO profilePO = new ProfilePO(driver);
        HomePO homePO = new HomePO(driver);
        MyCashBackPO myCashBackPO = new MyCashBackPO(driver);
        loginUser loginuserdata = new LoginData().login();
        OverviewPO overviewPO = new OverviewPO(driver);

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on 'My cashback' tab");
        profilePO.clickOnMyCashBackTab();
        Assert.assertEquals(myCashBackPO.getMyCashBackText(), Constants.getCashBackText, "Cashback Text is not matched");
    }

    @Test
    public void VerifyThatTheErrorMessageIsDisplayedWhenUserPutTheNegativePassword() throws InterruptedException {

        ProfilePO profilePO = new ProfilePO(driver);
        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();
        loginUser invalidPassword = new LoginData().invalidLogin();
        OverviewPO overviewPO = new OverviewPO(driver);
        OASISSelfLockPO oasisSelfLockPO = new OASISSelfLockPO(driver);


        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);

        Reporter.log("Step 2: Click on 'Profile Icon' button");
        HomePO.clickOnProfileIcon();
        Assert.assertEquals(overviewPO.getUserNameText(), Constants.getUserName, "User name is not matched");

        Reporter.log("Step 3: Click on the 'OASIS self lock' tab");
        profilePO.clickOnTheSelfLockTab();
        Assert.assertEquals(oasisSelfLockPO.getTextOfTheOASISSelfLock(), Constants.getOasisGetText, "The Heading is not matched");

        Reporter.log("Step 4: Select the 'period of time' dropdown");
        oasisSelfLockPO.selectTheValidDropDownAndEnterTheInvalidPassword(invalidPassword);
        Assert.assertEquals(oasisSelfLockPO.getErrorMessageText(), Constants.getOasisErrorMessageText, "Error message is not matched");
    }
}