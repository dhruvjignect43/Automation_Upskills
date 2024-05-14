package pageobjects.GtPO.vpn;

import dataobjects.GTDO.authentication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;


public class VpnPO extends BasePO {
    public VpnPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login-username")
    private WebElement userNameTextBox;

    @FindBy(id = "login-password")
    private WebElement passwordTextBox;

    @FindBy(id = "login-login")
    private WebElement loginButton;

    @FindBy(id = "container")
    private WebElement vpnDropDownOptions;

    public void enterVpnCredentials(authentication vpnAuthenticationData) throws InterruptedException {
        selenium.enterText(userNameTextBox, vpnAuthenticationData.getUsername(), true);
        selenium.enterText(passwordTextBox, vpnAuthenticationData.getPassword(), true);
        selenium.click(loginButton);
        Thread.sleep(5000);
        
//        selenium.waitTillElementIsVisible(vpnDropDownOptions);
    //        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://www.zomato.com/india");
    }
}
