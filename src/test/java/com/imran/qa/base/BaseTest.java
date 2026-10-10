package com.imran.qa.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() { DriverFactory.start(); }

    @AfterMethod(alwaysRun = true)
    public void tearDown() { DriverFactory.stop(); }
}
