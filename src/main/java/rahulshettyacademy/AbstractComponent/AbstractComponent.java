package rahulshettyacademy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.OrderPage;



public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
//	System.out.println(driver.findElement(By.cssSelector("#toast-container")).getText());
	
	}
	public void waitForWebElementToAppear(WebElement findBy)
	{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
//	System.out.println(driver.findElement(By.cssSelector("#toast-container")).getText());
	
	}
	public CartPage goToCart() {
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(2000);
//	WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(2));
//	wait1.until(ExpectedConditions.invisibilityOf(ele));
//	System.out.println(driver.findElement(By.cssSelector("#toast-container")).getText());
	
	}
	

}
