import java.util.Objects;

public class Employee {
    private  final String fullName;
    private int department;
    private long salary;
    private final int idNumber;
    private static int counter;



    public Employee(String fullName, int department, long salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        idNumber = ++counter;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;

    }

    public String getFullName() {
        return this.fullName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public int getDepartment() {
        return department;
    }

    public long getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(long salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nEmployee №" + idNumber +
                "\nFull name: " + fullName +
                ", department #" + department +
                ", salary " + salary +
                " roubles";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }
}
