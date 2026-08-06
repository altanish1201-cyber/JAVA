class Vehicle {
    String type;

    Vehicle(String type) {
        this.type = type;
    }

    void showStatus() {
        System.out.println("Vehicle Verified");
    }
}

class CarInsurance extends Vehicle {
    String policyType;

    CarInsurance(String policyType) {
        super("Sedan");
        this.policyType = policyType;
    }

    void display() {
        System.out.println("Parent Vehicle Type: " + super.type);
        System.out.println("Policy Type: " + policyType);
        super.showStatus();
    }
}

public class SuperInsurance {
    public static void main(String[] args) {
        CarInsurance c = new CarInsurance("Comprehensive");
        c.display();
    }
}