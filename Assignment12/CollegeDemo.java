package Assignment12;

import Assignment12.packages.faculty.Faculty;
import Assignment12.packages.student.Student;

public class CollegeDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();

        Faculty f = new Faculty();
        f.display();
    }
}