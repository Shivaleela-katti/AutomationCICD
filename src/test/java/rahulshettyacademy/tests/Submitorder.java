package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.productCatelog;

public class Submitorder extends BaseTest{

	String productName= "ZARA COAT 3";
	@Test(dataProvider= "getData",groups= {"Purchage"})
	
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{

		
			WebDriverManager.chromedriver().setup();
		
			
			productCatelog productcatelog=landingpage.loginApplication(input.get("email"), input.get("password"));
			
			List<WebElement> products=productcatelog.getProductList();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			productcatelog.addProductToCard(input.get("product"));
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollTo(0,document.body.scrollTop)");
			Thread.sleep(2000);
			
			CartPage cartpage= productcatelog.goToCart();			
			Boolean match=cartpage.VerifyProductDisplay(input.get("product"));
			Assert.assertTrue(match);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			CheckOutPage checkoutpage= cartpage.goToCheckout();		
			checkoutpage.selectCountry("india");
			//driver.manage().window().setSize(new Dimension(1440,900));
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			ConfirmationPage confirmationpage= checkoutpage.submitOrder();
			js1.executeScript("window.scrollTo(0,document.body.scrollTop)");
			Thread.sleep(2000);
			String confirmMessage = confirmationpage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
			System.out.println(confirmMessage);

		}
		//verifyZARA coat 3 is displaying in orders page
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() throws InterruptedException
	{
		
		productCatelog productcatelog=landingpage.loginApplication("anshika@gmail.com", "Iamking@000");
		OrderPage ordertpage=productcatelog.goToOrderPage();
		Thread.sleep(2000);
//		Assert.assertTrue(ordertpage.VerifyOrderDisplay(productName));
	}
	
	
	
	//Extent report
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+ "//src//test//java//rahulshettyacademy//data//PurchageOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};

	}

	}


//@DataProvider
//public Object[][] getData()
//{
//	return new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//}
//
//HashMap<String,String> map= new HashMap<String,String>();
//map.put("email", "anshika@gmail.com");
//map.put("password", "Iamking@000");
//map.put("product", "ZARA COAT 3");
//
//HashMap<String,String> map2= new HashMap<String,String>();
//map2.put("email", "shetty@gmail.com");
//map2.put("password", "Iamking@000");
//map2.put("product", "ADIDAS ORIGINAL");
//return new Object[][] {{map},{map2}};




















