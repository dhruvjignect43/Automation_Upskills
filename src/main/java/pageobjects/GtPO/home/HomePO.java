package pageobjects.GtPO.home;

import dataobjects.GTDO.authentication;
import dataobjects.GTDO.loginUser;
import dataobjects.GTDO.search;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.Constants;

public class HomePO extends BasePO {
    public HomePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div//a[@class='link link-main-header']")
    private WebElement loginButton;

    @FindBy(id = "user")
    private WebElement userIdTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "nickname")
    private WebElement playerName;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='form-component']")
    private WebElement loginSubmitButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieHandler;

    @FindBy(css = "app-alert[class*='alert-message']")
    private WebElement loginValidation;

    @FindBy(className = "search")
    private WebElement searchBar;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@role='button']/div/span[contains(text(),'Einzahlen')]")
    private WebElement registerButton;

    @FindBy(css = "div[label*='main-header']")
    private WebElement payMoneyText;

    @FindBy(xpath = "//div[contains(text(),'Jetzt spielen')]/parent::a")
    private WebElement playGameButton;

    @FindBy(css = "div[class*='temporary-self']")
    private WebElement gameDisplayText;

    @FindBy(css = "div[class='fl controlButton controlButton_paytable']")
    private WebElement gameStartButton;


    public static String depositButton = "a[label='main-header-deposit-button']";

    public static String profileIcon = "div[class*='item-userpic']";
    public static String gamePlayButton = "//a[contains(text(), 'Crystal Ball')]//following-sibling::div";
//    public static String gameStartButton = "div[class='fr controlButton reactsToPressSpace spinButton controlButton_spin huge isPulsing pulse']";


    /**
     * Login Credentials.
     *
     * @param loginUserData data
     * @throws InterruptedException Exception
     */
    public void enterLoginCredentials(loginUser loginUserData) throws InterruptedException {
        selenium.waitTillElementIsVisible(loginButton);
        selenium.click(loginButton);
        selenium.enterText(playerName, loginUserData.getPlayerName(), true);
        selenium.enterText(loginPassword, loginUserData.getLoginPassword(), true);
        selenium.click(loginSubmitButton);
    }

    /**
     * User Authentication.
     *
     * @param authenticationData Authentication Data
     * @throws InterruptedException Exception
     */
    public void enterAuthenticationCredentials(authentication authenticationData) throws InterruptedException {
        selenium.enterText(userIdTextBox, authenticationData.getUsername(), true);
        selenium.enterText(passwordTextBox, authenticationData.getPassword(), true);
        selenium.click(submitButton);
        selenium.click(cookieHandler);
    }

    /**
     * Static method click on deposit button.
     *
     * @throws InterruptedException Exception
     */
    public static void clickOnDepositButton() throws InterruptedException {
        Thread.sleep(15000);
        driver.findElement(By.cssSelector(depositButton)).click();
    }

    /**
     * Static method click on profile icon.
     *
     * @throws InterruptedException Exception
     */
    public static void clickOnProfileIcon() throws InterruptedException{
        Thread.sleep(15000);
        driver.findElement(By.cssSelector(profileIcon)).click();
    }

    /**
     * Hover-over the specific game from the list.
     * @throws InterruptedException Exception
     */
    public void selectAndPlayTheGame() throws InterruptedException{
        WebElement elementToHover = driver.findElement(By.xpath("//div[contains(@class, 'game-info show-on-hover')]/a[text()='Crystal Ball']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }

    /**
     * Play game button
     * @throws InterruptedException Exception
     */
    public static void clickOnPlayGameButton()throws InterruptedException{
        driver.findElement(By.xpath(gamePlayButton)).click();
    }

    /**
     *
     * @throws InterruptedException Exception
     */
    public void clickOnGameStartButton() throws InterruptedException{

        selenium.waitTillElementIsVisible(gameStartButton);
        selenium.waitTillElementIsClickable(gameStartButton);
        selenium.clickOn(gameStartButton);
    }

    /**
     * @return getText of pay Money Text
     * @throws InterruptedException Exception.
     */
    public String getPayMoneyText() throws InterruptedException {
        return selenium.getText(payMoneyText);
    }

    /**
     *
     * @return getText of the display game.
     * @throws InterruptedException Exception
     */
    public String getPlayGameText() throws InterruptedException{
        selenium.waitTillElementIsVisible(gameDisplayText);
        return selenium.getText(gameDisplayText);
    }

    /**
     * @return Validation message
     * @throws InterruptedException Exception
     */
    public String getLoginValidationMessage() throws InterruptedException {
        return selenium.getText(loginValidation);
    }

    /**
     * @return getText login.
     */
    public String getLoginText() {
        return selenium.getText(loginButton);
    }

    /**
     * Search the game
     *
     * @param searchData data
     * @throws InterruptedException Exception
     */
    public void clickOnSearchBarAndInputWithTheValidNameOfGame(search searchData) throws InterruptedException {
        selenium.click(searchBar);
        selenium.enterText(searchInput, searchData.getSearchGame(), true);
        WebElement elementToHover = driver.findElement(By.xpath("//div[contains(@class, 'game-info show-on-hover')]/a[text()='Crystal Ball']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
//        WebElement elementToHover = driver.findElement(By.xpath("//app-game-icon[@class='game-item content ng-star-inserted']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(elementToHover).perform();
//        WebElement elementToClick = driver.findElement(By.xpath("//app-game-icon[@class='game-item content ng-star-inserted']//a[contains(@href,'/de/slots/book-of-ra')]"));
//        elementToClick.click();
        //app-game-icon[@class='game-item content ng-star-inserted']//a[contains(@href,'/de/slots/book-of-ra')]
    }

    /**
     * Page Scroll up/down
     */
    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 850);");
    }

    /**
     * Click on registration button
     */
    public void clickOnRegisterButton() {
        driver.findElement(By.cssSelector("a[label*='register']")).click();
//        selenium.click(registerButton);
    }
//    public static void ClickOnUserPic() throws InterruptedException {
//        Thread.sleep(15000);
//        driver.findElement(By.xpath(registerButton)).click();
//    }
}
