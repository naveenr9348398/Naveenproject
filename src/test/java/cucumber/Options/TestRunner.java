package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
 
@CucumberOptions(features = "C:\\Users\\navee\\eclipse-workspace\\Cucumber_API\\src\\test\\java\\com\\feature\\Googlemapsapi.feature"
,glue = "com.stepdefinition",plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner {

}
