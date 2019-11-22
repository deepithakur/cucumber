package caseStudy1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	

	WebDriver driver=null;
	
	@Given("The user has login the TestMe Application")
	public void the_user_has_login_the_TestMe_Application() {
		System.setProperty("webdriver.chrome.driver", "C:\\NexGen Testing Stream NEW\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String url="http://10.232.237.143:443/TestMeApp";
		
		driver.get(url);
		driver.findElement(By.linkText("SignIn")).click();
	}
	
	@When("User enters {string} in Username field")
	public void user_enters_in_Username_field(String username) {
		driver.findElement(By.id("userName")).sendKeys(username);
	 
	}

	@When("User enters {string} in password field")
	public void user_enters_in_password_field(String password) {
		 driver.findElement(By.id("password")).sendKeys(password);
	}

	

	@Then("user is logged in successfully")
	public void user_is_logged_in_successfully() {
		driver.findElement(By.name("Login")).click();
		System.out.println("the page title is "+driver.getTitle());
		driver.close();
		
	   
	}



}
