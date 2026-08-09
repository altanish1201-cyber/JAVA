class Vehicle {
    private String model = "BMX X7";
    private int speed = 240;

    class Details {
        void display() {
            System.out.println("Model: " + model);
            System.out.println("Speed: " + speed + " km/h");
        }
    }
}

interface Action {
    void run();
}

public class VehicleDemo {
    public static void main(String[] args) {

        Vehicle v = new Vehicle();
        Vehicle.Details d = v.new Details();
        d.display();

        Action a = new Action() {
            public void run() {
                System.out.println("Action: Vehicle is moving");
            }
        };
        a.run();
    }
}