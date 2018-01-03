package autotest.autotest.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import autotest.autotest.interfaces.HandlerDBImp;
import autotest.autotest.utils.DBUtil;

/**
 * @author 张大爷
 * @time 2018年1月2日 下午2:48:58
 * @mail 767580776@qq.com
 * @automation
 */
public class HandlerDB implements HandlerDBImp {

	@Override
	public void clearTable(String tableName) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtil.getConnection();
			String sql = "truncate " + tableName;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByNo(String tableName, int no) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtil.getConnection();
			String sql = "delete from " + tableName + " where no =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, no);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
