package api.api_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "api/api_step_defs",
        dryRun = false,
        tags = "@football"
)
public class ApiRunner {
}