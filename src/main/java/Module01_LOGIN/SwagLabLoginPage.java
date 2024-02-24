package Module01_LOGIN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	@FindBy(xpath = "//input[@id='user-name']")private WebElement UN;
	@FindBy(xpath = "//input[@id='password']")private WebElement PWD;
	@FindBy(xpath = "//input[@id='login-button']")private WebElement LoginBtn;
	@FindBy(xpath = "//div[@class='error-message-container error']") private WebElement ErrorMsg;
	WebDriver driver;
	
	
	public SwagLabLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void inpSwagLabLoginPageUN(String userName) 
	{
		UN.sendKeys(userName);
	}
	public void inpSwagLabLoginPagePass(String password) 
	{
		PWD.sendKeys(password);
	}
	public void clickSwagLabLoginPageLoginBtn() 
	{
		LoginBtn.click();
	}
	 public String verifySwagLabLoginPageErrorMsg() 
		{
			String actError = ErrorMsg.getText();
			return actError;
		}
}












