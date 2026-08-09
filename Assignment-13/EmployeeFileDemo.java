import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeFileDemo {
    static File f0 = new File("employee.txt");

    public static void main(String[] args) {
        filewriter();
        filereader();
    }

    static void filewriter() {
        try {
            FileWriter fwrite = new FileWriter(f0);
            fwrite.write("ID: 101, Name: Alice, Dept: CSE, Salary: 75000\n");
            fwrite.write("ID: 102, Name: Bob, Dept: IT, Salary: 68000\n");
            fwrite.close();
            System.out.println("Employee details written successfully.\n");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred!");
            e.printStackTrace();
        }
    }

    static void filereader() {
        try {
            Scanner dataReader = new Scanner(f0);
            System.out.println("Reading Employee Details");
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Unexpected error occurred!");
            exception.printStackTrace();
        }
    }
}