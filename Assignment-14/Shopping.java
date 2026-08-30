import java.util.Scanner;

class invalidProductQuantity extends Exception{
    invalidProductQuantity(String message){
        super(message);
    }
}
public class Shopping {
    Scanner sc = new Scanner(System.in);
    int product,cart;
    void addToCart()throws invalidProductQuantity{
        System.out.print("Enter product quantity: ");
        product = sc.nextInt();
        if(product <= 0){
            throw new invalidProductQuantity("Invalid product quantity");
        }
        cart+=product;
        System.out.println("Product added to cart");
        System.out.println("Total Items in cart: "+cart);
    }
    public static void main(String[] args) {
        Shopping shop = new Shopping();
        try{
            shop.addToCart();
        }
        catch(invalidProductQuantity e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
