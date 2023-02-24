package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProceedCheckoutPage {
    private final WebDriver driver;
    public ProceedCheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private final By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    private final By nameTXt = By.id("name");
    private final By CountryTxt = By.id("country");
    private final By cityTxt = By.id("city");
    private final By creditNumber = By.id("card");
    private final By monthTxt = By.id("month");
    private final By yearTxt = By.id("year");
    private final By submitBtn = By.xpath("//button[text()='Purchase']");
    private final By assertionMessage = By.xpath("//h2[text()='Thank you for your purchase!']");
    private final By completeCheckout = By.xpath("//button[text()='OK']");

    public void clickPlaceOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(placeOrderBtn)));
        driver.findElement(placeOrderBtn).click();
    }
    public void placeOrder(String name, String country, String city, String credit, String month, String year){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(nameTXt)));

        driver.findElement(nameTXt).sendKeys(name);
        driver.findElement(CountryTxt).sendKeys(country);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(creditNumber).sendKeys(credit);
        driver.findElement(monthTxt).sendKeys(month);
        driver.findElement(yearTxt).sendKeys(year);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitBtn)));
        driver.findElement(submitBtn).click();
    }

    public String getAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }

    public void setCompleteCheckout(){
        driver.findElement(completeCheckout).click();
    }
}
