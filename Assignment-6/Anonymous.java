class Outer {
    private String message = "Welcome to Java Programming";

    class Inner {
        void display() {
            System.out.println("Message: " + message);
        }
    }
}

interface Greeting {
    void sayHello();
}

public class Anonymous {
    public static void main(String[] args) {

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display();

        Greeting greet = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from Anonymous Class");
            }
        };
        greet.sayHello();
    }
}