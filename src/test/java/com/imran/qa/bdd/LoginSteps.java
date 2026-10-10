package com.imran.qa.bdd;

import com.imran.qa.base.DriverFactory;
import com.imran.qa.pages.InventoryPage;
import com.imran.qa.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private LoginPage login;
    private InventoryPage inventory;

    @Before public void start() { DriverFactory.start(); }
    @After public void stop() { DriverFactory.stop(); }

    @Given("the login page is open")
    public void open() { login = new LoginPage(DriverFactory.get()).open(); }

    @When("the user logs in as {string} with password {string}")
    public void loginAs(String user, String pass) { inventory = login.loginAs(user, pass); }

    @Then("the product list is displayed")
    public void productList() { Assert.assertEquals(inventory.pageTitle(), "Products"); }

    @Then("the error message contains {string}")
    public void errorContains(String text) { Assert.assertTrue(login.errorMessage().contains(text)); }
}
