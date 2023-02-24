package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddLaptopsPage;
import pages.AddPhonesToCart;
import pages.HomePage;

public class AddTowProductsTCart extends TestBase{
    AddPhonesToCart add;
    AddLaptopsPage addLaptops;
    HomePage home;

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
        home = new HomePage(driver);
        home.returnToHomePage();
    }
    @Test(priority = 2)
    public void navigateAddLaptopsToCART(){
        addLaptops = new AddLaptopsPage(driver);
        addLaptops.navigateToAddLaptopToCart();
        Assert.assertEquals(addLaptops.assertionMessage(),"MacBook air");
    }

    @Test(priority = 3)
    public void addLaptopsToCart(){
        addLaptops = new AddLaptopsPage(driver);
        addLaptops.addLaptopsToCart();
        Assert.assertEquals(addLaptops.towProductAssertion(),"1060");
    }
}
