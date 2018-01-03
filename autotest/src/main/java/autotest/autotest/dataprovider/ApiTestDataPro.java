package autotest.autotest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import autotest.autotest.common.Init;
import autotest.autotest.enums.FileEnum;
import autotest.autotest.utils.ExcelUtil;

/**
 * @author 张大爷
 * @time 2017年12月28日 上午10:24:36
 * @mail 767580776@qq.com
 * @automation
 */
public class ApiTestDataPro {
	@DataProvider(name = "address")
	public static Object[][] addAddressData() throws IOException {
		return ExcelUtil.getTestDataMap(FileEnum.EXCEL_PATH.getExcelValue(), FileEnum.EXCEL_NAME.getExcelValue(),
				FileEnum.DATA_ADDRESS_SHEET.getExcelValue());
	}
	@DataProvider(name = "changeArea")
	public static Object[][] changeAreaData() throws IOException {
		return ExcelUtil.getTestDataMap(FileEnum.EXCEL_PATH.getExcelValue(), FileEnum.EXCEL_NAME.getExcelValue(),
				FileEnum.DATA_CHANGE_AREA_SHEET.getExcelValue());
	}
}
