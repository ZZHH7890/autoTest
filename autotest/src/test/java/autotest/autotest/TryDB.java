package autotest.autotest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import autotest.autotest.common.HandlerDB;
import autotest.autotest.utils.DBUtil;

public class TryDB {
	@Test(enabled = false)
	public void A() throws SQLException {
		Connection connection = DBUtil.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from tom where no = '2'");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("no") + ", " + resultSet.getString("name"));
		}
		statement.close();
		resultSet.close();
		connection.close();
	}
	
	@Test(enabled = true)
	public void B() throws SQLException {
		HandlerDB handlerDB = new HandlerDB();
		handlerDB.clearTable("tom");			
	}
	
	@Test(enabled = false)
	public void C() throws SQLException {
		HandlerDB handlerDB = new HandlerDB();
		handlerDB.deleteByNo("tom", 2);		
	}
}
