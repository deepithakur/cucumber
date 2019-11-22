package caseStudy1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration {

	WebDriver driver=null;
	
	
	
	@Given("User opens TestMeApp register page")
	public void user_opens_TestMeApp_register_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\NexGen Testing Stream NEW\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.linkText("SignUp")).click();
	    System.out.println("inside given block");
	}

	@When("enter username as {string}")
	public void enter_username_as(String uName) {
		WebElement uname=driver.findElement(By.id("userName"));
		uname.sendKeys(uName);
		uname.sendKeys(Keys.ENTER);
		String available=driver.findElement(By.id("err")).getText();
		Assert.assertEquals(available, "Available");
		System.out.println("inside when block for username");
	}

	@When("enter firstname as {string}")
	public void enter_firstname_as(String fname) {
		driver.findElement(By.id("firstName")).sendKeys(fname);
	}

	@When("enter lastname as {string}")
	public void enter_lastname_as(String lname) {
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("enter password as {string}")
	public void enter_password_as(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("enter confirm password as {string}")
	public void enter_confirm_password_as(String cnfpwd) {
		driver.findElement(By.id("pass_confirmation")).sendKeys(cnfpwd);
	}

	@When("select the Gender as {string}")
	public void select_the_Gender_as(String gender) {
		driver.findElement(By.cssSelector("input[value='Female']")).click();
	}

	@When("enter email address as {string}")
	public void enter_email_address_as(String string) {
		driver.findElement(By.id("emailAddress")).sendKeys("deepi@gmail.com");
	}
	

	@When("^enter mobile number as \"([^\"]*)\"$")
	public void enter_mobile_number_as(String phone) throws Throwable {
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567890");
	    
	}

	@When("^enter date of birth as \"([^\"]*)\"$")
	public void enter_date_of_birth_as(String date) throws Throwable {
		driver.findElement(By.name("dob")).sendKeys("08/01/2019");
	    
	}

	@When("^enter the address as \"([^\"]*)\"$")
	public void enter_the_address_as(String addrs) throws Throwable {
		driver.findElement(By.id("address")).sendKeys("BEML layout");
	    
	}

	@When("^select the security question as \"([^\"]*)\"$")
	public void select_the_security_question_as(String secure) throws Throwable {
		Select question=new Select(driver.findElement(By.id("securityQuestion")));
		question.selectByVisibleText("What is your Birth Place?");
		
	    
	}

	@When("^enter the answer as \"([^\"]*)\"$")
	public void enter_the_answer_as(String secans) throws Throwable {
		driver.findElement(By.name("answer")).sendKeys("qwertyu");
	}

	    

	@When("^click on Register button$")
	public void click_on_Register_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	    
	}




	@Then("Deepika is successfully registered")
	public void deepika_is_successfully_registered() {
		String login=driver.findElement(By.xpath("//*[@id=\"demo1\"]")).getText();
		Assert.assertEquals(login, "Login");
		driver.close();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Given("The user has opened the TestMe Application")
	public void the_user_has_opened_the_TestMe_Application() {
		System.setProperty("webdriver.chrome.driver", "C:\\NexGen Testing Stream NEW\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url="http://10.232.237.143:443/TestMeApp";
		driver.get(url);
		 driver.findElement(By.linkText("SignUp")).click();
	}

	@When("The user enters username as {string}")
	public void the_user_enters_username_as(String string) {
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Dei12345");
	 }

	@When("The user enters the firstName as {string}")
	public void the_user_enters_the_firstName_as(String string) {
		  driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Deepika");
	}

	@When("The user enters the lastName as {string}")
	public void the_user_enters_the_lastName_as(String string) {
		  driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Thakur");

	}

	@When("The user enters the password as {string}")
	public void the_user_enters_the_password_as(String string) {
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password123");

	}

	@When("The user enters the confirmPassword as {string}")
	public void the_user_enters_the_confirmPassword_as(String string) {
		  driver.findElement(By.xpath("//input[@id='pass_confirmation']")).sendKeys("password123");

	}

	@When("the user selects the gender as \"Female")
	public void the_user_selects_the_gender_as_Female() {
		  driver.findElement(By.xpath("//input[@value='Female']")).click();

	}

	@When("The user enters the email address as {string}")
	public void the_user_enters_the_email_address_as(String string) {
		  driver.findElement(By.id("emailAddress")).sendKeys("mcgh@gmail.com");
	}

	@When("enter mobile number as {string}")
	public void enter_mobile_number_as(String string) {
		  driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("8793669572");

	}

	@When("enter date of birth as {string}")
	public void enter_date_of_birth_as(String string) {
		driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img")).click();
		 driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
	}

	@When("enter the address as {string}")
	public void enter_the_address_as(String string) {
		  driver.findElement(By.id("address")).sendKeys("Nagpur, Maharashtra");

	}

	@When("select the security question as {string}")
	public void select_the_security_question_as(String string) {
		

		Select question=new Select(driver.findElement(By.id("securityQuestion")));
		  question.selectByVisibleText("What is your Birth Place?");
	}

	@When("enter the answer as {string}")
	public void enter_the_answer_as(String string) {
		  driver.findElement(By.name("answer")).sendKeys("nagpur");

	}

	@When("click on Register button")
	public void click_on_Register_button() {
		  driver.findElement(By.name("Submit")).click();

	}

	@Then("deepika is successfully registered")
	public void deepika_is_successfully_registered() {
		System.out.println("The page title is " + driver.getTitle());
	}

	*/
}
