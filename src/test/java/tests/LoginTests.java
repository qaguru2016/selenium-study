package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void verifyLogin() throws InterruptedException {
        WebElement lnkSignIn = driver.findElement(By.linkText("Sign In"));
        lnkSignIn.click();
        driver.findElement(By.name("login[username]"))
                .sendKeys("pradeep.pp@gmail.com");
        driver.findElement(By.name("login[password]"))
                .sendKeys("Test#123");
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);
        String expWelcMsg = "Welcome, Automation Tester!";
        String actWelcMsg = driver.findElement(By.className("logged-in")).getText();
        Assert.assertEquals(actWelcMsg,expWelcMsg,"Login failed");
    }
    @Test
    public void verifyTitle(){
        String expTitle = "Home Page";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expTitle,"Incorrect Title");
    }
}
