public class Main {
    public static void main(String[] args) {
        System.out.println("=== Задание 1. Собственная HashTable ===");
        HashTable<String, Integer> table = new HashTable<>();

        table.put("apple", 5);
        table.put("banana", 3);
        table.put("orange", 7);

        System.out.println("Размер таблицы: " + table.size());
        System.out.println("Значение по ключу banana: " + table.get("banana"));

        table.put("banana", 10);
        System.out.println("Обновленное значение banana: " + table.get("banana"));

        System.out.println("Удалено значение по ключу apple: " + table.remove("apple"));
        System.out.println("Размер таблицы после удаления: " + table.size());
        System.out.println("Пуста ли таблица? " + table.isEmpty());

        System.out.println("\n=== Задание 2. Учёт заказов  ===");
        OrderManager manager = new OrderManager();

        manager.addOrder(101, new Order("Ноутбук, Мышь", "Москва, ул. Тверская, д.1", 55000));
        manager.addOrder(102, new Order("Телефон, Чехол", "СПб, Невский пр., д.10", 35000));
        manager.addOrder(103, new Order("Книги (3 шт)", "Казань, ул. Баумана, д.5", 1500));
        manager.addOrder(104, new Order("Наушники, Клавиатура", "Новосибирск, Красный пр., д.20", 12000));

        manager.printAllOrders();

        System.out.println("\nПоиск заказа №102:");
        System.out.println(manager.findOrder(102));

        System.out.println("\nПоиск заказа №999:");
        Order found = manager.findOrder(999);
        System.out.println(found != null ? found : "Заказ не найден");

        System.out.println("\nОбновление заказа №101:");
        manager.addOrder(101, new Order("Ноутбук, Мышь, Коврик", "Москва, ул. Тверская, д.1", 57000));
        System.out.println(manager.findOrder(101));

        System.out.println("\nУдаление заказа №103:");
        System.out.println("Удалён: " + manager.removeOrder(103));

        manager.printAllOrders();

        System.out.println("\nПроверка size() и isEmpty():");
        System.out.println("size(): " + manager.size());
        System.out.println("isEmpty(): " + manager.isEmpty());
    }
}
