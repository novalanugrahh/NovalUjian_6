package juaracoding.com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import juaracoding.com.driver.DriverSingleton;



public class CheckoutPage {
	
private WebDriver driver;
	
	public CheckoutPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#nav-menu-item-cart > a > span > i")
	private WebElement btnViewCart;
	
	@FindBy(css="#post-6 > div > div > div.cart-collaterals > div.cart_totals > div > a")
	private WebElement btnProcessCheckout;
	
	@FindBy(id = "billing_first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="billing_last_name")
	private WebElement txtLastName;
	
	@FindBy(id="billing_company")
	private WebElement txtCompany;
	
	@FindBy(id="select2-billing_country-container")
	private WebElement txtCountry;
	
	@FindBy(id="billing_address_1")
	private WebElement txtAddress1 ;
	
	@FindBy(id="billing_address_2")
	private WebElement txtAddress2;
	
	@FindBy(id="billing_city")
	private WebElement txtCity;
	
	@FindBy(id="select2-billing_state-container")
	private WebElement txtState;
	
	@FindBy(css = "#billing_postcode")
	private WebElement txtPin;

	@FindBy(id="billing_phone")
	private WebElement txtPhone;

	@FindBy(id="terms")
	private WebElement btnTerms;

	@FindBy(id="place_order")
	private WebElement btnOrder;
	
	@FindBy(css="div > div > div > p.woocommerce-thankyou-order-received")
	private WebElement txtMessage;

	public void ViewCart() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnViewCart.click();
	}
	
	public void ProcessCheckout() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnProcessCheckout.click();
	}
	
	public void Input1() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		txtFirstName.sendKeys("noval");
		txtLastName.sendKeys("anugrah");
		txtCompany.sendKeys("novalanugrahh");
	}
	
	public void Country (int selection) {
		txtCountry.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			 lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)");
	}
	
	public void Input2() {
		txtAddress1.sendKeys("condet");
		txtAddress2.sendKeys("jalan pangeran");
		txtCity.sendKeys("jakarta timur");
	}
	
	public void State (int selection) {
		txtState.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			 lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)");
	}
	
	public void Input3() {
		txtPin.sendKeys("123456");
		txtPhone.sendKeys("281198");
	}
	
	public void Order() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnTerms.click();
		btnOrder.click();
	}
	
	public String Message() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)");
		return txtMessage.getText();
	}

}
