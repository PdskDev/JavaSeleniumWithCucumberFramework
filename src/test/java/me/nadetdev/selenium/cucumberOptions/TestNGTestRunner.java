package me.nadetdev.selenium.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/java/me/nadetdev/selenium/features"},
        glue = {"me.nadetdev.selenium.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {}
