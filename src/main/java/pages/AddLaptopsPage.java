package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddLaptopsPage {
    private final WebDriver driver;
    public AddLaptopsPage(WebDriver driver){
        this.driver = driver;
    }
    private final By Laptops = By.xpath("//a[text()='Laptops']");
    private final By laptopsOption = By.linkText("MacBook air");
    private final By laptopsAssertion = By.xpath("//h2[text()='MacBook air']");
    private final By addToCartBtn = By.xpath("//a[text()='Add to cart']");
    private final By viewCartBtn = By.xpath("//a[text()='Cart']");
    private final By assertProductAdded = By.xpath("//h3[text()='700']");
    private final By TowProductAssertion = By.xpath("//h3[text()='1060']");

    public void navigateToAddLaptopToCart(){
        driver.findElement(Laptops).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(laptopsOption).click();
    }

    public String assertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(laptopsAssertion)));
        return driver.findElement(laptopsAssertion).getText();
    }

    public void addLaptopsToCart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToCartBtn)));
        driver.findElement(addToCartBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(viewCartBtn).click();
    }

    public String getAssertionThatProductAdded(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertProductAdded)));
        return driver.findElement(assertProductAdded).getText();
    }

    public String towProductAssertion(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(TowProductAssertion)));
        return driver.findElement(TowProductAssertion).getText();
    }
}
