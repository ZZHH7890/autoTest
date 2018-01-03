package autotest.autotest.common;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import autotest.autotest.enums.ApiEnum;
import autotest.autotest.enums.FileEnum;
import autotest.autotest.utils.ExcelUtil;
import autotest.autotest.utils.HttpUtil;
import autotest.autotest.utils.Log;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author 张大爷
 * @time 2017年12月26日 下午2:52:45
 * @mail 767580776@qq.com
 * @automation
 */
public class Init {

	// 生成用户token
	public static String getToken() {
		try {
			Response response = given().contentType("application/json")
					.body("{\"phone\":" + Init.getEnvPro().getProperty("phone") + ",\"code\":"
							+ Init.getEnvPro().getProperty("code") + ",\"introducerCode\":\"\"}")
					.post(Init.getEnvPro().getProperty("host") + Init.getEnvPro().getProperty("loginApi"));
			Log.info("写入excel表格的token为：" + response.path("token").toString());
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
			ExcelUtil.setTokenToCell(FileEnum.EXCEL_PATH.getExcelValue(), FileEnum.EXCEL_NAME.getExcelValue(),
					FileEnum.EXCEL_API_SHEET.getExcelValue(), getToken());
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
			ExcelUtil.setTokenToCell(FileEnum.EXCEL_PATH.getExcelValue(), FileEnum.EXCEL_NAME.getExcelValue(),
					FileEnum.EXCEL_API_SHEET.getExcelValue(), "");
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
			Response response = HttpUtil.httpRequest(ApiEnum.ADDRESS_LIST.getApiRow());
			JsonPath jsonPath = new JsonPath(response.asString());
			ArrayList<Integer> addressIds = jsonPath.get("id");
			if (addressIds.size() != 0) {
				Iterator<Integer> iterator = addressIds.iterator();
				while (iterator.hasNext()) {
					String string = String.valueOf(iterator.next());
					HttpUtil.httpRequest(ApiEnum.DELETE_ADDRESS.getApiRow(), string);
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
			FileWriter fw = new FileWriter(FileEnum.LOG_FILE_PATH.getExcelValue(), false);
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
		File file = new File(FileEnum.ENV_FILE_PATH.getExcelValue());
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
