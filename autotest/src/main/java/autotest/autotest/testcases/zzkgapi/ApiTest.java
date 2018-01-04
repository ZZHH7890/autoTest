package autotest.autotest.testcases.zzkgapi;

import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import org.testng.annotations.Test;
import autotest.autotest.dataprovider.ApiTestDataPro;
import autotest.autotest.enums.ApiEnum;
import autotest.autotest.testcases.BaseTestCase;
import autotest.autotest.utils.HttpUtil;
import autotest.autotest.utils.Log;
import io.restassured.response.Response;

public class ApiTest extends BaseTestCase {
	/*
	 * 测试新增地址接口 验证新增地址接口返回msg
	 */
	@Test(enabled = true, dataProvider = "address", dataProviderClass = ApiTestDataPro.class, groups = { "P1" })
	public void addAddress(String postData, String expectValue) throws IOException {
		Log.startTestCase("addAddress用例测试开始！");
		Response response = HttpUtil.httpRequest(ApiEnum.ADD_ADDRESS.getApiRow(), postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("addAddress测试结束！");
	}

	/*
	 * 测试选择小区搜索接口 验证接口返回社区id 验证接口返回社区名字
	 */
	@Test(enabled = true)
	public void searchArea() throws IOException {
		Log.startTestCase("searchArea用例测试开始！");
		Response response = HttpUtil.httpRequest(ApiEnum.SEARCH_AREA.getApiRow());
		response.prettyPrint();
		response.then().body("data[0].regionId", equalTo(813395));
		response.then().body("data[0].name", equalTo("东角山"));
		Log.endTestCase("searchArea测试结束！");
	}

	/*
	 * 测试切换小区接口 验证接口返回msg
	 * 
	 */
	@Test(enabled = true, dataProvider = "changeArea", dataProviderClass = ApiTestDataPro.class, groups = { "P1" })
	public void changeArea(String postData, String expectValue) throws IOException, InterruptedException {
		Log.startTestCase("changeArea用例测试开始！");
		Response response = HttpUtil.httpRequest(ApiEnum.CHANGE_AREA.getApiRow(), postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("changeArea测试结束！");
	}

	/*
	 * 测试获取小区接口 验证同社区下不同花园，只显示一个，依赖于changeArea测试结果
	 */
	@Test(enabled = true, dependsOnMethods = { "changeArea" }, groups = { "P1" })
	public void getArea() throws IOException, InterruptedException {
		Log.startTestCase("changeArea用例测试开始！");
		Response response = HttpUtil.httpRequest(ApiEnum.GET_AREA.getApiRow());
		response.then().body("data[0].name", equalTo("东角山"));
		Log.endTestCase("changeArea测试结束！");
	}

}
