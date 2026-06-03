import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private final HashTable<Integer, Order> orders = new HashTable<>();
    private final List<Integer> keys = new ArrayList<>();

    public void addOrder(int orderNumber, Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Заказ не может быть пустым");
        }
        if (orders.get(orderNumber) == null) {
            keys.add(orderNumber);
        }
        orders.put(orderNumber, order);
    }

    public Order findOrder(int orderNumber) {
        return orders.get(orderNumber);
    }

    public Order removeOrder(int orderNumber) {
        Order removed = orders.remove(orderNumber);
        if (removed != null) {
            keys.remove(Integer.valueOf(orderNumber));
        }
        return removed;
    }

    public void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("Список заказов пуст.");
            return;
        }
        System.out.println("=== Список всех заказов ===");
        for (int orderNumber : keys) {
            Order order = orders.get(orderNumber);
            System.out.println("Заказ №" + orderNumber + ": " + order);
        }
        System.out.println("Всего заказов: " + orders.size());
    }

    public int size() {
        return orders.size();
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }
}
