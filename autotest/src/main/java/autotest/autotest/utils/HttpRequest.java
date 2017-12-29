package autotest.autotest.utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import autotest.autotest.common.Init;
import autotest.autotest.enums.FileEnum;
import io.restassured.response.Response;

/**
 * @author 张大爷
 * @time 2017年12月27日 下午2:23:43
 * @mail 767580776@qq.com
 * @automation
 */
public class HttpRequest {
	// http请求
	public static Response httpRequest(int apiRow, String... postData) throws IOException {
		Log.startTestCase("开始调用httpRequest");
		Map<String, String> apiMap = HandlerExcel.getApiMap(FileEnum.EXCEL_PATH.getExcelValue(),
				FileEnum.EXCEL_NAME.getExcelValue(), FileEnum.EXCEL_API_SHEET.getExcelValue(), apiRow);
		Response response = null;
		switch (apiMap.get("requestMethod")) {
		case "post":
			response = given().contentType(apiMap.get("contentType")).header("token", apiMap.get("token"))
					.header("region", Init.getEnvPro().getProperty("region")).body(postData[0])
					.post(Init.getEnvPro().getProperty("host") + apiMap.get("api"));
			break;
		case "put":
			response = given().contentType(apiMap.get("contentType")).header("token", apiMap.get("token"))
					.header("region", Init.getEnvPro().getProperty("region")).body(postData[0])
					.put(Init.getEnvPro().getProperty("host") + apiMap.get("api"));
			break;
		case "get":
			response = given().contentType(apiMap.get("contentType")).header("token", apiMap.get("token"))
					.header("region", Init.getEnvPro().getProperty("region"))
					.get(Init.getEnvPro().getProperty("host") + apiMap.get("api"));
			break;
		case "delete":
			if (postData.length > 0) {
				Log.info("http delete method with parameter");
				response = given().contentType("application/json").header("token", apiMap.get("token"))
						.header("region", Init.getEnvPro().getProperty("region"))
						.delete(Init.getEnvPro().getProperty("host") + apiMap.get("api") + postData[0]);
			} else {
				Log.info("http delete method with no parameter");
				response = given().contentType("application/json").header("token", apiMap.get("token"))
						.header("region", Init.getEnvPro().getProperty("region"))
						.delete(Init.getEnvPro().getProperty("host") + apiMap.get("api"));
			}
			break;
		default:
			Log.info("请求方法无法识别, 请求失败");
			break;
		}

		if (response != null) {
			Log.info("测试接口返回：" + response.asString());
		} else {
			Log.info("接口" + apiMap.get("api") + "请求失败");
		}
		Log.endTestCase("结束调用httpRequest");
		return response;
	}
}
