import java.util.Scanner;

public class Word_count {
    public static void main(String[] args) {
        System.out.print("Input the string: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.trim().split("\\s+");
        System.out.println("Number of words: " + words.length);
        sc.close();
    }
}
