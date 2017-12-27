package autotest.autotest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.model.Log;

import autotest.autotest.common.Config;
import io.restassured.response.Response;

public class GetDemo extends base {
	@Test
	public void getDemoTest() {
		String apiUrl = "http://release.thy360.com/v2/address";
		Response response = given().headers("region", Config.getEnvPro().getProperty("region"), "token", "e35145f6-d53e-41f4-901c-ccdc361b175c")
				.get(apiUrl);
		autotest.autotest.common.Log.info(response.asString());
		// response.getBody().prettyPrint();
	}
	
}
