package com.imran.qa.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com.imran.qa.bdd",
        plugin = {"pretty", "html:target/cucumber-report.html"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {}
