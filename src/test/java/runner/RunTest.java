package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@login",
        glue = {"step_definitions","hooks"},
        features = {
                "classpath:cucumber"
        },
        format = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/junit.xml"}
//        dryRun = true
)

public class RunTest extends AbstractTestNGCucumberTests {
}
