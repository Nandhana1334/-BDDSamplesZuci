package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginStepDef {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}
	@Given("User is on Login Page")
	public void user_is_in_login_page() {
	    
		driver.get("https://the-internet.herokuapp.com/login");
	}
//	@When("User enters credentials")
//	public void user_enter_credentials() {
//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");
//		WebElement password = driver.findElement(By.id("password"));
//    	password.sendKeys("SuperSecretPassword!");
//		driver.findElement(By.tagName("button")).click();
	    
	//}
	
//	@When("User enters {string} and {string}")
//	public void user_enter_credentials(String strUser,String strPwd) {
//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(strUser);
//		WebElement password = driver.findElement(By.id("password"));
//    	password.sendKeys(strPwd);
//		driver.findElement(By.tagName("button")).click();
//	    
//	}
	
	
//	@Then("Should display Success Msg")
//	public void should_display_success_message() {
//		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//    	Assert.assertTrue(isUserValid);
//	}
	
//	@When("User enters credentials")
//	public void user_enters_credentials(io.cucumber.datatable.DataTable dataTable) {
//		List<List<String>> users = dataTable.asLists();
//		String strUser = users.get(0).get(0);
//		String strPwd = users.get(0).get(1);
//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(strUser);
//		driver.findElement(By.name("password")).sendKeys(strPwd);
//		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
//		
//		
//		
//	}
	@When("User enters credentials")
	public void user_enters_credentials(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> users = dataTable.asMaps();
		String strUser = users.get(0).get("username");
		String strPwd = users.get(0).get("password");
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(strUser);
		driver.findElement(By.name("password")).sendKeys(strPwd);
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		
		
		
	}
	
	
//	@Then("Should display Success Msg")
//	public void should_display_success_message() {
//		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//    	Assert.assertTrue(isUserValid);
//	}
//	@When("User enter invalid credentials")
//	public void user_enter_invalid_credentials() {
//		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("nan@gmail.com");
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("nand");
//		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
//	   
//	}
//	@Then("should display invalid sign in message")
//	public void should_display_invalid_sign_in_message() {
//	    boolean check=driver.findElement(By.xpath("//li[contains(text(),'email or password')]")).isDisplayed();
//	    Assert.assertTrue(check);
//	}
	
	@Then("Should display Success Msg")
	public void should_display_success_msg(DataTable dataTable)
	{
		List<String> msgs = dataTable.asList();
		String expMsg = msgs.get(0);
		Assert.assertEquals("You logged into a secure area!", expMsg);
	}

}
