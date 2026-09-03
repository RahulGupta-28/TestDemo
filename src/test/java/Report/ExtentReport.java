package Report;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReport {
	
	public static ExtentReports invokeExtentReport() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File("src\\test\\java\\Report"+"\\index.html"));
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Automation Results");
		
		ExtentReports report = new ExtentReports();
		report.setSystemInfo("TesterName", "Rahul Gupta");
		report.attachReporter(reporter);
		return report;
		
		
		
	}

}
