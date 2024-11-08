package tests;

import lib.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends TestBase {


    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        String email = "pradeep.pp@gmail.com";
        String password = "Test#123";
        String fullName = "Automation Tester";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithValidCredentials(email,password,fullName);
    }
    @Test
    public void verifyTitle(){
        String expTitle = "Home Page";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expTitle,"Incorrect Title");
    }
}
