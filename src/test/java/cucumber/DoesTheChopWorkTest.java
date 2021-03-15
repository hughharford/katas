package cucumber;

import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.posco.codekata.KarateChop;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static java.util.Arrays.asList;


public class DoesTheChopWorkTest {

	private int sortedArray;
	private int expectedIndex;
	private int foundIndex;

	@Given("the sorted integer {int}")
	public void the_sorted_integer(Integer numberAsString) throws Throwable {
		this.sortedArray = numberAsString;
	}

	@When("the array is checked for the {int}")
	public void when(int target) throws Throwable {

		KarateChop chopper = new KarateChop();
		foundIndex = chopper.chop(target, sortedArray);
		foundIndex = -1;
	}
	
	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {

		//Write the code to handle Data Table
		// List<List<String>> data = usercredentials.raw();
		List<List<String>> data = usercredentials.asLists();
				
		
		System.out.println("First Row + 1st Column: " + data.get(0).get(0));
		System.out.println("First Row + 2nd Column: " + data.get(0).get(1));

		//This is to get the first data of the set (First Row + First Column)
		// driver.findElement(By.id("log")).sendKeys(data.get(0).get(0)); 
		// driver is for a firefox driver...
		
		//This is to get the first data of the set (First Row + Second Column)
		// driver.findElement(By.id("pwd")).sendKeys(data.get(0).get(1));

		// driver.findElement(By.id("login")).click();
	}

	@Then("the {int} should be returned")
	public void then(int index) throws Throwable {
		this.expectedIndex = index;
		assertEquals(expectedIndex, foundIndex);
	}



}
