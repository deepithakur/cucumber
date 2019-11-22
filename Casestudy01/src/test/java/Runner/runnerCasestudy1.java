package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"Feature\\casestudy.feature","Feature\\Shopping.feature"},   glue= {"Casestudy"},plugin= {"html:target/cucumber.html"})

public class runnerCasestudy1 {

}
