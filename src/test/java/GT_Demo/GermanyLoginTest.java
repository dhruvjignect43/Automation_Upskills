package GT_Demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class GermanyLoginTest {
    @Test
    public void VerifyThatVPNConnectedAndLoginSuccessfully() {

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("./Extensions/Free VPN ZenMate-Best VPN for Chrome.crx"));
        WebDriver driver = new ChromeDriver(options);
        String extension_Protocol = "chrome-extension";
        String extension_ID = "fdcgdnkidjaadafnichfpabhfomcebme";
        String indexPage = extension_Protocol + "D:\\Automation_Upskills" + extension_ID + "index.html";
        driver.get(indexPage);
        driver.get("https://www.google.com/");


//        String extension_Protocol = "chrome-extension";
//        String extension_ID = "fdcgdnkidjaadafnichfpabhfomcebme";
//        String indexPage = extension_Protocol + "D:\\Automation_Upskills\\fdcgdnkidjaadafnichfpabhfomcebme" + extension_ID + "index.html";
//        driver.get(indexPage);
//        options.addExtensions(new File("/Extensions/Free VPN ZenMate-Best VPN for Chrome.crx"));
    }
}
//
//        try {
//            Robot robot = new Robot();
//            int iconX = 100;
//            int iconY = 100;
//            robot.mouseMove(iconX, iconY);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            Thread.sleep(1000);
//
//            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
//        } catch (AWTException | InterruptedException e) {
//            e.printStackTrace();
//        }

//        driver.get("chrome://extensions/");
//        driver.get("chrome://extensions/?id=fdcgdnkidjaadafnichfpabhfomcebme");
//        WebElement extension = ((RemoteWebDriver) driver).findElement(By.id("extension-icon"));
//        extension.click();

//        Robot robot = new Robot();
//        int iconX = 50;
//        int iconY = 50;
//        robot.mouseMove(iconX, iconY);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);

//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("D:\\Automation_Upskills\\1139ba08-b49d-4375-9740-173e8ef4e27d\\index.html");
//        driver.get("chrome-extension:///D:/Automation_Upskills/1139ba08-b49d-4375-9740-173e8ef4e27d/index.html");
//        WebElement extensionIcon = driver.findElement(By.cssSelector("div.toolbar-icon.extension-icon"));
//        extensionIcon.click();
//
//        List<WebElement> allElements = driver.findElements(By.tagName("div"));
//        for (WebElement element : allElements) {
//            String classAttribute = element.getAttribute("class");
//            if (classAttribute != null && classAttribute.contains("toolbar-icon") && classAttribute.contains("extension-icon")) {
//                break;
//            }
//        }
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement extensionIcon = (WebElement) js.executeScript("return document.querySelector('div.toolbar-icon.extension-icon');");
//        extensionIcon.isDisplayed();
//        extensionIcon.click();
//

//        driver.close();
//        String extension_Protocol = "chrome-extension";
//        String extension_ID = "fdcgdnkidjaadafnichfpabhfomcebme";
//        String indexPage = extension_Protocol + "D:\\Automation_Upskills\\fdcgdnkidjaadafnichfpabhfomcebme" + extension_ID + "index.html";
//        WebDriver driver = new ChromeDriver(options);
//        driver.get(indexPage);
//        options.addExtensions(new File("Extensions/ZenMate VPN.crx"));


