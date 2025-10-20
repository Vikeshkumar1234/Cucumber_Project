package stepdef;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Scenario_2 extends common_methods.Loading_Browser_Page{
	@When("Search the list of {string}.")
	public void search_the_list_of(String product) {
	    dr.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).click();
	    dr.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(product);
	    dr.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}
	@Then("Assert the Search Result of first Product containing the title as {string}.")
	public void assert_the_search_result_of_first_product_containing_the_title_as(String product) throws Exception {
	    String check=dr.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/div[2]/h2/span[3]")).getText();
	    String str=check.substring(1,check.length()-1);
	    Assert.assertEquals(product,str);
	    Thread.sleep(8000);
	}
	@Then("Close the browsers.")
	public void close_the_browsers() {
	    dr.quit();
	}
}
