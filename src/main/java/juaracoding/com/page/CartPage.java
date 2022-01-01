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

public class CartPage {
	
private WebDriver driver;
	
	public CartPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
//	ke icon shop toolsnye
	@FindBy(css="#noo-site > header > div.navbar-wrapper > div > div > div > div > a > img")
	private WebElement btnShoptools;
	
//	tombol search
	@FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a")
	private WebElement btnFind;
	
//	TYPE AND PRESS ENTER TO SEARCH
	@FindBy(css="#noo-site > header > div.search-header.search-header-eff > div.noo-container > form > input.form-control")
	private WebElement txtFind;
	
//	shoes
	@FindBy(css ="#noo-site > div.page_fullwidth > div > div > div.padding-stylebox.wpb_column.vc_column_container.vc_col-sm-12.vc_col-lg-7.vc_col-md-7.vc_hidden-sm > div > div > div > div.noo-sh-product-grid.woocommerce > div.noo-sh-product-html.columns_3.no_masonry.three.row.is-flex > div > div > h3 > a")
	private List<WebElement> btnShoes;
	
//	warna
	@FindBy(id="pa_color")
	private WebElement btnColorShoes;
	
//	size
	@FindBy(id="pa_size")
	private WebElement btnSizeShoes;
		
//	cart
	@FindBy(css="div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement btnAddToCartShoes;
	

//	tombol glassnye
	@FindBy(css="#noo-site > div.noo-container-shop.noo-shop-wrap > div.noo-row > div > div > div > div > h3 > a")
	private List<WebElement> btnGlass;
	
//	tombol buat warna glasnya
	@FindBy(id="pa_color")
	private WebElement btnColorGlass;
	
//	tombol buat size glassnya
	@FindBy(id="pa_size")
	private WebElement btnSizeGlass;
		
//	tombol tambah glass ke cart
	@FindBy(css="div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement btnAddToCartGlass;
	
//	tombol 
	public void goToShoes() {
		btnShoptools.click();
	}
	
	public void Shoes() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnShoes.get(2).click();
	}
	
	public void ColorClothes (int selection) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)");
		btnColorShoes.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			 lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();		
	}
	
	public void SizeClothes (int selection) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnSizeShoes.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			 lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
		btnAddToCartShoes.click();
	}
	
	public void Find () {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnFind.click();
		txtFind.sendKeys("Glass");
		txtFind.sendKeys(Keys.ENTER);
	}
	
	public void Glass () {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnGlass.get(1).click();
	}
	
	public void ColorGlass (int selection) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)");
		btnColorGlass.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			 lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();		
	}
	
	public void SizeGlass (int selection) {
		btnSizeGlass.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			 lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnAddToCartGlass.click();
	}

}
