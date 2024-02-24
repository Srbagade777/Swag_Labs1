package Module02_InvalidDetails_TEST;

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
import Module01_LOGIN.SwagLabLoginPage;
import Module01_LOGIN.SwagLabMenuPage;

public class TC2_SwagLabLoginWithInvalidDetailsTest extends BaseClass
{

	SwagLabLoginPage login;
	SwagLabMenuPage menu;
	int TCID;
	@BeforeClass
	public void openBrowser() throws IOException 
	{
		initilizeBrowser();
		login=new SwagLabLoginPage(driver);
		menu=new SwagLabMenuPage(driver);
	}
	@BeforeMethod
	public void loginToApp() throws InterruptedException, IOException 
	{
		login.inpSwagLabLoginPageUN(UtilityClass.getDataFromPF("UN"));
		Thread.sleep(1000);
		login.inpSwagLabLoginPagePass(UtilityClass.getDataFromPF("WRPWD"));
		Thread.sleep(1000);
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(1000);
	}
	@Test
	public void verifyErrorMSG() throws EncryptedDocumentException, IOException 
	{
		TCID=999;
		String actError=login.verifySwagLabLoginPageErrorMsg();
		String expError = UtilityClass.getTD(0, 3);
		
		Assert.assertEquals(actError, expError, "failed both results are failed");
	}
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException
	{
		if (s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver,TCID);
		}
		Thread.sleep(1000);
		
	}
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}

	
}
