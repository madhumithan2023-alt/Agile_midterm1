public class App {
    private double basic;
    private double allowances;
    private double deductions;

    public App(double basic, double allowances, double deductions) {
        this.basic = basic;
        this.allowances = allowances;
        this.deductions = deductions;
    }

    public double calculateNetSalary() {
        if (basic < 0 || allowances < 0 || deductions < 0) {
            throw new IllegalArgumentException("Salary components cannot be negative");
        }
        return basic + allowances - deductions;
    }

    
    public double getBasic() {
        return basic;
    }

    public double getAllowances() {
        return allowances;
    }

    public double getDeductions() {
        return deductions;
    }
}

class Main {
    public static void main(String[] args) {
        App payroll = new App(20000, 5000, 3000);
        double netSalary = payroll.calculateNetSalary();
        System.out.println("Net Salary: " + netSalary);
    }
}