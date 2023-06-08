package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/Registration.feature"},
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports_contact.html"}
)
public class RegistrationRunner {
}
