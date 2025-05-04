package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "D:\\UrbanladderWeb\\src\\test\\resources\\home.feature",
        glue = {"homePage"},
        monochrome = true
)

public class runnerFile extends AbstractTestNGCucumberTests {
}
