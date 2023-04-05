package starter.stepdefinitions;


import io.cucumber.java.en.Given;


public class SearchStepDefinitions {

    @Given("My first smoke test")
    public void smoke() {
        System.out.println("hello world");
    }

}
