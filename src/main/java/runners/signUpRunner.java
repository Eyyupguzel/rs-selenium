package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = {"src/test/java/Features/signUp.feature"} ,

                glue = {"stepDefinitions"},
                plugin = { "pretty", "junit:target/JUnitReports/report.xml",
                        "json:target/JSONReports/report.json",
                        "html:target/HtmlReports/report.html"},
                publish = true

        )


public class signUpRunner extends AbstractTestNGCucumberTests {




}
