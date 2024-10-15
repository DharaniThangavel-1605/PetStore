package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/PetStore.feature", glue="steps")

public class RunnerClass extends AbstractTestNGCucumberTests {
	
}
