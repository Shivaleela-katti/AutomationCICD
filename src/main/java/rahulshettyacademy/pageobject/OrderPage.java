package rahulshettyacademy.pageobject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class OrderPage extends  AbstractComponent{

	WebDriver driver;

	@FindBy(xpath="//html/body/app-root/app-profile/div/div[2]/ul/li/div/div[3]/button[1]")
	WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(2)")
private	List<WebElement> productname;
	
public OrderPage(WebDriver driver) {
	super(driver);//
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public Boolean VerifyOrderDisplay(String productName) {
	
	Boolean match=productname.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
	return match;	
}

}
