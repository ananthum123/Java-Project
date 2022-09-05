package ananthu.mark;



public class Grade {



     public static String phyGrade(float phy) {
        String pg = null;

        if (phy > 90 && phy <= 100) {
            pg = "A1";

        } else if (phy > 80 && phy <= 90) {

            pg = "A2";

        } else if (phy > 70 && phy <= 80) {

            pg = "B1";

        } else if (phy > 60 && phy <= 70) {

            pg = "B2";

        } else if (phy > 50 && phy <= 60) {

            pg = "C1";

        } else if (phy > 40 && phy <= 50) {

            pg = "C2";

        } else if (phy > 32 && phy <= 40) {

            pg = "D";

        } else if (phy > 20 && phy <= 32) {

            pg = "E1";

        } else if (phy >= 0 && phy <= 20) {

            pg = "E2";

        } else {
            System.out.println("No data");
        }
        return pg;
    }

   public static String cheGrade(float che) {
        String cg = null;
        if (che > 90 && che <= 100) {

            cg = "A1";

        } else if (che > 80 && che <= 90) {

            cg = "A2";

        } else if (che > 70 && che <= 80) {

            cg = "B1";

        } else if (che > 60 && che <= 70) {

            cg = "B2";

        } else if (che > 50 && che <= 60) {

            cg = "C1";

        } else if (che > 40 && che <= 50) {

            cg = "C2";

        } else if (che > 32 && che <= 40) {

            cg = "D";

        } else if (che > 20 && che <= 32) {

            cg = "E1";

        } else if (che >= 0 && che <= 20) {

            cg = "E2";

        } else {
            System.out.println("No data");
        }
        return cg;
    }

    public static String mathGrade(float math) {
        String mg = null;
        if (math > 90 && math <= 100) {

            mg = "A1";

        } else if (math > 80 && math <= 90) {

            mg = "A2";

        } else if (math > 70 && math <= 80) {

            mg = "B1";

        } else if (math > 60 && math <= 70) {

            mg = "B2";

        } else if (math > 50 && math <= 60) {

            mg = "C1";

        } else if (math > 40 && math <= 50) {

            mg = "C2";

        } else if (math > 32 && math <= 40) {

            mg = "D";

        } else if (math > 20 && math <= 32) {

            mg = "E1";

        } else if (math >= 0 && math <= 20) {

            mg = "E2";

        } else {
            System.out.println("No data");
        }
        return mg;
    }
}

