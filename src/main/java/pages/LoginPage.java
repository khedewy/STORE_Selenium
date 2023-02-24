package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By userNameTxt = By.id("loginusername");
    private final By passwordTxt = By.id("loginpassword");
    private final By loginBtn = By.xpath("//button[@onclick='logIn()']");
    private final By assertionMessage = By.xpath("//a[@class='nav-link' and @id='nameofuser']");

    public void enterLoginData(String name, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userNameTxt)));
        driver.findElement(userNameTxt).sendKeys(name);
        driver.findElement(passwordTxt).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginBtn)));
        driver.findElement(loginBtn).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
