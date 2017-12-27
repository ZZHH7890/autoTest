package autotest.autotest.common;

/**
 * @author 张大爷
 * @time 2017年12月27日 下午4:35:48
 * @mail 767580776@qq.com
 * @automation
 */
public enum ApiEnum {
	ADD_ADDRESS(5), DELETE_ADDRESS(6), ADDRESS_LIST(7);

	ApiEnum(int apiRow) {
		this.apiRow = apiRow;
	}

	int apiRow;

	public int getApiRow() {
		return apiRow;
	}

}
