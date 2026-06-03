import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Класс, описывающий проданный товар
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + price + " руб.)";
    }
}

public class SalesTracker {
    // Используем ArrayList по Варианту 1
    private List<Product> soldProducts = new ArrayList<>();

    // Добавление проданного товара
    public void addSale(Product product) {
        soldProducts.add(product);
        System.out.println("Продано: " + product.getName());
    }

    // Вывод списка всех проданных товаров
    public void printAllSales() {
        System.out.println("\n--- Список всех проданных товаров ---");
        for (Product p : soldProducts) {
            System.out.println(p);
        }
    }

    // Подсчет общей суммы продаж
    public double calculateTotalSales() {
        double total = 0;
        for (Product p : soldProducts) {
            total += p.getPrice();
        }
        return total;
    }

    // Определение наиболее популярного товара
    public String getMostPopularProduct() {
        if (soldProducts.isEmpty()) return "Нет продаж";

        // Считаем количество вхождений каждого товара по имени
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Product p : soldProducts) {
            frequencyMap.put(p.getName(), frequencyMap.getOrDefault(p.getName(), 0) + 1);
        }

        // Ищем имя товара с максимальным количеством продаж
        String mostPopular = "";
        int maxSales = -1;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular + " (продано " + maxSales + " шт.)";
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        // Симулируем продажи
        tracker.addSale(new Product("Ноутбук", 75000));
        tracker.addSale(new Product("Мышь", 1500));
        tracker.addSale(new Product("Клавиатура", 3500));
        tracker.addSale(new Product("Мышь", 1500)); // Повторная продажа для проверки популярности

        // Выводим аналитику
        tracker.printAllSales();
        System.out.println("\nОбщая сумма продаж: " + tracker.calculateTotalSales() + " руб.");
        System.out.println("Самый популярный товар: " + tracker.getMostPopularProduct());
    }
}
