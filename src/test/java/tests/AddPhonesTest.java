package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddPhonesToCart;

public class AddPhonesTest extends TestBase{
    AddPhonesToCart add;

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
}
