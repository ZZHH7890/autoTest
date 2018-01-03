package autotest.autotest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.model.Log;

import autotest.autotest.common.Init;
import autotest.autotest.enums.FileEnum;
import autotest.autotest.utils.ExcelUtil;
import io.restassured.response.Response;

public class GetDemo extends base {
	@Test(enabled = false)
	public void getDemoTest() {
		String apiUrl = "http://release.thy360.com/v2/address";
		Response response = given().headers("region", Init.getEnvPro().getProperty("region"), "token",
				"e35145f6-d53e-41f4-901c-ccdc361b175c").get(apiUrl);
		autotest.autotest.utils.Log.info(response.asString());
		// response.getBody().prettyPrint();
	}

	@Test(enabled = true)
	public void searchAreaTest() throws IOException {
		Map<String, String> apiMap = ExcelUtil.getApiMap(FileEnum.EXCEL_PATH.getExcelValue(),
				FileEnum.EXCEL_NAME.getExcelValue(), FileEnum.EXCEL_API_SHEET.getExcelValue(), 25);
		String apiUrl = Init.getEnvPro().getProperty("host") + apiMap.get("api");
				//"http://release.thy360.com/ja/user/v3/od/region/villages/search/东角山?currentRegion=false&latitude=22.54605355&limit=20&longitude=114.02597366&page=1";
		Response response = given().headers("region", Init.getEnvPro().getProperty("region"), "token",
				"fea95893-4c02-4f5f-9b38-d6292d955f41").get(apiUrl);
		response.getBody().prettyPrint();
	}
}
