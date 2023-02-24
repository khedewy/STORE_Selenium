package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private final WebDriver driver;
    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }
    private final By emailTxt = By.id("recipient-email");
    private final By nameTXt = By.id("recipient-name");
    private final By messageTxt = By.id("message-text");
    private final By sendMessageBtn = By.xpath("//button[text()='Send message']");

    public void SendMessage(String email,String name, String message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailTxt)));
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(nameTXt).sendKeys(name);
        driver.findElement(messageTxt).sendKeys(message);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(sendMessageBtn)));
        driver.findElement(sendMessageBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
