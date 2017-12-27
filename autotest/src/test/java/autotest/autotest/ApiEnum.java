package autotest.autotest;
/**
*@author 张大爷
*@time 2017年12月27日 下午3:47:50
*@mail 767580776@qq.com
*@automation
*/
public enum ApiEnum {
	LOGIN(2), CLEAR_CART(3);

	int apiRow;
	ApiEnum(int apiRow) {  
        this.apiRow = apiRow;  
    }  
      
    public int getApiRow() {  
        return apiRow;  
    }  
	
}
