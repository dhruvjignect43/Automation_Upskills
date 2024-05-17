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
import static utilities.Constants.PROPERTY_FILE;


public class ExtentReport implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    String environment = JavaHelpers.getPropertyValue(PROPERTY_FILE, "Env");


    public void initializeReports() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/extentReports.html");
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
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", environment);
    }

    public void accessReporterTest(ExtentTest extentTest, ITestResult result) {
        String[] logs = Reporter.getOutput(result).toArray(new String[0]);
        for (String log : logs) {
            extentTest.info(log);
        }
    }

    public void onTestStart(ITestResult result) {
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.assignCategory("Passed");
        accessReporterTest(extentTest, result);
        ExtentTest extentTest = test.get();
        accessReporterTest(extentTest, result);
        onTestStart(result);
    }

    public static String getScreenshots(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String relativePath = "Screenshots/" + screenshotName + dateName + ".png";
        String absolutePath = System.getProperty("user.dir") + "/Reports/" + relativePath;
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File finalDestination = new File(absolutePath);
        FileUtils.copyFile(source, finalDestination);
        return relativePath;
    }

    public void onTestFailure(ITestResult result, WebDriver driver) throws IOException {
        accessReporterTest(extentTest, result);
        if (result.getStatus() == ITestResult.FAILURE) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            result.getThrowable().printStackTrace(printWriter);

            String stackTrace = "<pre>" + stringWriter.toString().replace(System.getProperty("line.separator"), "<br>") + "</pre>";
            extentTest.log(Status.FAIL, "<pre><b>Name of Failed Case: </b>" + result.getName() + "</pre>");
            extentTest.log(Status.FAIL, "<b>Cause By error is :</b>" + stackTrace);
            extentTest.log(Status.INFO, "<pre><b>Case Info Status: </b>" + result.getStatus() + "</pre>");
            extentTest.log(Status.INFO, "<pre><b>Start Time: </b>" + new Date(result.getStartMillis()) + "</pre>");
            extentTest.log(Status.INFO, "<pre><b>End Time: </b>" + new Date(result.getEndMillis()) + "</pre>");
            long duration = result.getEndMillis() - result.getStartMillis();
            extentTest.log(Status.INFO, "<pre><b>Duration: </b>" + duration + " ms</pre>");
            String screenshotsPath = ExtentReport.getScreenshots(driver, result.getName());
            extentTest.addScreenCaptureFromPath(screenshotsPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "<pre><b>Test case skipped is: </b>" + result.getThrowable() + "</pre>");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.INFO, "<pre><b>Package Name: </b>" + result.getTestClass().getRealClass().getPackage().getName() + "</pre>");
            extentTest.log(Status.INFO, "<pre><b>Class Name: </b>" + result.getTestClass().getRealClass().getSimpleName() + "</pre>");
            extentTest.log(Status.INFO, "<pre><b>Method Name: </b>" + result.getMethod().getMethodName() + "</pre>");
            extentTest.log(Status.INFO, "<pre><b>Start Time: </b>" + new Date(result.getStartMillis()) + "</pre>");
            extentTest.log(Status.INFO, "<pre><b>End Time: </b>" + new Date(result.getEndMillis()) + "</pre>");
            long duration = result.getEndMillis() - result.getStartMillis();
            extentTest.log(Status.INFO, "<pre><b>Duration: </b>" + duration + " ms</pre>");
        }
    }
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
