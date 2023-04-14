package starter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {


    private WebDriver driver;
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement element = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(usernameInput));
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(passwordInput));
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement element = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        element.click();
    }

}
