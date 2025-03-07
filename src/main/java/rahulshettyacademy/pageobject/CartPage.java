package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CartPage extends  AbstractComponent{

	WebDriver driver;

	@FindBy(xpath="//html/body/app-root/app-profile/div/div[2]/ul/li/div/div[3]/button[1]")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
private	List<WebElement> cartproducts;
	
public CartPage(WebDriver driver) {
	super(driver);//
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public Boolean VerifyProductDisplay(String productName) {
	
	Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	return match;
	
}
public CheckOutPage goToCheckout() {
	checkoutEle.click();
	return new CheckOutPage(driver);
}

}
