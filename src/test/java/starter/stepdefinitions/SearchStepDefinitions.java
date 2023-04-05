package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.net.URISyntaxException;


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

    @Given("My first HTTP Client smoke test")
    public void smokeHTTPClient() throws InterruptedException, URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder("https://www.google.com");
        HttpGet request = new HttpGet(uriBuilder.build());
        request.addHeader("Content-Type", "application/json");

        httpClient.execute(request, response -> {
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Status code: " + statusCode);
            String body = EntityUtils.toString(response.getEntity());
            System.out.println("Response body: " + body);
            return body;
        });
    }

}
