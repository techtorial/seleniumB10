package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "step_definitions",
        plugin = {"json:target/rerun-report.json", "rerun:target/rerun.txt"}
)
public class RerunRunner {
}
