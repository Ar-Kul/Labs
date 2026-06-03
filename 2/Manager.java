public class Manager extends Employee {
    protected String department;
    protected int teamSize;
    protected double budget;

    public Manager(String name, int id, double salary, String department, int teamSize, double budget) {
        super(name, id, salary);
        this.department = department;
        this.teamSize = teamSize;
        this.budget = budget;
    }

    public Manager() {
        super();
        this.department = "Unknown";
        this.teamSize = 0;
        this.budget = 0.0;
    }

    public String getDepartment() {
        return department;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public double getBudget() {
        return budget;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public void work() {
        System.out.println("Менеджер " + name + " управляет командой из " + teamSize + " человек.");
    }

    @Override
    public String getRole() {
        return "Менеджер";
    }

    public void approveBudget () {
        System.out.println("Менеджер утверждает бюджет: " + budget);
    }
}
