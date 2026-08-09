interface Printable {
    void print();
}

class Student implements Printable {
    public void print() {
        System.out.println("Printing Student details...");
    }
}

class Employee implements Printable {
    public void print() {
        System.out.println("Printing Employee details...");
    }
}

public class PrintableDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.print();

        Employee e = new Employee();
        e.print();
    }
}