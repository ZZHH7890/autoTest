package autotest.autotest.testcases.zzkgapi;

import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;

import org.apache.tools.ant.taskdefs.Sleep;
import org.testng.annotations.Test;

import autotest.autotest.dataprovider.ApiTestDataPro;
import autotest.autotest.enums.ApiEnum;
import autotest.autotest.testcases.BaseTestCase;
import autotest.autotest.utils.HttpUtil;
import autotest.autotest.utils.Log;
import io.restassured.response.Response;

public class ApiTest extends BaseTestCase {
	// 测试新增地址接口
	@Test(enabled = false, dataProvider = "address", dataProviderClass = ApiTestDataPro.class, groups = { "P1" })
	public void addAddress(String postData, String expectValue) throws IOException {
		Log.startTestCase("addAddress用例测试开始！");
		Response response = HttpUtil.httpRequest(ApiEnum.ADD_ADDRESS.getApiRow(), postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("addAddress测试结束！");
	}

	// 测试选择小区搜索
	@Test(enabled = false)
	public void searchArea() throws IOException {
		Log.startTestCase("searchArea用例测试开始！");
		Response response = HttpUtil.httpRequest(ApiEnum.SEARCH_AREA.getApiRow());
		response.prettyPrint();
		response.then().body("data[0].regionId", equalTo(813395));
		response.then().body("data[0].name", equalTo("东角山"));
		Log.endTestCase("searchArea测试结束！");
	}

	// 测试切换小区接口
	@Test(enabled = true, dataProvider = "changeArea", dataProviderClass = ApiTestDataPro.class, groups = { "P1" })
	public void changeArea(String postData, String expectValue) throws IOException, InterruptedException {
		Log.startTestCase("changeArea用例测试开始！");
		Response response = HttpUtil.httpRequest(ApiEnum.CHANGE_AREA.getApiRow(), postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("changeArea测试结束！");
	}

	
}
