import java.util.ArrayList;
import java.util.List;

// Класс Товар
class Product {
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}

// Класс Склад
class Warehouse {
    private final List<Product> products = new ArrayList<>();
    private final int totalProductsCount;
    
    // Переменные для текущей отправки
    private int currentTruckWeight = 0;
    private final List<Product> currentTruckProducts = new ArrayList<>();

    public Warehouse(List<Product> initialProducts) {
        this.products.addAll(initialProducts);
        this.totalProductsCount = initialProducts.size();
    }

    // Синхронизированный метод взятия товара со склада
    public synchronized Product takeProduct() {
        if (products.isEmpty()) {
            return null;
        }
        return products.remove(0);
    }

    // Синхронизированное добавление веса в текущую машину/тележку
    public synchronized void addToTruck(Product product, String loaderName) {
        // Проверяем, не перегрузим ли мы лимит в 150 кг
        if (currentTruckWeight + product.getWeight() > 150) {
            System.out.println("\n--- [!] Машина заполнена! Отправка на другой склад. Вес: " + currentTruckWeight + " кг ---");
            // Имитация разгрузки
            currentTruckProducts.clear();
            currentTruckWeight = 0;
            System.out.println("--- Машина разгружена и вернулась на склад ---\n");
        }

        currentTruckProducts.add(product);
        currentTruckWeight += product.getWeight();
        System.out.println(loaderName + " погрузил " + product.getName() + " (" + product.getWeight() + " кг). Текущий вес машины: " + currentTruckWeight + " кг.");
    }
    
    // Финальная проверка остатков
    public synchronized void forceDelivery() {
        if (currentTruckWeight > 0) {
            System.out.println("\n--- [!] Товары закончились. Отправка последней партии весом: " + currentTruckWeight + " кг ---");
            currentTruckWeight = 0;
            currentTruckProducts.clear();
        }
    }
}

// Класс Грузчик (наследуется от Thread согласно Варианту 1)
class Loader extends Thread {
    private final Warehouse warehouse;

    public Loader(String name, Warehouse warehouse) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            Product product = warehouse.takeProduct();
            if (product == null) {
                // Товаров больше нет
                break; 
            }

            // Имитация времени на подбор товара
            try {
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            warehouse.addToTruck(product, getName());
        }
    }
}

// Главный класс для запуска симуляции
public class MainWarehouse {
    public static void main(String[] args) {
        // Создаем список товаров с разным весом
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            products.add(new Product("Товар №" + i, 20 + (i * 2))); // Вес от 22 до 50 кг
        }

        Warehouse sourceWarehouse = new Warehouse(products);

        // Создаем 3 грузчиков (3 отдельных потока)
        Loader loader1 = new Loader("Грузчик-1", sourceWarehouse);
        Loader loader2 = new Loader("Грузчик-2", sourceWarehouse);
        Loader loader3 = new Loader("Грузчик-3", sourceWarehouse);

        // Запуск потоков
        loader1.start();
        loader2.start();
        loader3.start();

        try {
            // Ожидаем завершения работы всех грузчиков
            loader1.join();
            loader2.join();
            loader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Отправляем остатки, если они не добрали ровно до 150 кг в конце
        sourceWarehouse.forceDelivery();
        System.out.println("Все товары успешно перенесены на другой склад!");
    }
}
