package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;


public class ChromeVpnExtension {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void beforeTest(){
        String rootFolder = System.getProperty("user.dir");
        File vpn = new File(rootFolder + File.separator + "src" + File.separator + "test" + File.separator + "resource" + File.separator + "touchVPN.crx");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(vpn);
        driver = new ChromeDriver(new ChromeOptions());
        driver.manage().window().maximize();
    }
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    }

    @Test
    public void checkIPHasChanged() throws InterruptedException{
        Thread.sleep(2000);
        String extension_Protocol = "chrome-extension";
        String extension_ID = "bihmplhobchoageeokmgbdihknkjbknd";
        String indexPage = extension_Protocol + "D:\\bihmplhobchoageeokmgbdihknkjbknd" + extension_ID + "/panel/index.html";
        if(driver == null){
            System.out.println("Driver is not initialized, Initializing driver");
            initializeDriver();
        }
        driver.get(indexPage);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.findElement(By.id("ConnectionButton")).click();
        driver.get("https://whatismyipaddress.com/");
        // Switch back to the main window
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String countryName = driver.findElement(By.xpath("//span[text()='Country']/following-sibling::span")).getText();
        Assert.assertNotEquals(countryName.equals("Vietnam"),"United States");
    }
}

