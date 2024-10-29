package CommonJavaTest;
/* To get DataProvider method packing excel data into 2D array is essential */
/* Also try by providing hashMap as data provider*/
//(1)During taking an array you must have to mention length
//(2)how to convert an array to list 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import utility.overall.XLUtility;

public class PackingXLDataInA2DArray {
	static XLUtility xlUtil;

	public static void main(String[] args) throws IOException {
		String path= System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\KrishnaNormalTest.xlsx";
		
		String[][] strArray=pack(path);
		for(int i=0;i<strArray.length;i++) {
			for(int j=0;j<5;j++) {
				System.out.println(strArray[i][j]);
			}
		}
		//(2)
		String[] strarr2= new String[2];
		strarr2[0]= "0";
		strarr2[1]= "1";
		ArrayList<String> list= new ArrayList<>(Arrays.asList(strarr2));
		System.out.println(list);
		
		
	}
	
	public static String[][] pack(String path) throws IOException{
		xlUtil = new XLUtility(path);
		int rowCount=xlUtil.getRowCount("Sheet2");
		int cellCount=xlUtil.getCellCount("Sheet2", rowCount);
		String[][] strArray=new String[rowCount][cellCount+1];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<=cellCount;j++) {
				strArray[i-1][j]=xlUtil.getCellData("Sheet2", i, j);
			}
		}
		return strArray;
		
	}
	
	

}
