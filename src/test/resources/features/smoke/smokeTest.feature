Feature: Smoke tests

  @smoke
  Scenario: Smoke test Selenium

    Given My first selenium smoke test

  Scenario: smoke test Rest Assured

    Given My first rest assured smoke test


  Scenario: smoke test HTTP Client

    Given My first HTTP Client smoke test


    @debug2384792
  Scenario: Login to swag labs

    Given I am on the login page
    When I login with valid credentials
    Then I should be logged in