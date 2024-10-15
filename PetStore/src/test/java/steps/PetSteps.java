package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PetSteps {

	public static Response response;

	@Given("set up the pet store end point")
	public void setUpEndpoint() {
		RestAssured.baseURI = "https://petstore.swagger.io/";
	}

	@Then("Place the get request for available pets")
	public void getRequest() {

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "v2/pet/findByStatus?status=available");

		ResponseBody body = response.getBody();
		body.prettyPrint();

		int statusCode = response.getStatusCode();
		System.out.println("Response status code is " + statusCode);

	}

	@Then("Post new available pet to the store")
	public void postRequest() {
		String request = "{\n" + "  \"id\": 0,\n" + "  \"category\": {\n" + "    \"id\": 0,\n"
				+ "    \"name\": \"string\"\n" + "  },\n" + "  \"name\": \"rocky\",\n" + "  \"photoUrls\": [\n"
				+ "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n" + "      \"id\": 0,\n"
				+ "      \"name\": \"string\"\n" + "    }\n" + "  ],\n" + "  \"status\": \"available\"\n" + "}";

		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");

		Response response = httpRequest.body(request).post("/v2/pet");

		int statusCode = response.getStatusCode();
		System.out.println("Response status code is " + statusCode);
		
	}

	
	 @Then("Update pet status to sold") public void updateStatus() {
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 httpRequest.header("Content-Type", "application/json");
	 
	 Response response = httpRequest.body("{ \"status\": \"sold\" }").patch(
	 "/v2/pet/9223372036854775807");
	 
	 int statusCode =response.getStatusCode();
	 System.out.println("Response status code is " +statusCode);
	 
	 }
	 
	@Then("Delete the pet")
	public void deletePet() {

		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");

		Response response = httpRequest.delete("/v2/pet/9223372036854775807");

		int statusCode = response.getStatusCode();
		System.out.println("Response status code is " + statusCode);
		
		ResponseBody body = response.getBody();
		body.prettyPrint();

	}
}
