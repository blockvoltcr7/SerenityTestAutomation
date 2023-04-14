package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import starter.pages.LoginPage;
import starter.pages.ProductPage;

import java.io.IOException;
import java.net.URISyntaxException;


public class SearchStepDefinitions {



    @Given("My first selenium smoke test")
    public void smokeSelenium() throws InterruptedException {

        System.out.println("hello world");
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


    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;



    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {

        // Enter valid username and password and click the login button
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Navigate to the products page
        productPage = new ProductPage(driver);

    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Verify that the shopping cart badge is displayed
        String title = productPage.getProductsTitleText();
        System.out.println("Title: " + title);
        assert(!title.isEmpty());

        // Close the browser
        driver.close();
        driver.quit();

    }

}
