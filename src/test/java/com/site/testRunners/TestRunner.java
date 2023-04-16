package com.site.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/site/features",
        glue = "stepDefinitions",
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
}
