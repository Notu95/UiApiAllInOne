package utility.overall;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
    
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;

    // Constructor to initialize the file path
    public XLUtility(String path) {
        this.path = path;
    }

    // Method to get the row count of a sheet
    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }

    // Method to get the cell count in a specific row
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    // Method to get data from a specific cell
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        String data;
        try {
            data = cell.getStringCellValue();
        } catch (Exception e) {
            data = "";  // Handle cases where the cell might be empty
        }
        workbook.close();
        fi.close();
        return data;
    }

    // Method to set data in a specific cell
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);  // Create a new row if it doesn't exist
        }

        cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);  // Create a new cell if it doesn't exist
        }

        cell.setCellValue(data);  // Set the value

        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fo.close();
        fi.close();
    }
    
 // Method to set the cell background color to green
    public void setCellGreen(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);  // Create the row if it doesn't exist
        }

        cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);  // Create the cell if it doesn't exist
        }

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

    // Method to set the cell background color to red
    public void setCellRed(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);  // Create the row if it doesn't exist
        }

        cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);  // Create the cell if it doesn't exist
        }

        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}

//how to call this utility class methods

/*
XLUtility xlUtil = new XLUtility("path/to/excel/file.xlsx");

// Get the row count
int rowCount = xlUtil.getRowCount("Sheet1");

// Get data from a specific cell
String cellData = xlUtil.getCellData("Sheet1", 0, 1);

// Set data in a specific cell
xlUtil.setCellData("Sheet1", 1, 1, "New Value");

// Set the cell background to green
xlUtil.setCellGreen("Sheet1", 1, 1);

// Set the cell background to red
xlUtil.setCellRed("Sheet1", 2, 1);


*/