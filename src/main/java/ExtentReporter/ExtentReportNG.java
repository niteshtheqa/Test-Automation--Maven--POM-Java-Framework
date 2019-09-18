package ExtentReporter;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportNG implements IReporter {

	public ExtentReports extent;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		extent = new ExtentReports(outputDirectory + File.separator + "CRM.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);

			}
		}

		extent.flush();
		extent.close();
	}

	public void buildTestNodes(IResultMap tests, LogStatus status) {

		ExtentTest test;
		if (tests.size() > 0) {

			for (ITestResult results : tests.getAllResults()) {
				test = extent.startTest(results.getMethod().getMethodName());
				test.setEndedTime(getTime(results.getStartMillis()));
				test.setEndedTime(getTime(results.getEndMillis()));
				for (String group : results.getMethod().getGroups()) {
					test.assignCategory(group);

				}

				if (results.getThrowable() != null) {
					test.log(status, results.getThrowable());
				} else {
					test.log(status, "Test" + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(test);
			}

		}

	}
	
	
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
