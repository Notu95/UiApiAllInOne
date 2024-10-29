package utility.api;
/* DataProvider is just method that returns value in 2D Array or in HashMap */

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utility.overall.XLUtility;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = /*  System.getProperty("user.dir") + */ "C:\\Users\\SOURAV\\OneDrive\\Desktop\\Userdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1");
        int colcount = xl.getCellCount("Sheet1", 1);

        String apidata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);
            }
        }

        return apidata;
    }

    @DataProvider(name = "UserName")
    public String[] getUserName() throws IOException {
        String path = System.getProperty("user.dir") + "/Userdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1");

        String[] usernames = new String[rownum];

        // Assuming usernames are in the first column (index 0)
        for (int i = 1; i <= rownum; i++) {
            usernames[i - 1] = xl.getCellData("Sheet1", i, 0);
        }

        return usernames;
    }
}
