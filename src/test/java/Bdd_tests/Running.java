package Bdd_tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/feature"}, plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = {"Lecture_22/steps"})
    public class Running extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }

