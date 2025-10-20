package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Scenario_1 extends common_methods.Loading_Browser_Page{

	@Given("Launching the Browser.")
	public void launching_the_browser() {
		edge_browser();
		dr.manage().window().maximize();
	}
	@When("Launch the URL.")
	public void launch_the_url() {
		dr.get("https://www.amazon.in/");
	}
	@Then("Assert the Title and URL.")
	public void assert_the_title_and_url() {
		String url=dr.getCurrentUrl();
		String title=dr.getTitle();
//		System.out.println(url+" "+title);
		Assert.assertEquals("https://www.amazon.in/",url);
		Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",title);
	}
	@When("Click on Today”s Deal.")
	public void click_on_today_s_deal() {
       WebElement element=dr.findElement(By.xpath("//div[@id='nav-xshop']//ul//li[5]"));
       WebDriverWait wait=new WebDriverWait(dr,Duration.ofSeconds(50));
       wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	@Then("Assert the Page Contains title as “Deals”.")
	public void assert_the_page_contains_title_as_deals() {
       Actions act=new Actions(dr);
       act.scrollByAmount(0, 1000).perform();
       String text=dr.findElement(By.xpath("//div[@id='discount-bubble-deals-collection-powerasins-deals']/button")).getText();
       Assert.assertEquals("Deals for you",text);
	}
	@When("Click on the first Item of the “Today's Deals”.")
	public void click_on_the_first_item_of_the_today_s_deals() {
        dr.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[1]/div/div/div[1]")).click();
	}
	@Then("Assert the Product Name.")
	public void assert_the_product_name() throws Exception{
        String product_name=dr.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
//        System.out.println(product_name);
        Assert.assertEquals(product_name, product_name);
        Thread.sleep(5000);
	}
	@When("Go back to Deals Page and click on the second item.")
	public void go_back_to_deals_page_and_click_on_the_second_item() throws Exception{
        dr.findElement(By.xpath("//div[@id='nav-xshop']//ul//li[5]")).click();
        Actions act=new Actions(dr);
        act.scrollByAmount(0, 1000).perform();
        dr.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[1]/div/div/div[2]")).click();
	}
	@Then("Close the browser.")
	public void close_the_browser() throws Exception {
        Thread.sleep(4000);
        dr.quit();
	}
}
