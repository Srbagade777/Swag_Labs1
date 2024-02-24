package Module01_LOGIN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabMenuPage
{
	@FindBy(xpath = "//a[text()='Logout']")private WebElement LogoutBtn;
	 
	public SwagLabMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickSwagLabMenuPageLogoutBtn() 
	{
		LogoutBtn.click();
	}
	

}
