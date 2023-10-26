



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/java/features",
        glue = {"steps"}
)

public class RunnerTest {
}
