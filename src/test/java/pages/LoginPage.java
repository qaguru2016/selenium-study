package pages;

import lib.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends PageBase {
    //Locators
    private By lnkSignIn = By.linkText("Sign In");
    private By txtEmail = By.name("login[username]");
    private By txtPassword = By.name("login[password]");
    private By btnSignIn  = By.id("send2");
    private By lblWelcome = By.className("logged-in");

    public LoginPage(WebDriver driver) {
        super.driver = driver;
    }
    public void login(String email, String password){
        click(lnkSignIn);
        sendKeys(txtEmail,email);
        sendKeys(txtPassword,password);
        click(btnSignIn);
    }

    public void loginWithValidCredentials(String email, String password, String fullName)
            throws InterruptedException {
        login(email,password);
        String expWelcMsg = "Welcome, " +fullName+ "!";
        Assert.assertTrue(isTextPresent(expWelcMsg),"User not logged in");

    }
}
