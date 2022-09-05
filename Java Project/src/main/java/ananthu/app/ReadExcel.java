package ananthu.app;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

class ReadExcel {

    //method defined for reading a cell
    public String readcelldata(int vRow, int vColumn) {
        String value = null; //variable for storing the cell value

        Workbook wbook = null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("D:\\Downloads\\Java Project\\src\\main\\resources\\Data.xlsx");
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wbook != null;
        Sheet sheet = wbook.getSheetAt(0);
        //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow);
        //returns the logical row
        Cell cell = row.getCell(vColumn);
        //getting the cell representing the given column

        if (vColumn == 0) {
            value = cell.getStringCellValue();
            //getting cell value

        }

        return value;

    }

    public int readadmdata(int vRow, int vColumn) {
        //variable for storing the cell value
        String valu;
        int intVal = 0;
        Workbook wbook = null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("D:\\Downloads\\Java Project\\src\\main\\resources\\Data.xlsx");
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wbook != null;
        Sheet sheet = wbook.getSheetAt(0);
        //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow);
        //returns the logical row
        Cell cell = row.getCell(vColumn);
        //getting the cell representing the given column

        //returns the cell value
        if (vColumn == 1) {
            valu = String.valueOf(cell.getNumericCellValue());

            intVal = Integer.parseInt(0 + valu.replaceAll("\\D+0", ""));


        }

        return intVal;

    }

    public float readphydata(int vRow, int vColumn) {
        float phyVal;
        String val;
        Workbook wbook = null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("D:\\Downloads\\Java Project\\src\\main\\resources\\Data.xlsx");
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wbook != null;
        Sheet sheet = wbook.getSheetAt(0);
        //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow);
        //returns the logical row

        //getting the cell representing the given column


        Cell cell = row.getCell(vColumn);
        val = String.valueOf(cell.getNumericCellValue());
        phyVal = Float.parseFloat(val);
        //getting cell value


        return phyVal;


    }

    public float readCheData(int vRow, int vColumn) {
        float cheVal;
        String val;
        Workbook wbook = null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("D:\\Downloads\\Java Project\\src\\main\\resources\\Data.xlsx");
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wbook != null;
        Sheet sheet = wbook.getSheetAt(0);
        //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow);
        //returns the logical row

        //getting the cell representing the given column


        Cell cell = row.getCell(vColumn);
        val = String.valueOf(cell.getNumericCellValue());
        cheVal = Float.parseFloat(val);
        //getting cell value


        return cheVal;


    }

    public float readMathData(int vRow, int vColumn) {
        float mathVal;
        String val;
        Workbook wbook = null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("D:\\Downloads\\Java Project\\src\\main\\resources\\Data.xlsx");
            //creates an XSSFWorkbook object by buffering the whole stream into the memory
            wbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = wbook.getSheetAt(0);
        //getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow);
        //returns the logical row

        //getting the cell representing the given column


        Cell cell = row.getCell(vColumn);
        val = String.valueOf(cell.getNumericCellValue());
        mathVal = Float.parseFloat(val);
        //getting cell value


        return mathVal;


    }
}
