package autotest.autotest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import autotest.autotest.common.Init;

/**
 * @author 张大爷
 * @time 2018年1月2日 上午11:08:25
 * @mail 767580776@qq.com
 * @automation
 */
public class DBUtil {

	private static Connection conn = null;
	// 静态代码块（将加载驱动、连接数据库放入静态块中）
	static {
		try {
			// 1.加载驱动程序
			Class.forName(Init.getEnvPro().getProperty("MYSQL_DRIVER"));
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(Init.getEnvPro().getProperty("DB_URL"),
					Init.getEnvPro().getProperty("DB_USER"), Init.getEnvPro().getProperty("DB_PASS"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 对外提供一个方法来获取数据库连接
	public static Connection getConnection() {
		return conn;
	}
}
