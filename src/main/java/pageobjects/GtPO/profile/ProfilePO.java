package pageobjects.GtPO.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class ProfilePO extends BasePO {
    public ProfilePO(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@label='user-invite-friends-navigation-item']")
    private WebElement inviteFriendTab;

    @FindBy(xpath = "//a[@label='user-logout-navigation-item']")
    private WebElement logOutButton;

    @FindBy(css = "a[label*='user-deposit']")
    private WebElement depositButton;

    @FindBy(css = "a[label*='details-navigation'")
    private WebElement playerAccountTab;

    @FindBy(css = "a[label*='limits']")
    private WebElement limitTab;

    @FindBy(css = "a[label*='transaction']")
    private WebElement transactionTab;

    @FindBy(css = "a[label*='user-game-history']")
    private WebElement previousGameTab;

    @FindBy(css = "a[label*='bonus-history']")
    private WebElement bonusHistoryTab;

    @FindBy(css = "a[label*='user-overview']")
    private WebElement overViewTab;

    @FindBy(css = "a[label*='user-bonus-conversion']")
    private WebElement myCashBackTab;

    @FindBy(css = "a[label*='user-transversal-exclusion']")
    private WebElement OASISTab;



    /**
     * Invite Tab.
     *
     * @throws InterruptedException Exception
     */
    public void clickOnInviteFriendsTab() throws InterruptedException {
        selenium.click(inviteFriendTab);
    }

    /**
     * My Cashback tab.
     * @throws InterruptedException Exception.
     */
    public void clickOnMyCashBackTab() throws InterruptedException{
        selenium.click(myCashBackTab);
    }

    /**
     * OverView Tab
     * @throws InterruptedException Exception
     */
    public void clickOnOverViewTab() throws InterruptedException{
        selenium.click(overViewTab);
    }

    /**
     * Logout Button.
     * @throws InterruptedException Exception
     */
    public void clickOnLogoutButton() throws InterruptedException {
        selenium.click(logOutButton);
    }

    /**
     * Deposit Tab.
     * @throws InterruptedException Exception
     */
    public void clickOnDepositTab() throws InterruptedException {
        selenium.click(depositButton);
    }

    /**
     * Player Account Tab.
     * @throws InterruptedException Exception
     */
    public void clickOnPlayerAccountTab() throws InterruptedException {
        selenium.click(playerAccountTab);
    }

    /**
     * Limit Tab.
     * @throws InterruptedException Exception
     */
    public void clickOnLimitTab() throws InterruptedException {
        selenium.click(limitTab);
    }

    /**
     * Transaction Tab
     *
     * @throws InterruptedException Exception
     */
    public void clickOnTransactionTab() throws InterruptedException {
        selenium.click(transactionTab);
    }

    /**
     * Previous Tab.
     * @throws InterruptedException Exception
     */
    public void clickOnPreviousTab() throws InterruptedException {
        selenium.click(previousGameTab);
    }

    /**
     * Bonus history tab.
     * @throws InterruptedException Exception.
     */
    public void clickOnBonusHistoryTab() throws InterruptedException{
        selenium.click(bonusHistoryTab);
    }
    public void clickOnTheSelfLockTab() throws InterruptedException{
        selenium.click(OASISTab);
    }
}
