package Module03_TC3_AddToCartProduct_TEST;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module01_LOGIN.SwagLabHomePage;
import Module01_LOGIN.SwagLabLoginPage;
import Module01_LOGIN.SwagLabMenuPage;
import Module01_LOGIN.SwagLabYourCartPage;

public class TC3_SwagLabAddToCartProductTest extends BaseClass
{


	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	SwagLabYourCartPage kart;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws IOException 
	{
		initilizeBrowser();
		login=new SwagLabLoginPage(driver);
		home=new SwagLabHomePage(driver);
		menu=new SwagLabMenuPage(driver);
		kart=new SwagLabYourCartPage(driver);
	}
	@BeforeMethod
	public void loginToApp() throws InterruptedException, IOException 
	{
		login.inpSwagLabLoginPageUN(UtilityClass.getDataFromPF("UN"));
		Thread.sleep(1000);
		login.inpSwagLabLoginPagePass(UtilityClass.getDataFromPF("PWD"));
		Thread.sleep(1000);
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(1000);
		
	}
	@Test
	public void verifyPN() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		home.clickSwagLabHomePageAddToKartBtn();
		Thread.sleep(1000);
		home.clickSwagLabHomePageAddToKartLogo();
		Thread.sleep(1000);
		
		TCID=555;
		String actPN = kart.clickSwagLabYourCartPageAddToKartBtn();
		String expPN = UtilityClass.getTD(0, 4);
		
		Assert.assertEquals(actPN, expPN, "failed both results are failed");
	}
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException
	{
		if (s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver,TCID);
		}
		home.clickSwagLabHomePageMenuBtn();
		Thread.sleep(1000);
		menu.clickSwagLabMenuPageLogoutBtn();	
		Thread.sleep(1000);
	}
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}

	


}
