package autotest.autotest.enums;

/**
 * @author 张大爷
 * @time 2017年12月27日 下午4:35:48
 * @mail 767580776@qq.com
 * @automation
 */
public enum ApiEnum {
	ADD_ADDRESS(5), // 增加地址接口
	DELETE_ADDRESS(6), // 删除地址接口
	ADDRESS_LIST(7), // 获取地址列表接口
	SEARCH_AREA(25), // 搜索小区接口
	CHANGE_AREA(26),// 切换小区接口
	GET_AREA(27);// 获取小区列表接口
	ApiEnum(int apiRow) {
		this.apiRow = apiRow;
	}

	int apiRow;

	public int getApiRow() {
		return apiRow;
	}

}
