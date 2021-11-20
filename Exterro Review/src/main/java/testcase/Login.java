package testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ExterroReview.Pages.Login_Page;
import com.ExterroReview.Utility.BaseClass;
import com.ExterroReview.Utility.Excel_DataProvider;


public class Login extends BaseClass
{
	
	Excel_DataProvider excel=new Excel_DataProvider("./Excel Test Data/Log 2.xlsx");	
	
	
	@Test
	public void login() throws InterruptedException
	
	{	
		Reporter.log("Test is about to Start", true);
		
		logger=report.createTest("Login to Exterro");
			
			Login_Page lpage=PageFactory.initElements(driver, Login_Page.class);
		
		logger.info("Starting the Application");
		
			lpage.loginToExterro(excel.getSheetIndex(1, 1, 0),excel.getSheetIndex(1, 1, 1));
		//  lpage.loginToExterro(config.getUserName(),config.getPassword());
				
		logger.pass("Login Success");

	}

}
 