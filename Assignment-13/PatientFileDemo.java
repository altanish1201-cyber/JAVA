import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PatientFileDemo {
    static File f0 = new File("patient.txt");

    public static void main(String[] args) {
        filewriter();
        filereader();
    }

    static void filewriter() {
        try {
            FileWriter fwrite = new FileWriter(f0);
            fwrite.write("Patient ID: P-201, Name: John Doe, Age: 45, Diagnosis: Hypertension\n");
            fwrite.write("Patient ID: P-202, Name: Jane Smith, Age: 30, Diagnosis: Flu\n");
            fwrite.close();
            System.out.println("Patient details written successfully.\n");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred!");
            e.printStackTrace();
        }
    }

    static void filereader() {
        try {
            Scanner dataReader = new Scanner(f0);
            System.out.println("Reading Patient Details");
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