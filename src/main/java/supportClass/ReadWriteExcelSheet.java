package supportClass;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class ReadWriteExcelSheet {

    String xcelFilePath = "C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\resources\\";

    public void readFromXcel(String fileName, String sheetName) throws IOException {


        File file = new File(xcelFilePath + "\\" + fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = null;
        System.out.println("Workbook has" + workbook.getNumberOfSheets() + "Sheets");

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

    }
    public static void main(String[] args) throws IOException {


        //Create an object of ReadWriteExcelSheet class
        ReadWriteExcelSheet readWriteExcelSheet = new ReadWriteExcelSheet();

        //Call read file method of the class to read data
        readWriteExcelSheet.readFromXcel("LoginInfo.xlsx", "Sheet1");

    }
}



