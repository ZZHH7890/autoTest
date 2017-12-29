package autotest.autotest.common;

import org.testng.annotations.BeforeMethod;

import autotest.autotest.utils.Log;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;

public class BaseTestCase {
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		try {
			DOMConfigurator.configure("log4j.xml");
			Log.info("！！！！！！！！本次测试开始！！！！！！！！");
			Init.initLog();
			Init.initToken();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.info("！！！！！初始化环境失败！！！！！！！！");
		}

	}

	@AfterClass
	public void afterClass() {
		try {
			//Init.clearAddress();
			Init.clearToken();
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("！！！！！！！清理测试环境失败！！！！！！！");
		}
		Log.info("！！！！！！！！本次测试结束！！！！！！！！");
	}

}
