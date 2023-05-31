public class Main {
    static Employee[] employees = new Employee[10];


    public static void main(String[] args) {
        System.out.println("\nMidterm 1, 31.01.2023");
        employees[0] = new Employee("John Smith", 1, 100_000);
        employees[1] = new Employee("Tracy Smith", 3, 200_000);
        employees[2] = new Employee("Anna Kraft", 5, 300_000);
        employees[3] = new Employee("Luise Montpelier", 3, 10_000);
        employees[4] = new Employee("Abraham Kennedy", 4, 12_000);
        employees[5] = new Employee("Zu Tzu", 2, 100_500);
        employees[6] = new Employee("Fernandez Lao", 1, 110_500);
        employees[7] = new Employee("Lyubov Koroleva ", 2, 70_000);
        employees[8] = new Employee("Ivan Drozdov", 1, 750_000);
        employees[9] = new Employee("Sergey Smirnoff", 5, 90_000);

        //check print method
        printAllEmployees(employees);

        //find min salary method check
        System.out.println("\nfind min salary method check");
        long minSalary = findMinSalary();
        System.out.println("The lowest salary is " + minSalary);

        //count overall salary expenditures this month method check
        System.out.println("\nFind overall salary expenditures method check");
        long overallSalaries = spentOnSalariesThisMonth();
        System.out.println("Overall salary expenditures this month will be " + overallSalaries);

        //find max salary method check
        System.out.println("\nFind max salary method check");
        long maxSalary = findMaxSalary();
        System.out.println("The biggest salary is " + maxSalary);

        //find average salary method check
        System.out.println("\nFind average salary method check");
        double averageSalary = findAverageSalary();
        System.out.println("Average salary is " + averageSalary + "\n");

        //check print names method
        System.out.println("\nPrint all employees method check");
        printAllNames(employees);

        //find min salary by department method checker
        System.out.println("\nMin salary by department check method");
        System.out.println(findMinSalaryByDepartment(3));

        //find max salary by department method checker
        System.out.println("\nMax salary by department check method");
        System.out.println(findMaxSalaryByDepartment(1));

        //find salary expenditure by department method checker
        System.out.println("\nSalary expenditure this month by department check method");
        System.out.println("Spent on salaries this month in the department: " + spentOnSalariesByMonthByDep(1));

        //find average salary by department method checker
        System.out.println("\nAverage salary by department check method");
        System.out.println(findAverageSalaryByDepartment(1));

        //index salaries check method
        System.out.println("\nindex salaries check method");
        Employee[] indexedEmployees = indexSalaries(employees, 15);
        printAllEmployees(indexedEmployees);

        // print employees by department method checker
        System.out.println("\nPrint employees by department method check");
        printAllEmployeesByDepartment(1);

    }

    public static long spentOnSalariesThisMonth() {
        long overallSalaries = 0;
        for (Employee employee: employees) {
            overallSalaries += employee.getSalary();
        }
        return overallSalaries;

    }

    public static long findMaxSalary () {
        long maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            long currentSalary = employee.getSalary();
            if (currentSalary > maxSalary) {
                maxSalary = currentSalary;
            }
        }
        return maxSalary;
    }

    public static long findMinSalary() {
        long minSalary = employees[0].getSalary();
        for (Employee value : employees) {
            long currentSalary = value.getSalary();
            minSalary = Math.min(currentSalary, minSalary);
        }
        return minSalary;
    }

    public static double findAverageSalary() {
        long overallSalary = spentOnSalariesThisMonth();
        return (double) overallSalary/employees.length;
    }

    public static void printAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void printAllNames(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("Employee №" + employee.getIdNumber() + ": " + employee.getFullName());
        }
    }


    public static Employee findMinSalaryByDepartment(int department) {
        Employee employeeMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                if (employeeMinSalary == null || employeeMinSalary.getSalary() > employees[i].getSalary()) {
                    employeeMinSalary = employees[i];
                }
            }
        }
        return employeeMinSalary;
    }

    private static Employee findMaxSalaryByDepartment(int department) {
        Employee employeeMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                if (employeeMaxSalary == null || employeeMaxSalary.getSalary() < employees[i].getSalary()) {
                    employeeMaxSalary = employees[i];
                }
            }
        }
        return employeeMaxSalary;
    }

    private static long spentOnSalariesByMonthByDep(int department) {
        long overallSalaries = 0;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                overallSalaries += employees[i].getSalary();
            }
        }
        return overallSalaries;
    }

    private static long findAverageSalaryByDepartment(int department) {
        long overallSalaries = spentOnSalariesByMonthByDep(department);
        int employeeCounter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                employeeCounter++;
            }
        }
        return overallSalaries/employeeCounter;
    }

    public static Employee[] indexSalaries(Employee[] employees, int index) {
        for (Employee employee: employees) {
            long indexedSalary = employee.getSalary() + index*employee.getSalary()/100;
            employee.setSalary(indexedSalary);
        }
        return employees;
    }

    private static void printAllEmployeesByDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                System.out.println("Employee №" + employees[i].getIdNumber());
                System.out.println("Full name: " + employees[i].getFullName() + ", salary " + employees[i].getSalary() + " roubles");
            }
        }
    }
}