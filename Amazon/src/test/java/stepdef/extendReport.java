package stepdef;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendReport {
	  private static ExtentReports extent;  // static instance
	 public static ExtentReports getReportInstance(String reportName) {
		 if (extent == null) {
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            String outputDirectory = "test-output/";
	            String fileName = reportName + "_" + timestamp + ".html";
	            String filePath = outputDirectory + fileName;

	            ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
	            reporter.config().setReportName("Automation Report - " + reportName);
	            reporter.config().setDocumentTitle("Test Results - " + reportName);

	            extent = new ExtentReports();
	            extent.attachReporter(reporter);
	            extent.setSystemInfo("Tester", "Vikeshkumar M");
	        }
	        return extent;
	    }
	}
