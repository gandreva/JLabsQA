package qaautomation.november2021;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import qaautomation.november2021.utils.APIUtility;
import qaautomation.november2021.utils.DataUtility;

public class APITestAfterRefactor extends BaseAPITest {

	@Test
	public void dashboardAPI() {
		Response response = RestAssured.given().spec(loginJsonSpec).param("status", "completed").when()
				.get(DataUtility.getDataFromExcel("Path", "Dashboard"));
		APIUtility.verifyStatusCodeSuccess(response);
		response.then().assertThat()
				.body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "DashboardAPISchema")));
	}

	@Test
	public void configAPI() {
		Response response = RestAssured.given().spec(commonJsonSpec).when()
				.get(DataUtility.getDataFromExcel("Path", "Config"));
		APIUtility.verifyStatusCodeSuccess(response);
	}

	@Test
	public void fakerTest() {
		Faker faker = new Faker();
		System.out.println(faker.name().username() + "@gmail.com");
	}
}
