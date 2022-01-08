package qaautomation.november2021;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qaautomation.november2021.utils.APIUtility;
import qaautomation.november2021.utils.DataUtility;

public class BaseAPITest {

	RequestSpecification commonJsonSpec = new RequestSpecBuilder()
			.setBaseUri(DataUtility.getDataFromExcel("config", "BaseUrlAPI")).setContentType(ContentType.JSON).build()
			.log().all();
	RequestSpecification loginJsonSpec;

	@BeforeMethod
	public void login() {
		String loginPayload = DataUtility.getDataFromExcel("Payloads", "LoginPayload");
		Response response = RestAssured.given().spec(commonJsonSpec).body(loginPayload).when().post("/users/sign_in");

		String token = APIUtility.getBodyDataUsingJsonPath(response, "user.authtoken");
		loginJsonSpec = new RequestSpecBuilder().setBaseUri(DataUtility.getDataFromExcel("config", "BaseUrlAPI"))
				.setContentType(ContentType.JSON).addHeader("authtoken", token).build().log().all();
	}

}
