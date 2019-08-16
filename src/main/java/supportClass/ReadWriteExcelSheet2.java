package supportClass;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadWriteExcelSheet2 {

    String xcelFilePath = "C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\resources\\";

    public void readFromXcel(String fileName, String sheetName) throws IOException {


        File file = new File(xcelFilePath + "\\" + fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = null;
        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtension = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx/xls file
        if (fileExtension.equals(".xlsx")) {

            //If it is xlsx file then create object of XSSFWorkbook class
            workbook = new XSSFWorkbook(fileInputStream);

        } else if (fileExtension.equals(".xls")) {

            //If it is xls file then create object of HSSFWorkbook class
            workbook = new HSSFWorkbook(fileInputStream);

        }
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 0; i < rowCount; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.println(row.getCell(j).getStringCellValue() + "||");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {


        //Create an object of ReadWriteExcelSheet class
        ReadWriteExcelSheet2 readWriteExcelSheet = new ReadWriteExcelSheet2();

        //Call read file method of the class to read data
        readWriteExcelSheet.readFromXcel("LoginInfo.xlsx", "Sheet1");

    }
}



