package autotest.autotest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetDemo extends base {
  @Test
  public void getDemoTest() {
	  String apiUrl = "http://release.thy360.com/v2/address";
		Response response = given().headers("region", "813395", "token", "98d6258a-3e23-4256-8cd6-a7a6375ee01c")
				.get(apiUrl);
		System.out.println(response.asString());
		response.getBody().prettyPrint();
  }
}
