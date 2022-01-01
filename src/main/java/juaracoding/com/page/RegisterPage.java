package juaracoding.com.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import juaracoding.com.driver.DriverSingleton;



public class RegisterPage {
	
private WebDriver driver;
	
	public RegisterPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
//	element register
	
//	buat klick dismiss nye
	@FindBy(css="body > p > a")
	private WebElement btnDismiss;
	
//	buat klick my akun
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li")
	private List<WebElement> btnMyaccount;
	
//	masukin username nye
	@FindBy(id="reg_username")
	private WebElement txtUsername;
	
//	masukin emailnye
	@FindBy(id="reg_email")
	private WebElement txtEmail;
	
//	masukin passwordnye
	@FindBy(id="reg_password")
	private WebElement txtPassword;
	
//	tombol registnye
	@FindBy(css="#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")
	private WebElement btnRegister;
	
//	eksekusi register
	public void goToRegisterPage() {
		btnDismiss.click();
		btnMyaccount.get(1).click();
	}
	
	public void goToRegister() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)");
		txtUsername.sendKeys("novalanugrah2898");
		txtEmail.sendKeys("novalanugrah2898@example.com");
		txtPassword.sendKeys("novalanugrah2898");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnRegister.click();
	}

}
