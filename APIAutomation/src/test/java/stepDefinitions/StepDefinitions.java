package stepDefinitions;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Resources.APIResources;
import Resources.TestData;
import Resources.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class StepDefinitions extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	TestData data = new TestData();
    
	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {

		res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));

	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" request$")
	public void user_calls_with_request(String resource, String method) throws Throwable {
		APIResources postResource = APIResources.valueOf(resource);

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST"))

			response = res.when().post(postResource.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(postResource.getResource());

	}

	@Then("^the API call got sucess with status code (\\d+)$")
	public void the_API_call_got_sucess_with_status_code(int arg1) throws Throwable {

		assertEquals(response.getStatusCode(), 200);

	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String keyValue, String ExpectedValue) throws Throwable {
	
		
		assertEquals(getJsonPath(response, keyValue).toString(), ExpectedValue);

	}

	@Then("^verify place_Id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		String placeId = getJsonPath(response, "place_id");
		
		res = given().spec(requestSpecification()).queryParam("place_id", placeId);
		   user_calls_with_request(resource, "Get");
		   String actualName=getJsonPath(response,"name");
			  assertEquals(actualName,expectedName);
		    
				
	}
}
