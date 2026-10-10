package com.imran.qa.tests;

import com.imran.qa.base.BaseTest;
import com.imran.qa.base.DriverFactory;
import com.imran.qa.pages.InventoryPage;
import com.imran.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Valid user reaches the product list")
    public void validLogin() {
        InventoryPage inventory = new LoginPage(DriverFactory.get()).open().loginAs("standard_user", "secret_sauce");
        Assert.assertEquals(inventory.pageTitle(), "Products");
    }

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][] {
            {"locked_out_user", "secret_sauce", "Sorry, this user has been locked out."},
            {"standard_user", "wrong_password", "Username and password do not match"},
            {"", "", "Username is required"}
        };
    }

    @Test(dataProvider = "invalidLogins", description = "Invalid logins show the correct error")
    public void invalidLogin(String user, String pass, String expected) {
        LoginPage login = new LoginPage(DriverFactory.get()).open();
        login.loginAs(user, pass);
        Assert.assertTrue(login.errorMessage().contains(expected));
    }
}
