import java.util.*;
import java.io.*;

public class ExploringRecursion {


    public static void main(String[] args) {

        //writeStars(10);
        //writeStarsR(10);

        try {
            Scanner in = new Scanner(new File("D:\\Users\\River\\Documents\\Coding\\Java\\CS143\\Chapter12Recursion\\test.txt"));
            reverse(in);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


    }


    public static void writeStars(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void writeStarsR(int n) {
        if (n == 0) {
            // base case
            System.out.println();
        } else {
            // recursive case
            System.out.print("*");
            writeStarsR(n - 1);
        }
    }

    public static void reverse(Scanner input) {
        if (input.hasNextLine()) {
            // recursive case (nonempty file)
            String line = input.nextLine();
            reverse(input);
            System.out.println(line);
        }
    }

}


