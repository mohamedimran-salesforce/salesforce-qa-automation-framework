# Salesforce QA Automation Framework

A Selenium, Java, TestNG, Cucumber and RestAssured framework built with the Page Object Model. It runs on every push through GitHub Actions and publishes an HTML test report to GitHub Pages.

Targets are public practice systems, so no client data is involved:
- UI: [saucedemo.com](https://www.saucedemo.com/)
- API: [jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com/)

## What it covers
| Layer | Tooling | Tests |
| :--- | :--- | :--- |
| UI, Page Object Model | Selenium WebDriver, TestNG | Valid login, three data-driven invalid logins, cart badge count |
| API | RestAssured | GET single, GET list, POST create, 404 handling |
| BDD | Cucumber | Login scenarios in plain English |
| CI and reporting | GitHub Actions, Surefire report, GitHub Pages | Run on push, publish report |

## Run locally
```
mvn test                      # headless Chrome
mvn test -Dheadless=false     # visible browser
mvn surefire-report:report    # HTML report in target/site
```
Requires Java 17, Maven and Chrome.

## Structure
```
src/test/java/com/imran/qa
  base/    DriverFactory, BaseTest
  pages/   LoginPage, InventoryPage
  tests/   LoginTests, CartTests, ApiTests
  bdd/     Cucumber runner and step definitions
src/test/resources/features   Gherkin scenarios
```

## Salesforce extension
Salesforce UI tests run against a Developer Edition org, with the login stored as a GitHub Actions secret. Not included yet.
