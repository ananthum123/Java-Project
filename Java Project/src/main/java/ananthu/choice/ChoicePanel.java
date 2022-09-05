package ananthu.choice;

import ananthu.mark.Grade;
import ananthu.mark.GradePoint;
import ananthu.mark.TotalPerc;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.sql.*;
import java.util.Scanner;

public class ChoicePanel {


  public   String choiceData(String ch){
        String choice = null;
        String url = "jdbc:mysql://localhost:3306/mark";
        String username = "root";
        String password = "ananthu1231998";
        PreparedStatement p;
        ResultSet rs;

      switch (ch) {
            case "1":

                System.out.print("Enter the name of student:");
                Scanner sc = new Scanner(System.in);
                String nam = sc.nextLine();


                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    boolean flag = false;

                    String sql = "select * from marklist where Name = (?) ";
                    p = connection.prepareStatement(sql);

                    p.setString(1, nam);
                    rs = p.executeQuery();


                    {
                        // Condition check
                        while (rs.next()) {

                            JsonObject rec = new JsonObject();


                            rec.addProperty("Name", rs.getString("Name"));
                            rec.addProperty("Admission No", rs.getInt("AdmissionNo"));

                            JsonArray arr = new JsonArray();
                            JsonObject ob = new JsonObject();
                            float phy = rs.getFloat("Physics");
                            ob.addProperty("Marks", phy);
                            ob.addProperty("Grade", Grade.phyGrade(phy));
                            ob.addProperty("Grade Point", GradePoint.phyGradePoint(phy));
                            arr.add(ob);

                            rec.add("Physics", arr);

                            JsonArray arr1 = new JsonArray();
                            JsonObject ob1 = new JsonObject();
                            float che = rs.getFloat("Chemistry");
                            ob1.addProperty("Marks", che);
                            ob1.addProperty("Grade", Grade.cheGrade(che));
                            ob1.addProperty("Grade Point", GradePoint.cheGradePoint(che));
                            arr1.add(ob1);

                            rec.add("Chemistry", arr1);

                            JsonArray arr2 = new JsonArray();
                            JsonObject ob2 = new JsonObject();
                            float math = rs.getFloat("Maths");
                            ob2.addProperty("Marks", math);
                            ob2.addProperty("Grade", Grade.mathGrade(math));
                            ob2.addProperty("Grade Point", GradePoint.mathGradePoint(math));
                            arr2.add(ob2);


                            rec.add("Maths", arr2);
                            float total = TotalPerc.total(phy, che, math);
                            rec.addProperty("Total Marks", total);
                            float per = TotalPerc.perc(total);
                            rec.addProperty("Percentage", per);
                            String det = rec.toString();

                            System.out.println(det);
                            flag = true;



                        }
                        if (flag == false) System.out.println("Student not found");

                    }

                } catch (SQLException e) {
                    throw new IllegalStateException("Cannot connect the database!");
                }

                choice = "name";
                break;

            case "2":

                System.out.print("Enter the Admission No of student:");
                Scanner sca = new Scanner(System.in);
                int ad = sca.nextInt();


                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    boolean flag = false;

                    String sql = "select * from marklist where AdmissionNo = (?)";
                    p = connection.prepareStatement(sql);
                    p.setInt(1, ad);
                    rs = p.executeQuery();

                    // Condiion check
                    while (rs.next()) {

                        JsonObject rec = new JsonObject();


                        rec.addProperty("Name", rs.getString("Name"));
                        rec.addProperty("Admission No", rs.getInt("AdmissionNo"));

                        JsonArray arr = new JsonArray();
                        JsonObject ob = new JsonObject();
                        float phy = rs.getFloat("Physics");
                        ob.addProperty("Marks", phy);
                        ob.addProperty("Grade", Grade.phyGrade(phy));
                        ob.addProperty("Grade Point", GradePoint.phyGradePoint(phy));
                        arr.add(ob);

                        rec.add("Physics", arr);

                        JsonArray arr1 = new JsonArray();
                        JsonObject ob1 = new JsonObject();
                        float che = rs.getFloat("Chemistry");
                        ob1.addProperty("Marks", che);
                        ob1.addProperty("Grade", Grade.cheGrade(che));
                        ob1.addProperty("Grade Point", GradePoint.cheGradePoint(che));
                        arr1.add(ob1);

                        rec.add("Chemistry", arr1);

                        JsonArray arr2 = new JsonArray();
                        JsonObject ob2 = new JsonObject();
                        float math = rs.getFloat("Maths");
                        ob2.addProperty("Marks", math);
                        ob2.addProperty("Grade", Grade.mathGrade(math));
                        ob2.addProperty("Grade Point", GradePoint.mathGradePoint(math));
                        arr2.add(ob2);


                        rec.add("Maths", arr2);
                        float total = TotalPerc.total(phy, che, math);
                        rec.addProperty("Total Marks", total);
                        float per = TotalPerc.perc(total);
                        rec.addProperty("Percentage", per);


                        System.out.println(rec);
                        flag = true;


                    }
                    if (!flag) System.out.println("Student not found");


                } catch (SQLException e) {
                    throw new IllegalStateException("Cannot connect the database!");
                }


                choice = "admno";
                break;


            case "3":

                choice = "exit";
                break;

            default:
                if (!ch.equals("1") || !ch.equals("2") || !ch.equals("3")) {

                    System.out.println("Invalid Choice");
                    choice = "invalid";
                    break;
                }
        }


        return choice;
    }
}
