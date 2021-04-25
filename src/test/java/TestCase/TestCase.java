package TestCase;

import BasePage.BasePage;
import Pages.Login;
import Pages.SearchProduct;
import Utils.Utility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase extends BasePage{
    Login objLogin;
    SearchProduct objItem;
    @Test(priority = 1,enabled = true,description = "Check if login is successful")
    public void doLogin() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin=new Login(driver);
        objLogin.doLogin("testuser412@grr.la","2t8zmqzL");
        Utility utility=new Utility(driver);
        utility.takeScreenShot("scrshot.png");
    }
    @Test(priority = 2,enabled = true,description = "Search by item name")
    public void searchItem() throws Exception {
        objItem=new SearchProduct(driver);
        objItem.searchItem("Dress");

    }
    @AfterMethod  //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                Utility utility=new Utility(driver);
                utility.takeScreenShot("fails.png");
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }

        }

    }
    @AfterTest
    public void finishTest(){

        driver.quit();
    }

}

