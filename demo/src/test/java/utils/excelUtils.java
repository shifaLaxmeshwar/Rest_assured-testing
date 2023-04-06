package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;


public class excelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public excelUtils(String excelPath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);
    }

    public void rowCount() throws IOException {

        int row = sheet.getPhysicalNumberOfRows();
    }

    public Object getCellData(int rowNum, int colNum) throws IOException {
        //String path = "./data/testData.xlsx";
        DataFormatter format = new DataFormatter();
        Object BookingData = format.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(BookingData);
        return BookingData;
    }
}
