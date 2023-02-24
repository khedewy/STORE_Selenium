package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By signInButton = By.id("signin2");
    private final By loginButton = By.id("login2");
    private final By homeBtn = By.xpath("//a[@class='nav-link']");
    private final By contactUsBtn = By.xpath("//a[text()='Contact']");

    public SignInPage navigateToSignIN(){
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

    public LoginPage navigateToLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public void returnToHomePage(){
        driver.findElement(homeBtn).click();
    }

    public ContactUsPage navigateToContactUsPage(){
        driver.findElement(contactUsBtn).click();
        return new ContactUsPage(driver);
    }
}

