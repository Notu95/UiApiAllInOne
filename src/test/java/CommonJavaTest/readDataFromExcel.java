package CommonJavaTest;
/* Count starts from 0 for both row and cell */

import java.io.IOException;

import utility.overall.XLUtility;

public class readDataFromExcel {
	static XLUtility xlUtil;

	public static void main(String[] args) throws IOException {
		xlUtil = new XLUtility(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\KrishnaNormalTest.xlsx");
		int rowCount= xlUtil.getRowCount("Sheet2");
		int cellCount=xlUtil.getCellCount("Sheet2", rowCount);
		String str=xlUtil.getCellData("Sheet2", rowCount, cellCount-1);
		/* Count starts from 0 for both row and cell */
		String str1=xlUtil.getCellData("Sheet2", 0, 0);
		
		System.out.println(rowCount);
		System.out.println(cellCount);
		System.out.println(str);
		System.out.println(str1);
		

	}

}
