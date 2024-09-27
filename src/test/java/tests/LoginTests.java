package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends TestBase {


    @Test
    public void verifyLogin() throws InterruptedException {
        String email = "pradeep.pp@gmail.com";
        String password = "Test#123";
        String fullName = "Automation Tester";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email,password,true,fullName);
    }
    @Test
    public void verifyTitle(){
        String expTitle = "Home Page";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expTitle,"Incorrect Title");
    }
}
