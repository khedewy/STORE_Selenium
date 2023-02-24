package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddLaptopsPage;

public class AddLaptopsToCart extends TestBase {
    AddLaptopsPage add;

    @Test
    public void navigateAddLaptopsToCART(){
        add = new AddLaptopsPage(driver);
        add.navigateToAddLaptopToCart();
        Assert.assertEquals(add.assertionMessage(),"MacBook air");
    }

    @Test(priority = 1)
    public void addLaptopsToCart(){
        add = new AddLaptopsPage(driver);
        add.addLaptopsToCart();
        Assert.assertEquals(add.getAssertionThatProductAdded(),"700");
    }
}
