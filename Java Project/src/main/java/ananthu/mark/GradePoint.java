package ananthu.mark;

public class GradePoint {
    public static String phyGradePoint(float phy) {
        String pgp = null;

        if (phy > 90 && phy <= 100) {
            pgp = "10.0";

        } else if (phy > 80 && phy <= 90) {

            pgp = "9.0";

        } else if (phy > 70 && phy <= 80) {

            pgp = "8.0";

        } else if (phy > 60 && phy <= 70) {

            pgp = "7.0";

        } else if (phy > 50 && phy <= 60) {

            pgp = "6.0";

        } else if (phy > 40 && phy <= 50) {

            pgp = "5.0";

        } else if (phy > 32 && phy <= 40) {

            pgp = "4.0";

        } else if (phy > 20 && phy <= 32) {

            pgp = "C";

        } else if (phy >= 0 && phy <= 20) {

            pgp = "C";

        } else {
            System.out.println("No Data");
        }
        return pgp;
    }

   public static String cheGradePoint(float che) {
        String cgp = null;
        if (che > 90 && che <= 100) {

            cgp = "10.0";

        } else if (che > 80 && che <= 90) {

            cgp = "9.0";

        } else if (che > 70 && che <= 80) {

            cgp = "8.0";

        } else if (che > 60 && che <= 70) {

            cgp = "7.0";

        } else if (che > 50 && che <= 60) {

            cgp = "6.0";

        } else if (che > 40 && che <= 50) {

            cgp = "5.0";

        } else if (che > 32 && che <= 40) {

            cgp = "4.0";

        } else if (che > 20 && che <= 32) {

            cgp = "C";

        } else if (che >= 0 && che <= 20) {

            cgp = "C";

        } else {
            System.out.println("No Data");
        }
        return cgp;
    }

    public static String mathGradePoint(float math) {
        String mgp = null;
        if (math > 90 && math <= 100) {

            mgp = "10.0";

        } else if (math > 80 && math <= 90) {

            mgp = "9.0";

        } else if (math > 70 && math <= 80) {

            mgp = "8.0";

        } else if (math > 60 && math <= 70) {

            mgp = "7.0";

        } else if (math > 50 && math <= 60) {

            mgp = "6.0";

        } else if (math > 40 && math <= 50) {

            mgp = "5.0";

        } else if (math > 32 && math <= 40) {

            mgp = "4.0";

        } else if (math > 20 && math <= 32) {

            mgp = "C";

        } else if (math >= 0 && math <= 20) {

            mgp = "C";

        } else {
            System.out.println("No Data");
        }
        return mgp;
    }
}
