package com.cyberteckschool.library2.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/library2/step_definitions",
        tags = "@Scenario_Outline",
        dryRun = true






)
public class Runner {

}

