package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class SearchStepDefinitions {



    @Given("My first selenium smoke test")
    public void smokeSelenium() throws InterruptedException {

        System.out.println("hello world");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        Thread.sleep(10000);
        driver.close();
        driver.quit();

    }

    @Given("My first rest assured smoke test")
    public void smokeRestAssured() throws InterruptedException {


        //generate RestAssured Get Request
        Response response = SerenityRest.get("https://www.google.com");
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        String body = response.getBody().asString();
        System.out.println("Response body: " + body);
    }

}
