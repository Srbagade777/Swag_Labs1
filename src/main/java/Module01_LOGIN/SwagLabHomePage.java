package Module01_LOGIN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	 @FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement MenuBtn;
	 @FindBy(xpath = "(//button[text()='Add to cart'])[1]")private WebElement addToKart;
	 @FindBy(xpath = "//a[@class='shopping_cart_link']")private WebElement addToLOGO;
	 WebDriver driver;
	 
	 public SwagLabHomePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 public void clickSwagLabHomePageMenuBtn() 
	 {
		 MenuBtn.click();
	 }
	 public void clickSwagLabHomePageAddToKartBtn() 
	 {
		 addToKart.click();
	 }
	 public void clickSwagLabHomePageAddToKartLogo() 
	 {
		 addToLOGO.click();
	 }
	 public String getSwagLabHomePageTitle() 
	 {
		 String actTitle = driver.getTitle();
		 return actTitle;
	}

	 
}
