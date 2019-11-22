package caseStudy1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Shopping1 {
	WebDriver driver=null;
	boolean cartAvailable;
	
	@Given("user has logged into TestMe Application")
	public void user_has_logged_into_TestMe_Application() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\NexGen Testing Stream NEW\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String url="http://10.232.237.143:443/TestMeApp";
		driver.get(url);
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("lalitha");
		 driver.findElement(By.id("password")).sendKeys("password123");
		 driver.findElement(By.name("Login")).click();
		String exptd=driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/ul")).getText();
		 Assert.assertEquals(exptd, "Hi, lalitha SignOut");
	}
	
	@When("user searches for a product")
	public void user_searches_for_a_product() {
		driver.findElement(By.name("products")).sendKeys("head");
		 driver.findElement(By.name("products")).sendKeys(Keys.ENTER);
	}
	

	
		 
		 @When("user tries to proceed to payment without adding any item to cart")
			public void user_tries_to_proceed_to_payment_without_adding_any_item_to_cart() {
				//driver.switchTo().alert().accept();
			 String cart= "Cart";
				try {
					 WebElement element = driver.findElement(By.partialLinkText(cart));
					 element.click();
					boolean cartAvailable = true;
				}
				 catch (org.openqa.selenium.NoSuchElementException|StaleElementReferenceException e) {
					 e.printStackTrace();
				}

	}
	@Then("cart icon is not displayed")
	public void cart_icon_is_not_displayed()   
	{
		Assert.assertTrue(!cartAvailable);
		
		driver.close();
		/*SoftAssert sa = new SoftAssert();
		
		sa.assertNull(driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")), "Cart icon not displayed");
		sa.assertAll();*/
		
}
	
	@When("the user searches for a products")
	public void the_user_searches_for_a_products() {
	    
		driver.findElement(By.name("products")).sendKeys("head");
		 driver.findElement(By.name("products")).sendKeys(Keys.ENTER);
	}
	
	
	@When("^user adds the product to cart and clicks on cart icon$")
	public void user_adds_the_product_to_cart_and_clicks_on_cart_icon()  {
		
		driver.findElement(By.xpath("//a[contains(text(),' Add to cart')]")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	 driver.findElement(By.xpath("/html/body/main/section/div[3]/table/tfoot/tr[2]/td[5]/a")).click();
	//driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	 

	}

	@When("^the user proceeds to pay with valid credentials$")
	public void the_user_proceeds_to_pay_with_valid_credentials() throws Throwable {
	driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
		WebDriverWait w = new WebDriverWait(driver,10);
		 w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(text(),'Andhra Bank')]")));
		driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click();
		driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
		driver.findElement(By.name("username")).sendKeys("123456");
		driver.findElement(By.name("password")).sendKeys("Pass@456");;
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");;
		driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	//driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/a")).click();
	// driver.findElement(By.name("username")).sendKeys("123457");
	// driver.findElement(By.name("password")).sendKeys("Pass@457");
	// driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	/// driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/form/input")).sendKeys("Trans@457");
	//driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/form/div/div[2]/input")).click();
	   
	}

	@Then("^order placed successfully$")
	public void order_placed_successfully() throws Throwable {
	  String confirmation= driver.findElement(By.xpath("/html/body/b/section/div/div/div/div[2]/p")).getText();
	  Assert.assertEquals(confirmation, "Your order has been confirmed");
	  driver.close();
	}
	
	

}
