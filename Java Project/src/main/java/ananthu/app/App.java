package ananthu.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;

import ananthu.choice.ChoicePanel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.json.simple.*;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static FileWriter file;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("SampleLogger");

        excelToDatabase();
        String str = null;
        while(!Objects.equals(str, "exit")){

            logger.log(Level.INFO,"Welcome to Student Directory\n 1.Search by Name\n 2.Search by Admission Number \n 3.Exit");
            logger.log(Level.INFO,"Enter your choice:");
            Scanner scanner = new Scanner(System.in);
            String ch = scanner.nextLine();
            ChoicePanel cp = new ChoicePanel();
            str = cp.choiceData(ch);

        }
    }

    public static void excelToDatabase() {
        String url = "jdbc:mysql://localhost:3306/mark";
        String username = "root";
        String password = "ananthu1231998";

        System.out.println("Connecting database...");
        ReadExcel rc = new ReadExcel();

        Workbook wbook = null;

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
        int row = sheet.getLastRowNum() + 1;


        JSONArray ja = new JSONArray();
      //  JSONArray myJsonObjects = new JSONArray();
        for (int i = 1; i < row; i++) {
            JSONObject obj = new JSONObject();
            obj.put("Name", rc.readcelldata(i, 0));
            obj.put("Admission No", rc.readadmdata(i, 1));
            obj.put("Physics", rc.readphydata(i, 2));
            obj.put("Chemistry", rc.readCheData(i, 3));
            obj.put("Maths", rc.readMathData(i, 4));

            //myJsonObjects.add(obj);

            ja.add(obj);
            try {

                // Constructs a FileWriter given a file name, using the platform's default charset
                file = new FileWriter("D:\\Downloads\\Java Project\\src\\main\\resources\\Json.txt");
                file.write(ja.toJSONString());


            } catch (IOException e) {
                e.printStackTrace();

            } finally {

                try {
                    file.flush();
                    file.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

                Statement statement = connection.createStatement();
                statement.executeUpdate("TRUNCATE TABLE marklist");
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO marklist values (?, ?, ?, ?, ? )");



            for (Object object : ja ){
                JSONObject record = (JSONObject) object;

                String name = (String) record.get("Name");

                int a = (Integer) record.get("Admission No");
                float b = (Float) record.get("Physics");
                float c = (Float) record.get("Chemistry");
                float d = (Float) record.get("Maths");

                pstmt.setString(2, name);
                pstmt.setInt(1, a);
                pstmt.setFloat(3, b);

                pstmt.setFloat(4, c);
                pstmt.setFloat(5, d);
                pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Exit the system");


        }
    }

}




