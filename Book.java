public class Book {
    String title;
    String author;
    double price;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        // this.price = 100.0;
    }

    Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("price: " + price + " Rs");
    }

    public static void main(String[] args) {
        System.out.println("2 parameter constructor : ");
        Book s2 = new Book("Java", "Anish");
        s2.display();
        System.out.println("\n3 parameter constructor : ");
        Book s3 = new Book("Java", "Anish", 1000.0);
        s3.display();

    }
}
