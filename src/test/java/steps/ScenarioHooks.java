package steps;



import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Util;

public class ScenarioHooks extends Util{

    private static String currentScenarioName;

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();
        if (!scenarioName.equals(currentScenarioName)) {
            currentScenarioName = scenarioName;
            logger.warn("=========="+scenarioName+"==========");
        }
    }
}
