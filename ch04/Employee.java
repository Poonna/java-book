public class Employee {
    private String name;
    private double salary;
    private final int id;
    private static int lastId = 1000;
    
    public static final double SALARY_STEP_SIZE = 10.0;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = computeNextSalaryStep(salary);
        id = ++lastId;
    }

    public static double computeNextSalaryStep(double salary) {
        // Round to the next salary step
        double steps = Math.ceil(salary / SALARY_STEP_SIZE);
        return steps * SALARY_STEP_SIZE;
    }
    
    public void raiseSalary(double percent) {
        double raise = salary * percent / 100.0;
        salary = computeNextSalaryStep(salary + raise);
    }

    public void showProfile() {
        System.out.printf("Name: %s\n", name);
        System.out.printf("ID: %d\n", id);
        System.out.printf("Salary: %.2f\n", salary);
    }
}
