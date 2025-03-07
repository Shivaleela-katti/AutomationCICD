package rahulshettyacademy.pageobject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

//import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class productCatelog extends AbstractComponent{

	WebDriver driver;
	
	public productCatelog(WebDriver driver) {
		super(driver);//
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		// TODO Auto-generated method stub

		//initelements is a methods to constructing that using a driver argument what we passing 
		//WebElement userEmail=driver.findElement(By.xpath("//input[@type='email']"));
		
	
		//pageFactory
		@FindBy(css=".ng-animating")
		WebElement spinner;
	
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		By productBy = By.cssSelector(".mb-3");
		By addToCart= By.cssSelector(".card-body button:last-of-type");
		By toastMessage =By.cssSelector("#toast-container");
		
		
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(productBy);
			return products;
		}
		
		public WebElement getProductByName(String productName)
		{
			WebElement prod =	products.stream().filter(product->
			product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;
		}
		public void addProductToCard(String product)
		{
			WebElement prod= getProductByName(product);
			prod.findElement(addToCart).click();
			waitForElementToAppear(toastMessage);
			
			
		}
}

