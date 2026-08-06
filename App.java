public class App {
    String name;
    int prn;

    App(String a, int b) { // paramaterized constructor
        name = a;
        prn = b;
    }

    App() { // default constructor (executed first)
        System.out.println("default constructor executed");
        name = "---";
        prn = 10;
    }

    App(String name) { // paramaterized constructor (overridding )
        this.name = name;
    }

    App(int prn) { // paramaterized constructor (overridding)
        this.prn = prn;
    }

    App(App a) { // copy constructor
        this.name = a.name;
        this.prn = a.prn;
    }

    void show() { // show method
        System.out.println("Name: " + name);
        System.out.println("PRN: " + prn);
    }

    public static void main(String[] args) { // main method
        App obj = new App(); // *new* used to create object in java and initialize data
        obj.show();
        App obj1 = new App("Sahu", 272);
        obj1.show();
        App obj2 = new App(8);
        obj2.show();
        App obj4 = new App("Anish");
        obj4.show();
        App obj3 = new App(obj1);
        obj3.show();
    }
}
