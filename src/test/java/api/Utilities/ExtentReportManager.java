package api.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReporter;
	public ExtentTest extentTest;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		
		String timeStramp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+timeStramp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+ repName);
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationTesting");
		sparkReporter.config().setReportName("Pet user details api");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extentReporter = new ExtentReports();
		extentReporter.attachReporter(sparkReporter);
		extentReporter.setSystemInfo("Application", "Pet store User");
		extentReporter.setSystemInfo("OS", System.getProperty("os.name"));
		extentReporter.setSystemInfo("UserName", System.getProperty("user.name"));
		extentReporter.setSystemInfo("User", "Pavan Sir");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest = extentReporter.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.createNode(result.getName());
		extentTest.log(Status.PASS, "test case passed");	
	}
	
	public void onTestFailure(ITestResult result) {
		extentTest = extentReporter.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.createNode(result.getName());
		extentTest.log(Status.FAIL, "test case failed");
		extentTest.log(Status.FAIL, result.getThrowable().getMessage());		
	}
	
	public void onTestSkipped(ITestResult result) {
		extentTest = extentReporter.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.createNode(result.getName());
		extentTest.log(Status.SKIP, "test case Skipped");
		extentTest.log(Status.SKIP, result.getThrowable().getMessage());		
	}
	
	public void onFinish(ITestContext testContext) {
		extentReporter.flush();
	}
}
