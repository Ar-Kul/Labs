public class Main {
    public static void main(String[] args) {
        System.out.println("Всего сотрудников: " + Employee.getTotalEmployees());

        Administrator admin = new Administrator(
            "Иван Петров", 101, 75000,
            "Административный отдел", 10, "+7-999-999-99-99"
        );

        Manager manager = new Manager(
            "Анна Смирнова", 102, 120000,
            "Отдел продаж", 15, 500000
        );

        Programmer programmer = new Programmer(
            "Сергей Козлов", 103, 95000,
            "Java", "Python", 3
        );

        System.out.println("\n--- Информация о сотрудниках---");
        admin.printInfo();
        manager.printInfo();
        programmer.printInfo();

        System.out.println("\n--- Геттеры ---");
        System.out.println("Имя администратора: " + admin.getName());
        System.out.println("Зарплата менеджера: " + manager.getSalary());
        System.out.println("Любимый язык программиста: " + programmer.getFavoriteLanguage());

        System.out.println("\n--- Сеттеры ---");
        admin.setOfficePhone("+7-962-923-93-07");
        System.out.println("Новый телефон администратора: " + admin.getOfficePhone());

        System.out.println("\n--- Полиморфоз ---");
        Employee[] employees = {admin, manager, programmer};
        for (Employee e: employees) {
            e.work();
        }

        System.out.println("\n--- Специфичные методы ---");
        admin.conductMeeting();
        manager.approveBudget();
        programmer.codeWritten();

        System.out.println("\n--- Перегрузка ---");
        admin.printInfo();
        admin.printInfo(">>> ");

        System.out.println("\n--- Статческий счетчик ---");
        System.out.println("Всего сотрудников: " + Employee.getTotalEmployees());
    }
}
