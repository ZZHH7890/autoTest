package autotest.autotest.common;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author 张大爷
 * @time 2017年12月26日 下午2:52:45
 * @mail 767580776@qq.com
 * @automation
 */
public class Config {

	// excel表格路径
	public static final String EXCEL_PATH = "C:\\Users\\Administrator\\eclipse-workspace\\\\autoTest\\\\autotest\\TestData";
	// excel表格名字
	public static final String EXCEL_NAME = "testData.xlsx";

	// excel表格config信息所在sheet
	public static final String EXCEL_TEST_SHEET = "test";
	// excel表格config信息所在sheet
	public static final String EXCEL_CONFIG_SHEET = "config";
	// excel表格接口信息所在sheet
	public static final String EXCEL_API_SHEET = "api";
	// excel表格地址接口测试数据所在sheet
	public static final String DATA_LOGIN_SHEET = "login";
	// excel表格地址接口测试数据所在sheet
	public static final String DATA_ADDRESS_SHEET = "address";
	// excel表格添加商品到购物车接口测试数据所在sheet
	public static final String DATA_BUY_SHEET = "buyprocess";
	// 日志存放的路径
	public static final String LOG_FILE_PATH = "C:\\Users\\Administrator\\eclipse-workspace\\autoTest\\autoTest\\log\\logfile.log";

	// 生成用户token
	public static String getToken() {
		try {
			Response response = given().contentType("application/json")
					.body("{\"phone\":" + Config.getEnvPro().getProperty("phone") + ",\"code\":"
							+ Config.getEnvPro().getProperty("code") + ",\"introducerCode\":\"\"}")
					.post(Config.getEnvPro().getProperty("host") + Config.getEnvPro().getProperty("loginApi"));
			Log.info(response.path("token").toString());
			return response.path("token");
		} catch (Exception e) {
			String failString = "获取用户token执行失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 用户token写入excel
	public static void initToken() {
		try {
			HandlerExcel.setTokenToCell(EXCEL_PATH, EXCEL_NAME, EXCEL_API_SHEET, getToken());
			String succString = "用户token写入excel成功！";
			Log.info(succString);
		} catch (Exception e) {
			String failString = "用户token写入excel失败！";
			Log.info(failString);
		}
	}

	// 清空用户token
	public static void clearToken() {
		try {
			HandlerExcel.setTokenToCell(EXCEL_PATH, EXCEL_NAME, EXCEL_API_SHEET, "");
			String succString = "清空用户token成功！";
			Log.info(succString);
		} catch (Exception e) {
			String failString = "清空用户token失败！";
			Log.info(failString);
		}
	}

	// 清空购物车
	public static void clearCart() {
		try {

			Log.info("清空购物车成功：");
		} catch (Exception e) {
			String failString = "清空购物车失败！";
			Log.info(failString);
		}
	}

	// 清空用户地址
	public static void clearAddress() {
		try {
			Response response = HttpRequest.httpRequest(ApiEnum.ADDRESS_LIST.getApiRow());
			JsonPath jsonPath = new JsonPath(response.asString());
			ArrayList<Integer> addressIds = jsonPath.get("id");
			if (addressIds.size() != 0) {
				Iterator<Integer> iterator = addressIds.iterator();
				while (iterator.hasNext()) {
					String string = String.valueOf(iterator.next());
					HttpRequest.httpRequest(ApiEnum.DELETE_ADDRESS.getApiRow(), string);
				}
				Log.info("清空用户地址成功");
			} else {
				Log.info("用户没有地址，不需要清空地址操作!");
			}

		} catch (Exception e) {
			String failString = "清空购物车失败！";
			Log.info(failString);
		}
	}

	// 清空日志
	public static void initLog() {
		try {
			FileWriter fw = new FileWriter(LOG_FILE_PATH, false);
			fw.write("");
			fw.flush();
			fw.close();
			String successString = "清空日志成功！";
			Log.info(successString);
		} catch (Exception e) {
			String failString = "清空日志失败！";
			Log.info(failString);
		}
	}

	// 获取环境配置文件信息env.properties
	public static Properties getEnvPro() {
		Properties pro = new Properties();
		File file = new File("C:\\Users\\Administrator\\eclipse-workspace\\autoTest\\autotest\\env.properties");
		try {
			if (file.exists()) {
				pro.load(new FileInputStream(file));
			} else {
				pro.setProperty("host", "http://release.thy360.com");
				pro.setProperty("region", "813395");
				pro.setProperty("phone", "13714672776");
				pro.setProperty("code", "1234");
				pro.setProperty("introducerCode", "13714672770");
				pro.store(new FileOutputStream(file), "ENV CLASS");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pro;
	}
}
