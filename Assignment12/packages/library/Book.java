package Assignment12.packages.library;

public class Book {
    private int id = 501;
    private String title = "Java Programming";
    private String author = "James Gosling";
    private double price = 450.0;

    public void display() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
}