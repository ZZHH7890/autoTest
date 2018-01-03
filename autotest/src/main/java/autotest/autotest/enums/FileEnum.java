package autotest.autotest.enums;

/**
 * @author 张大爷
 * @time 2017年12月29日 上午10:16:43
 * @mail 767580776@qq.com
 * @automation
 */
public enum FileEnum {
	
	ENV_FILE_PATH("C:\\Users\\Administrator\\eclipse-workspace\\autoTest\\autotest\\env.properties"),//环境配置信息的路径
	
	LOG_FILE_PATH("C:\\Users\\Administrator\\eclipse-workspace\\autoTest\\autoTest\\log\\logfile.log"),// 日志所在的路径
	
	EXCEL_PATH("C:\\Users\\Administrator\\eclipse-workspace\\autoTest\\autotest\\TestData"), // 表格所在的路径
	
	EXCEL_NAME("testData.xlsx"), // 表格名字
	
	EXCEL_API_SHEET("api"), // 接口所在的sheet
	
	DATA_ADDRESS_SHEET("address"),// 地址接口测试数据所在的sheet
	
	DATA_CHANGE_AREA_SHEET("changeArea");// 切换小区接口测试数据所在的sheet

	private FileEnum(String excelValue) {
		// TODO Auto-generated constructor stub
		this.excelValue = excelValue;
	}

	String excelValue;

	public String getExcelValue() {
		return excelValue;
	}

}
