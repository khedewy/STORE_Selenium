package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private final WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    private final By userNameTxt = By.id("sign-username");
    private final By passwordTxt = By.id("sign-password");
    private final By signBtn = By.xpath("//button[@onclick='register()']");

    public void enterUserData(String  name, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userNameTxt)));
        driver.findElement(userNameTxt).sendKeys(name);
        driver.findElement(passwordTxt).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signBtn)));
        driver.findElement(signBtn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
