package autotest.autotest.testcases.zzkgapi;

import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import org.testng.annotations.Test;

import autotest.autotest.dataprovider.ApiTestDataPro;
import autotest.autotest.enums.ApiEnum;
import autotest.autotest.testcases.BaseTestCase;
import autotest.autotest.utils.HttpRequest;
import autotest.autotest.utils.Log;
import io.restassured.response.Response;

public class ApiTest extends BaseTestCase {
	// 测试新增地址接口
	@Test(enabled = false, dataProvider = "address", dataProviderClass = ApiTestDataPro.class, groups = { "P1" })
	public void addAddress(String postData, String expectValue) throws IOException {
		Log.startTestCase("addAddress用例测试开始！");
		Response response = HttpRequest.httpRequest(ApiEnum.ADD_ADDRESS.getApiRow(), postData);
		response.then().body("msg", equalTo(expectValue));
		Log.endTestCase("addAddress测试结束！");
	}
}
