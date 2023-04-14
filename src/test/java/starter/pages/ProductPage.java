package starter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ProductPage {

    private WebDriver driver;
    private By inventoryItem = By.className("inventory_item");
    private By productsTitle = By.className("title");
    private By shoppingCartLink = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInventoryItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> elements = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(inventoryItem));
        return elements;
    }

    public String getProductsTitleText() {
        WebElement element = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(productsTitle));
        return element.getText();
    }

    public void clickShoppingCartLink() {
        WebElement element = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        element.click();
    }
}
