package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

//import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);//sending variable to to parent class
		this.driver=driver;//==driver is current class instance variable
		//this.driver is local variable
		PageFactory.initElements(driver, this);
	}
		//initelements is a methods to constructing that using a driver argument what we passing 
		//WebElement userEmail=driver.findElement(By.xpath("//input[@type='email']"));
		
	
		//using pageFactory redusing the syntex to creating the webelement 
		@FindBy(xpath="//input[@type='email']")//at runtime it will construct the driver.findElement(By.xpath("//input[@type='email']"));
		WebElement userEmail; //declear variable

		@FindBy(css=".form-control.ng-untouched.ng-pristine.ng-invalid")
		WebElement Password;
		
		@FindBy(css="input[id='login']")
		WebElement login;
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		By productBy = By.cssSelector(".mb-3");
		
		@FindBy(css="[aria-label='Incorrect email or password.']")
		WebElement errorMessage;		
		public productCatelog loginApplication(String email, String passpord)//action method
		{
			userEmail.sendKeys(email);
			Password.sendKeys(passpord);
			login.click();
			productCatelog productcatelog=new productCatelog(driver);
			return productcatelog;
		}
		
		public String getErrorMessage()
		{
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(productBy);
			return products;
		}
}
