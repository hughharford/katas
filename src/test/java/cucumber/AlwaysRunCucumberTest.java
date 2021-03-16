package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith( Cucumber.class )
@CucumberOptions(
  				features = "src/test/java/cucumber/AddTwoHugeNumbers.feature"
  				, publish = false
  				// "src/test/java/cucumber/IsListAPalindrome.feature"
  				// "src/test/java/cucumber/RemoveKfromList.feature"
  				// "src/test/java/cucumber/RotateImage.feature"
				
  				// , glue= {"src/test/java/cucumbersteps"}
  				
  				// this GLUE did not work, with the result that
  				// the runner, all the features, and test steps are all in 1 package
				)


public class AlwaysRunCucumberTest
{
  //[...]
}


