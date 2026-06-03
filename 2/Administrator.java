public class Administrator extends Employee {
    protected String department;
    protected int managedEmployees;
    protected String officePhone;

    public Administrator(String name, int id, double salary, String department, int managedEmployees, String officePhone) {
        super(name, id, salary);
        this.department = department;
        this.managedEmployees = managedEmployees;
        this.officePhone = officePhone;
    }

    public Administrator() {
        super();
        this.department = "Unknown";
        this.managedEmployees = 0;
        this.officePhone = "None";
    }

    public String getDepartment() {
        return department;
    }

    public int getManagedEmployees() {
        return managedEmployees;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setManagedEmployees(int managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    @Override
    public void work() {
        System.out.println("Администратор " + name + " организует работу офиса.");
    }

    @Override
    public String getRole() {
        return "Администратор";
    }

    public void conductMeeting () {
        System.out.println("Администратор проводит совещание.");
    }
}
