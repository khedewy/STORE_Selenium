package tests;

import data.ContactUsData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;

public class ContactUsTest extends TestBase{
    HomePage home;
    ContactUsPage contact;;

    @Test
    public void navigateToContactUsPage(){
        home = new HomePage(driver);
        home.navigateToContactUsPage();
    }
    @Test(priority = 1)
    public void contactUs() throws IOException, ParseException {
        ContactUsData data = new ContactUsData(driver);
        data.UserData();
        contact = new ContactUsPage(driver);
        contact.SendMessage(data.email, data.userName, data.message);
    }
}
