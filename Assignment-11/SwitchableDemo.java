interface Switchable {
    void turnOn();
}

class Light implements Switchable {
    public void turnOn() {
        System.out.println("Light is turned ON");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan is turned ON");
    }
}

public class SwitchableDemo {
    public static void main(String[] args) {
        Light l = new Light();
        l.turnOn();

        Fan f = new Fan();
        f.turnOn();
    }
}