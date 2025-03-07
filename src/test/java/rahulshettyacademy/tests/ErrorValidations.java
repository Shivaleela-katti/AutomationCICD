package rahulshettyacademy.tests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.productCatelog;

public class ErrorValidations extends BaseTest {

	
	@Test(groups= {"ErrorHandlings"})
	public void LoginErrorValidation()
	{
		landingpage.loginApplication("anshika@gmail.com", "Imhjking@000");
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());		
		
	}
	@Test(retryAnalyzer = rahulshettyacademy.TestComponent.Retry.class)
	public void producterrorValidation() throws InterruptedException
	{

		
		WebDriverManager.chromedriver().setup();
	
		String productName= "ZARA COAT 3";
		productCatelog productcatelog=landingpage.loginApplication("anshika@gmail.com", "Iamking@000");
		Thread.sleep(2000);
		List<WebElement> products=productcatelog.getProductList();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		productcatelog.addProductToCard(productName);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollTo(0,document.body.scrollTop)");
		Thread.sleep(2000);
		
		CartPage cartpage= productcatelog.goToCart();			
		Boolean match=cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		

	}
}
