class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void displayInfo() {
        System.out.println("Employee Record Found");
    }
}

class Manager extends Employee {
    String name;

    Manager(String name) {
        super("Senior Staff");
        this.name = name;
    }

    void display() {
        System.out.println("Parent Name: " + super.name);
        System.out.println("Child Name: " + name);
        super.displayInfo();
    }
}

public class SuperEmployee {
    public static void main(String[] args) {
        Manager m = new Manager("Alice");
        m.display();
    }
}