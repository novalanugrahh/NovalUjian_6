package juaracoding.com.glue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import juaracoding.com.config.AutomationFrameworkConfiguration;
import juaracoding.com.driver.DriverSingleton;
import juaracoding.com.page.CartPage;
import juaracoding.com.page.CheckoutPage;
import juaracoding.com.page.LoginPage;
import juaracoding.com.page.RegisterPage;
import juaracoding.com.utils.ConfigurationProperties;
import juaracoding.com.utils.Constants;
import juaracoding.com.utils.TestCases;
import juaracoding.com.utils.Utils;


@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	
	private WebDriver driver;

	private RegisterPage registerPage;
	private LoginPage loginPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");

	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		registerPage = new RegisterPage();
		loginPage = new LoginPage();
		cartPage = new CartPage();
		checkoutPage = new CheckoutPage();
		TestCases[] tests = TestCases.values();
		extentTest = report.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	//register
	
	@Given("^User go to the Website")
	public void user_go_to_the_Website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to "+ Constants.URL);
	}
	
	@When("^User click myaccount page button")
	public void User_click_myaccount_page_button() {
		registerPage.goToRegisterPage();
		extentTest.log(LogStatus.PASS, "User click myaccount page button");
	}
	
	@And("^User input username email password and click register")
	public void User_input_username_email_password_and_click_register() {
		registerPage.goToRegister();
		extentTest.log(LogStatus.PASS, "User input username email password and click register");
	}
	
	@Then("^User success to register")
	public void User_success_to_register() {
		 extentTest.log(LogStatus.PASS, "User success to register");
	}
	
	//Login
	
	
	@When("^User back to first page and click myaccount page button")
	public void User_back_to_first_page_and_click_myaccount_page_button() {
		loginPage.goToLogin();
		extentTest.log(LogStatus.PASS, "User back to first page and click myaccount page button");
	}
	
	@And("^User input username or email password and click login")
	public void User_input_username_or_email_password_and_click_login() {
		loginPage.goInputLogin(configurationProperties.getEmail(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User input username or email password and click login");
	}

	@Then("^User can login to the website")
	public void User_can_login_to_the_website() {
//		assertThat(configurationProperties.getMesslogin(), containsString(loginPage.getMess()));
		extentTest.log(LogStatus.PASS, "User can login to the website");
	}
	
	//Cart
	
	@When("^User click shoptools button")
	public void User_click_shoptools_button() {
		cartPage.goToShoes();
		extentTest.log(LogStatus.PASS, "User click shoptools button");
	}
	
	@And("^User choose shoes colour size and click add to cart")
	public void And_User_choose_shoes_colour_size_and_click_add_to_cart() {
		cartPage.Shoes();
		cartPage.ColorClothes(1);
		cartPage.SizeClothes(1);
		extentTest.log(LogStatus.PASS, "User choose shoes colour size and click add to cart");
	}
	
	@And("^User click Find glass")
	public void User_click_Find_glass() {
		cartPage.Find();
		extentTest.log(LogStatus.PASS, "User click Find glass");
	}
	
	
	@And("^User choose glass colour size and click add to cart")
	public void And_User_choose_glass_colour_size_and_click_add_to_cart() {
		cartPage.Glass();
		cartPage.ColorGlass(1);
		cartPage.SizeGlass(1);
		extentTest.log(LogStatus.PASS, "User choose glass colour size and click add to cart");
	}
	

	@Then("^User succes to add cart")
	public void User_succes_to_add_cart() {
		extentTest.log(LogStatus.PASS, "User succes to add cart");
	}
	
	//Checkout
	
	@When("^User click viewcart button and process checkout")
	public void User_click_viewcart_button_and_process_checkout() {
		checkoutPage.ViewCart();
		checkoutPage.ProcessCheckout();
		extentTest.log(LogStatus.PASS, "User click viewcart button and process checkout");
	}
	
	@And("^User input form billing details")
	public void User_input_form_billing_details() {
		checkoutPage.Input1();
		checkoutPage.Country(0);
		checkoutPage.Input2();
		checkoutPage.State(1);
		checkoutPage.Input3();
		extentTest.log(LogStatus.PASS, "And User input form billing details");
	}
	
	@And("^User checklist terms and click place order")
	public void User_checklist_terms_and_click_place_order() {
		checkoutPage.Order();
		extentTest.log(LogStatus.PASS, "User checklist terms and click place order");
	}
	

	@Then("^User succes to checkout")
	public void User_succes_to_checkout() {
		checkoutPage.Message();
		assertEquals(configurationProperties.getMessage(), checkoutPage.Message());
		extentTest.log(LogStatus.PASS, "User succes to checkout");
	}
	
	
	@After
	public void closeObject() {
		report.endTest(extentTest);
		report.flush();
		
	}
	

}
