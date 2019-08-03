import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				 features="C:\\Users\\USER\\eclipse-workspace\\Muja\\src\\test.feature",
				 glue= {"C:\\Users\\USER\\eclipse-workspace\\Muja\\src\\steps.java"},
				 dryRun=true,
				 tags= {"@Test"}
				)
public class runner {

}
