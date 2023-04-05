package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class SearchStepDefinitions {



    @Given("My first smoke test")
    public void smoke() throws InterruptedException {

        System.out.println("hello world");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        Thread.sleep(10000);
        driver.close();
        driver.quit();

    }

}
