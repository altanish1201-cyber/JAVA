import java.util.Scanner;

public class Salary {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("Enter Basic Salary: ");
        float basicSalary = sc.nextFloat();
        System.out.print("Enter Bonus: ");
        float bonus = sc.nextFloat();
        System.out.println("Total Salary= " + (basicSalary + bonus));
    }
}
