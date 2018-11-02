package ozon.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ozon"},
        tags = {"@cart"},
        snippets = SnippetType.CAMELCASE
        //,format = {"pretty", "html:output"}
)

public class CucumberTest {
}
