package tests;

import data.PlaceOrderData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddPhonesToCart;
import pages.ProceedCheckoutPage;

import java.io.IOException;

public class ProceedCheckoutTest extends TestBase {
    AddPhonesToCart add;
    ProceedCheckoutPage checkout;

    @Test
    public void navigateToAddToCART(){
        add = new AddPhonesToCart(driver);
        add.navigateToAddToCart();
        Assert.assertEquals(add.getAssertionMessage(),"Samsung galaxy s6");
    }

    @Test(priority = 1)
    public void addToCART(){
        add = new AddPhonesToCart(driver);
        add.addProductToCart();
        Assert.assertEquals(add.assertProductAdded(),"360");
    }

    @Test(priority = 2)
    public void navigateToProceed(){
        checkout = new ProceedCheckoutPage(driver);
        checkout.clickPlaceOrder();
    }

    @Test(priority = 3)
    public void CompleteProceed() throws IOException, ParseException {
        PlaceOrderData data = new PlaceOrderData(driver);
        data.UserData();
        checkout = new ProceedCheckoutPage(driver);
        checkout.placeOrder(data.name, data.country, data.city, data.credit, data.month, data.year);
        Assert.assertEquals(checkout.getAssertionMessage(),"Thank you for your purchase!");
        checkout.setCompleteCheckout();
    }
}
