package stepdef;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends common_methods.Loading_Browser_Page {
    static ExtentReports extent;
    static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        if (extent == null) {
            extent = extendReport.getReportInstance("AmazonAutomation");
        }
        test = extent.createTest(scenario.getName());
        edge_browser();
        dr.manage().window().maximize();
    }

    // Optionally, add @After to flush and quit driver
    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep(2000);
        if (dr != null) dr.quit();

        if (scenario.isFailed()) {
            test.fail("Scenario failed");
        } else {
            test.pass("Scenario passed");
        }
        extent.flush();
    }
}
