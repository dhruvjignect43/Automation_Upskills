package GT_Demo;

import base.BaseTest;
import datafactory.GTDF.VpnCredentialsData;
import dataobjects.GTDO.authentication;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.GtPO.vpn.VpnPO;

import java.io.File;
import java.io.IOException;

public class ExtensionTest extends BaseTest{

    @Test
    public void VerifyThatVPNisConnectedSuccessfully() throws InterruptedException, IOException {

        authentication vpnAuthenticationData = new VpnCredentialsData().inValidVPN();

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("./Extensions/geo edge.crx"));
        WebDriver driver = new ChromeDriver(options);
        driver.get("chrome-extension://ceiephhhfaockiigbdgihcngnaamdcll/themes/geoedge/login.html");
        VpnPO vpnPO = new VpnPO(driver);
        Runtime.getRuntime().exec("Extensions/geoedgeclick.exe");

        Reporter.log("Step 1: Enter VPN credentials and click on 'Login' button");
//        vpnPO.enterVpnCredentials(vpnAuthenticationData);
        try {
            vpnPO.enterVpnCredentials(vpnAuthenticationData);
        } catch (NoSuchWindowException e) {

            System.out.println("Window already closed.");
        }
    }
}
