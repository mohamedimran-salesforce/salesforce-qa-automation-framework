package com.imran.qa.tests;

import com.imran.qa.base.BaseTest;
import com.imran.qa.base.DriverFactory;
import com.imran.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(description = "Cart badge counts items added from the product list")
    public void cartBadgeMatchesItemsAdded() {
        String count = new LoginPage(DriverFactory.get()).open()
                .loginAs("standard_user", "secret_sauce")
                .addFirstItems(2)
                .cartCount();
        Assert.assertEquals(count, "2");
    }
}
