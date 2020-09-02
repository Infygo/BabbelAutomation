package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports exrep;
	
	public static ExtentReports reportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		//static ExtentReports exrep;
		
		// instantiate Extentsparkreport
		ExtentSparkReporter exspreporter = new ExtentSparkReporter(path);
		exspreporter.config().setDocumentTitle("AndroidAppAutomation results");
		exspreporter.config().setReportName("Test Results");
		
		//instantiate ExtentReports 
		exrep = new ExtentReports();
		exrep.attachReporter(exspreporter);
		exrep.setSystemInfo("Automation Tester", "Vigneshwaran");
		return exrep;
	}

}
