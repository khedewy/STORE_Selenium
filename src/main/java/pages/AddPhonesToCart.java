package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPhonesToCart {
    private final WebDriver driver;
    public AddPhonesToCart(WebDriver driver){
        this.driver = driver;
    }

    private final By phonesBtn = By.xpath("//a[text()='Phones']");
    private final By samsungOption = By.linkText("Samsung galaxy s6");
    private final By samsungAssertionMessage = By.xpath("//h2[text()='Samsung galaxy s6']");
    private final By addToCartBtn = By.xpath("//a[text()='Add to cart']");
    private final By viewCartBtn = By.xpath("//a[text()='Cart']");
    private final By assertProductAdded = By.xpath("//h3[text()='360']");

    public void navigateToAddToCart(){
        driver.findElement(phonesBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(samsungOption).click();
    }

    public String getAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(samsungAssertionMessage)));
        return driver.findElement(samsungAssertionMessage).getText();
    }

    public void addProductToCart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToCartBtn)));
        driver.findElement(addToCartBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(viewCartBtn).click();
    }

    public String assertProductAdded(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertProductAdded)));
        return driver.findElement(assertProductAdded).getText();
    }
}
