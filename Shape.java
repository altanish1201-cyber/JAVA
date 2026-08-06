abstract class Shape {
    abstract void draw();

    void message() {
        System.out.println("This is shape class");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle");
    }

    void message() {
        System.out.println("This is circle class");
    }

}
