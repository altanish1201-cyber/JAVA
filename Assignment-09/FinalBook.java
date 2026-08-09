final class Book {
    final String ISBN = "978-0134685991";
    String title = "Effective Java";
    String author = "Joshua Bloch";
    double price = 45.0;

    final void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}

public class FinalBook {
    public static void main(String[] args) {
        Book b = new Book();
        b.display();
    }
}