package tests;

import data.SignInData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

import java.io.IOException;


public class SignInTest extends TestBase {
    HomePage home;
    SignInPage sign;

    @Test
    public void navigateToSignIn(){
        home = new HomePage(driver);
        home.navigateToSignIN();
    }

    @Test(priority = 1)
    public void enterUserData() throws IOException, ParseException {
        SignInData data = new SignInData(driver);
        data.UserData();
        sign = new SignInPage(driver);
        sign.enterUserData(data.userName, data.password);
    }
}
