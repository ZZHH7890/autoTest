package autotest.autotest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import autotest.autotest.common.Config;
import io.restassured.response.Response;

public class postDemo extends base {
	@Test(enabled = false)
	public void addAddress() {
		String apiUrl = "http://release.thy360.com/v3/setting/address";
		Response response = given().contentType("application/json")
				.header("token", "e35145f6-d53e-41f4-901c-ccdc361b175c")
				.header("region", Config.getEnvPro().getProperty("region"))
				.body("{\"contact\":\"大爷134\",\"phone\":13414672775,\"gender\":1,\"regionId\":813395,\"latitude\":22.408965,\"longitude\":113.826119,\"room1\":\"1123Az\",\"village\":\"东角山\",\"city1\":\"深圳\",\"addressNaviId\":18039,\"building\":\"自动化测试楼栋C栋（勿删）\",\"addressBuildingId\":256}")
				.post(apiUrl);
		autotest.autotest.common.Log.info(response.asString());
		// response.getBody().prettyPrint();
	}

	@Test(enabled = true)
	public void login() {
		String apiUrl = Config.getEnvPro().getProperty("loginApi");
		Response response = given().contentType("application/json")
				.body("{\"phone\":" + Config.getEnvPro().getProperty("phone") + ",\"code\":" + Config.getEnvPro().getProperty("code") + ",\"introducerCode\":\"\"}").post(apiUrl);

		autotest.autotest.common.Log.info(response.path("token").toString());
	}

}
