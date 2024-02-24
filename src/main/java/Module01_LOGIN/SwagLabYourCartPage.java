package Module01_LOGIN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabYourCartPage 
{
	@FindBy(xpath = "//div[@class='inventory_item_name']") private WebElement productName;
	
	public SwagLabYourCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String clickSwagLabYourCartPageAddToKartBtn() 
	{
		String actPN = productName.getText();
		return actPN;
	}
	
	
}
