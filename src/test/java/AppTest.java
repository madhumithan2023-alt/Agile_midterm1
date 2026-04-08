import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testSalaryCalculation() {
        App payroll = new App(20000, 5000, 3000);
        double result = payroll.calculateNetSalary();
        assertEquals(22000, result);
    }

    @Test
    public void testSalaryComponents() {
        App payroll = new App(15000, 4000, 2000);

        assertEquals(15000, payroll.getBasic());
        assertEquals(4000, payroll.getAllowances());
        assertEquals(2000, payroll.getDeductions());
    }

    @Test
    public void testZeroSalary() {
        App payroll = new App(0, 0, 0);
        assertEquals(0, payroll.calculateNetSalary());
    }

   
    @Test
    public void testNegativeSalary() {
        App payroll = new App(-10000, 2000, 1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            payroll.calculateNetSalary();
        });

        assertEquals("Salary components cannot be negative", exception.getMessage());
    }

   
    @Test
    public void testLargeSalary() {
        App payroll = new App(100000, 50000, 20000);
        assertEquals(130000, payroll.calculateNetSalary());
    }
}