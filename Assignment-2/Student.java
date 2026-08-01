public class Student {
    String name;
    int rollno;

    Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    Student() {
        this.name = "Default";
        this.rollno = 0000;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll no.: " + rollno);
    }

    public static void main(String[] args) {
        Student s1 = new Student("anish", 273);
        s1.display();
        Student s2 = new Student();
        s2.display();
    }
}
