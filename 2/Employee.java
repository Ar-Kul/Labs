public abstract class Employee {
    protected String name;
    private int id;
    protected double salary; 
    private static int totalEmployees = 0;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        totalEmployees++;
    }

    public Employee() {
        this("unknown", 0, 0.0);
    }

    //Геттеры
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    //Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();
//Перегруженный метод
    public void printInfo() {
        System.out.println("Сотрудники:" + name + ", ID:" + id + ", Зарплата:" + salary);
    }

    public void printInfo(String prefix) {
        System.out.println(prefix + "Сотрудники:" + name + ", ID:" + id);
    }

    public String getRole() {
        return "Сотрудник";
    }
}
