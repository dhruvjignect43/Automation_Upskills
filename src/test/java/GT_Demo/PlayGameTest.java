package GT_Demo;

import base.BaseTest;
import datafactory.GTDF.LoginData;
import dataobjects.GTDO.loginUser;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.GtPO.home.HomePO;
import utilities.Constants;

public class PlayGameTest extends BaseTest {

    @Test
    public void VerifyThatUserIsAbleToPlayTheGame() throws InterruptedException{

        HomePO homePO = new HomePO(driver);
        loginUser loginuserdata = new LoginData().login();

        Reporter.log("Step 1: Login with valid credentials Into Login Section and click on submit button");
        homePO.enterLoginCredentials(loginuserdata);
        Thread.sleep(5000);

        Reporter.log("Step 2: Select any game and play it");
        homePO.selectAndPlayTheGame();
        HomePO.clickOnPlayGameButton();
        Assert.assertEquals(homePO.getPlayGameText(), Constants.getPlayGameText,"Button Text is not matched");
//        Reporter.log("Step 3: Click on Game Start button");
//        homePO.clickOnGameStartButton();
    }
}
