import java.util.ArrayList;
import java.util.Scanner;

public class Todo {

    public static void main(String[] args) {
        ArrayList<String> todo = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks you want to do: ");
        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter task " + i + ": ");
            todo.add(i + ". " + sc.nextLine());
        }

        StringBuffer sb = new StringBuffer();
        sb.append("\nYour To-Do List\n");
        for (int i = 0; i < todo.size(); i++) {
            sb.append(todo.get(i)).append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}