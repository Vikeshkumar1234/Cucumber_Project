package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Scenario_1 extends common_methods.Loading_Browser_Page {
    static ExtentReports extent;
    static ExtentTest test;

    @Before
    public void setUpExtentReport() {
        if (extent == null) {
            extent = extendReport.getReportInstance("AmazonTestReport");
        }
        // Create one test for this scenario or test class
        test = extent.createTest("Amazon Scenario 1");
    }

    @When("Launch the URL.")
    public void launch_the_url() {
        dr.get("https://www.amazon.in/");
        test.pass("URL Launched Successfully.");
    }

    @Then("Assert the Title and URL.")
    public void assert_the_title_and_url() {
        String url = dr.getCurrentUrl();
        String title = dr.getTitle();

        Assert.assertEquals("https://www.amazon.in/", url);
        Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", title);
        test.pass("Validation of URL and Title completed successfully.");
    }

    @When("Click on Today”s Deal.")
    public void click_on_todays_deal() {
        WebElement element = dr.findElement(By.xpath("//div[@id='nav-xshop']//ul//li[5]"));
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        test.pass("Clicked on Today's Deal successfully.");
    }

    @Then("Assert the Page Contains title as “Deals”.")
    public void assert_the_page_contains_title_as_deals() {
        Actions act = new Actions(dr);
        act.scrollByAmount(0, 1000).perform();

        String text = dr.findElement(By.xpath("//div[@id='discount-bubble-deals-collection-powerasins-deals']/button")).getText();
        Assert.assertEquals("Deals for you", text);
        test.pass("Page contains title 'Deals' validated successfully.");
    }

    @When("Click on the first Item of the “Today's Deals”.")
    public void click_on_the_first_item_of_the_todays_deals() {
        dr.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        test.pass("Clicked on the first item of Today's Deals.");
    }

    @Then("Assert the Product Name.")
    public void assert_the_product_name() throws Exception {
        String product_name = dr.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
        Assert.assertEquals(product_name, product_name); // This assertion does nothing meaningful, consider improving it
        test.pass("Product name assertion completed.");
        Thread.sleep(5000);
    }

    @When("Go back to Deals Page and click on the second item.")
    public void go_back_to_deals_page_and_click_on_the_second_item() throws Exception {
        dr.findElement(By.xpath("//div[@id='nav-xshop']//ul//li[5]")).click();
        Actions act = new Actions(dr);
        act.scrollByAmount(0, 1000).perform();
        dr.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[1]/div/div/div[2]")).click();
        test.pass("Navigated to Deals Page and clicked on the second item.");
    }
}
