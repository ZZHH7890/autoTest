package autotest.autotest.common;

/**
 * @author 张大爷
 * @time 2017年9月23日 上午12:14:50 Just a joke
 */

import org.apache.log4j.Logger;

public class Log {
	private static Logger log = Logger.getLogger(Log.class.getName());
	public static void startTestCase(String startTestCase) {
		log.info("-------------------------------------------------------------------------------------------");
		log.info("***********************"+startTestCase+"***********************");
	}
	
	public static void endTestCase(String endTestCase) {
		log.info("***********************"+endTestCase+ "*************************");
		log.info("-------------------------------------------------------------------------------------------");
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}
}
