import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    String name;
    int code;

    public static void main(String[] args) throws Exception {
        ArrayList<String> reg = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of courses you want to register: ");
        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter course " + i + ": ");
            reg.add(sc.nextLine());
        }

        StringBuffer sb = new StringBuffer();

        int choice = 0;
        System.out.println("\n--------------------------\n");
        System.out.println("1. View courses");
        System.out.println("2. Add courses");
        System.out.println("3. Remove courses");
        System.out.println("4. Exit");
        while (choice != 4) {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                sb.setLength(0);
                sb.append("\nYour Courses\n");
                for (int i = 0; i < reg.size(); i++) {
                    sb.append(i + 1).append(". ").append(reg.get(i)).append("\n");
                }
                System.out.println(sb);
            } else if (choice == 2) {
                System.out.print("Enter course to add: ");
                String cname = sc.nextLine();
                reg.add(cname);
                System.out.println("Course added successfully.");
            } else if (choice == 3) {
                System.out.print("Enter course number to delete: ");
                int x = sc.nextInt();
                sc.nextLine();
                if (x >= 1 && x <= reg.size()) {
                    reg.remove(x - 1);
                    System.out.println("Course deleted successfully.");
                } else {
                    System.out.println("Invalid course number.");
                }
            } else if (choice == 4) {
                System.out.println("Saving...");
                break;
            } else {
                System.out.println("Invalid choice, Try Again...");
            }
        }
        sc.close();
    }
}