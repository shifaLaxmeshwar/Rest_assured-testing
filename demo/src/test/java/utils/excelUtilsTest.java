package utils;

import java.io.IOException;

public class excelUtilsTest {
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/Shifa/Downloads/demo/demo/Data/testData.xlsx";
        String name = "Sheet1";
       // System.out.println(System.getProperty("user.dir"));
        excelUtils excel = new excelUtils(path,name);
        excel.rowCount();
        excel.getCellData(1,0);
        excel.getCellData(1,1);
        String BookingD[][] = new String[10][10];
        for(int i = 1 ; i <=10;i++){
            for(int j =0 ;j<=7;j++){
                BookingD[i-1][j]= (String) excel.getCellData( i , j);
            }
        }


    }





}
