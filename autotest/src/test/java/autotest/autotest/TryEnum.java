package autotest.autotest;

import org.apache.log4j.xml.DOMConfigurator;

import autotest.autotest.common.Init;

/**
 * @author 张大爷
 * @time 2017年12月27日 下午3:46:40
 * @mail 767580776@qq.com
 * @automation
 */
public class TryEnum {

	public static void main(String[] args) {
		DOMConfigurator.configure("log4j.xml");
		// TODO Auto-generated method stub
		System.out.println(ApiEnum.LOGIN.getApiRow());
		Init.initToken();
		
	}

}
