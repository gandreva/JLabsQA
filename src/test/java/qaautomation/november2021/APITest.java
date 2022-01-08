package qaautomation.november2021;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {

	String token = "";

	@Test(priority = 1)
	public void testLoginAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String loginPayload = "{\"email\":\"jogidemo321@gmail.com\",\"password\":\"builder123\"}";
		Response response = RestAssured.given().contentType("application/json").body(loginPayload).when()
				.post("/users/sign_in");
		assertEquals(response.getStatusCode(), 200);
		token = response.jsonPath().get("user.authtoken");
		System.out.println(token);
	}

	@Test(priority = 2)
	public void dashboardAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response response = RestAssured.given().contentType("application/json").header("authtoken", token).when()
				.get("build_cards?status=completed");
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3)
	public void userAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response response = RestAssured.given().contentType("application/json").header("authtoken", token).when()
				.get("/user");
		assertEquals(response.getStatusCode(), 200);
	}
}
