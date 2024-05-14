package utilities;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class SetProxy {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("192.168.4.3:8080");
        options.addExtensions(new File("D:\\crx files\\majdfhpaihoncoakbjgbdhglocklcgno.crx"));
        options.setAcceptInsecureCerts(true);
        options.setCapability("proxy",proxy);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.zomato.com/ahmedabad");
        driver.quit();
    }
}
