package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckOutPage (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectcountry;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	public void selectCountry(String countryName) throws InterruptedException {
		Actions a =new Actions(driver);
		Thread.sleep(2000);
		//a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectcountry.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}
	public ConfirmationPage submitOrder() {
		waitForElementToAppear(By.cssSelector(".action__submit"));
		submit.click();
		return new ConfirmationPage(driver);
	}
}
