package utilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ExtentReport implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    public void initializeReports() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/extentSparkReports.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("GT Automation Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setTimelineEnabled(true);
        sparkReporter.config().setProtocol(Protocol.HTTPS);
        List<ViewName> DEFAULT_ORDER = Arrays.asList(ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST, ViewName.EXCEPTION);
        sparkReporter.viewConfigurer().viewOrder().as(DEFAULT_ORDER);
        extent = new ExtentReports();
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Browser", "Chrome");
    }

    public void accessReporterTest(ExtentTest extentTest, ITestResult result) {
        String[] logs = Reporter.getOutput(result).toArray(new String[0]);
        for (String log : logs) {
            extentTest.info(log);
        }
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTest extentTest = test.get();
        accessReporterTest(extentTest, result);
    }

    public static String getScreenshots(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyymmddhhss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/FailedTestScreenshots/Failed Case" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public void onTestFailure(ITestResult result, WebDriver driver) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            result.getThrowable().printStackTrace(printWriter);
            String stackTrace = "<pre>" + stringWriter.toString().replace(System.getProperty("line.separator"), "<br>") + "</pre>";
            extentTest.log(Status.FAIL, "<pre>"+"<b>Name of Failed Case: </b>" + result.getName()+"</pre>");
            extentTest.log(Status.FAIL,"<b>Cause By error is : <b>" + stackTrace);
            extentTest.log(Status.INFO, "<pre>"+"<b>Case Info Status: <b>" + result.getStatus()+"</pre>");
            String screenshotsPath = ExtentReport.getScreenshots(driver, result.getName());
            extentTest.log(Status.FAIL, (Markup) extentTest.addScreenCaptureFromPath(screenshotsPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "<pre>"+"<b>Test case skipped is: <b>" + result.getThrowable()+"</pre>");
        }
    }
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
