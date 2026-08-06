import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input_wrapper {
    public static void main(String[] args) throws Exception {

        // primitive input type (defaulted to string):
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String s = br.readLine();
        // System.out.println("inputed data: " + s);

        // modern method:
        Scanner sc = new Scanner(System.in);
        float f = sc.nextFloat();
        System.out.println("Number= " + f);
        sc.close();
    }
}