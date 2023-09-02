import java.time.LocalDateTime;

public interface OrderManagement {
     void addOrder(String orderId, String orderDescription, String deliveryAddress, String orderDate, double amount);
     void viewOrder();
     void viewByOrderId(String orderID);
     void sortOrder();
     void deleteOrderById(String orderID);
     void markAsDelivered(String orderID);
     void generateReport();
     void exit();
}
