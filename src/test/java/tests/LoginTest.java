package tests;

import data.LoginData;
import data.SignInData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignInPage;

import java.io.IOException;


public class LoginTest extends TestBase{
    HomePage home;
    SignInPage sign;
    LoginPage log;

    @Test
    public void navigateToSignIn(){
        home = new HomePage(driver);
        home.navigateToSignIN();
    }

    @Test(priority = 1)
    public void enterUserData() throws IOException, ParseException {
        LoginData data = new LoginData(driver);
        data.UserData();
        sign = new SignInPage(driver);
        sign.enterUserData(data.userName, data.password);
    }

    @Test(priority = 2)
    public void navigateToLogin(){
        home = new HomePage(driver);
        home.navigateToLogin();
    }

    @Test(priority = 3)
    public void EnterLoginData() throws IOException, ParseException, InterruptedException {
        LoginData data = new LoginData(driver);
        data.UserData();
        log = new LoginPage(driver);
        log.enterLoginData(data.userName, data.password);
        Thread.sleep(3000);
        Assert.assertEquals(log.getAssertionMessage(),"Welcome MahmoudKhedewy19079");
    }
}
