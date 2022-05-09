import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class Testing {
    @Test
    public void test1(){
        String date = "1994-02-17";
        System.out.println(Date.valueOf(date));
    }

    @Test
    public void test2(){
        double rate = 0;
        String review = "";
//        Scanner input = new Scanner(System.in);
//        System.out.println("enter double");
        String str = " very good movie";
        try {
            rate = Double.parseDouble(str.split(" ")[0]);
            review = str.split("[^a-zA-Z ]+")[1].trim(); //check for any letters - comment within the rating
        } catch (Exception e) {
            System.out.println("Error: input a rating out of ten and a comment");
        }

        System.out.println(rate);
        System.out.println(review);
    }

    @Test
    public void test3(){
        System.getProperty("user.dir");
    }
}
