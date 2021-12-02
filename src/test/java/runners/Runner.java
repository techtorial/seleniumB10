package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@smoketest",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"json:target/report.json", "rerun:target/rerun.txt"}
)
public class Runner {
}
