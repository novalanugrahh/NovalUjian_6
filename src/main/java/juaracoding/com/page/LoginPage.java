package juaracoding.com.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import juaracoding.com.driver.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
//	element login
	
	@FindBy(css ="#backtoblog > a")
	private WebElement btnBack;
	
	
//	tombol my akun
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li")
	private List<WebElement> btnMyaccount;
	
//	memasukan email
	@FindBy(id="username")
	private WebElement txtEmail;
	
//	memasuka password
	@FindBy(id="password")
	private WebElement txtPassword;
	
//	tombol login nye
	@FindBy(css = "#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button")
	private WebElement btnLogin;
	
//	eksekusi tombol loginye
	public void goToLogin() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		btnBack.click();
		btnMyaccount.get(1).click();
	}
	
	public void goInputLogin(String email, String password) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnLogin.click();
	}
	
}
