interface Shape {
    void calculateArea();
}

class BaseShape implements Shape {
    public void calculateArea() {
        System.out.println("Calculating area...");
    }
}

class Circle extends BaseShape {
    double r = 5.0;

    public void calculateArea() {
        System.out.println("Circle Area: " + (3.14 * r * r));
    }
}

class Rectangle extends BaseShape {
    double w = 4.0, h = 6.0;

    public void calculateArea() {
        System.out.println("Rectangle Area: " + (w * h));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.calculateArea();

        Rectangle r = new Rectangle();
        r.calculateArea();
    }
}