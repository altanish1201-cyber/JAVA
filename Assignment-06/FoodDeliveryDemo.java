class FoodDelivery {
    private String orderId = "ORD-9821";
    private String itemName = "Paneer Butter Masala";

    class OrderDetails {
        void display() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Item Name: " + itemName);
        }
    }
}

interface DeliveryStatus {
    void updateStatus();
}

public class FoodDeliveryDemo {
    public static void main(String[] args) {

        FoodDelivery app = new FoodDelivery();
        FoodDelivery.OrderDetails order = app.new OrderDetails();
        order.display();

        DeliveryStatus status = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Delivery Status: Out for Delivery");
            }
        };
        status.updateStatus();
    }
}