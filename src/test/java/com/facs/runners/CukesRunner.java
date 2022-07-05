package com.facs.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "io.testproject.sdk.internal.reporting.extensions.cucumber.CucumberReporter"
        },
        features = "src/test/resources/features",
        glue = "com/facs/step_definitions",
        dryRun = false,
        tags = "@test"
)


public class CukesRunner {
}
