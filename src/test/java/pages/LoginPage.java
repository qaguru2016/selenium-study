package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    //Locators
    private By lnkSignIn = By.linkText("Sign In");
    private By txtEmail = By.name("login[username]");
    private By txtPassword = By.name("login[password]");
    private By btnSignIn  = By.id("send2");
    private By lblWelcome = By.className("logged-in");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email,String password,boolean validCredential,String fullName)
            throws InterruptedException {

        WebElement signInLink = driver.findElement(lnkSignIn);
        signInLink.click();
        driver.findElement(txtEmail)
                .sendKeys(email);
        driver.findElement(txtPassword)
                .sendKeys(password);
        driver.findElement(btnSignIn).click();
        Thread.sleep(3000);
        if(validCredential) {
            String expWelcMsg = "Welcome, " +fullName+ "!";
            String actWelcMsg = driver.findElement(lblWelcome).getText();
            Assert.assertEquals(actWelcMsg, expWelcMsg, "Login failed");
        }
    }
}
