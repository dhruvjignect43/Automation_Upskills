// basetest is common as it contains webdriver setup and capture screenshot if failed
// structure : import, actual webdriver intialize, seleniumhelper and drivermanager : i think some use of that
package base;

import datafactory.GTDF.AuthenticationData;
import dataobjects.GTDO.authentication;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.GtPO.home.HomePO;
import utilities.Constants;
import utilities.DriverManager;
import utilities.ExtentReport;
import utilities.SeleniumHelpers;

import java.io.IOException;

import static utilities.ExtentReport.extent;
import static utilities.ExtentReport.extentTest;

public class BaseTest {

    protected WebDriver driver;
    protected SeleniumHelpers selenium;
    private DriverManager drivermanager;
    private static final ExtentReport extentReportListener = new ExtentReport();

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        drivermanager = new DriverManager();
        driver = drivermanager.setUp(browser);
        selenium = new SeleniumHelpers(driver);
        HomePO homePO = new HomePO(driver);
        authentication authenticationData = new AuthenticationData().authUser();
        selenium.navigateToPage(Constants.URL);
        homePO.enterAuthenticationCredentials(authenticationData);
    }

    @BeforeMethod
    public void reportGeneration(ITestResult result) {

        String className = result.getInstance().getClass().getName();
        extentTest = extent.createTest(className);
        extentTest.assignCategory("<p><b>Functional&nbsp;Testing</b>");
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        try {
            extentReportListener.onTestFailure(result, driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        extent.flush();
        drivermanager.tearDown();
    }

    @BeforeSuite
    public void beforeSuite() {
        extentReportListener.initializeReports();
    }
}
