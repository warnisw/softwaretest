package ie.gmit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {
    Employee employee;

    @BeforeAll
    static void startingTests() {
        System.out.println("Starting tests");
    }

    @BeforeEach
    void printDisplayNames(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry(testInfo.getDisplayName());
    }

    @AfterAll
    static void testingComplete() {
        System.out.println("Testing Complete");
    }

    @DisplayName("Testing constructor initialisation success")
    @Test
    void testingConstructorSuccess() {
        employee = new Employee("Mr", "Ruairi Doherty", "NZ23AMZ3", "Contract", "33 Briarhill",123456789,23, 20000);
        assertEquals("Mr", employee.getTitle());
        assertEquals("Ruairi Doherty", employee.getName());
        assertEquals(123456789, employee.getPhone());
        assertEquals(23, employee.getAge());
        assertEquals("Contract", employee.getType());
        assertEquals("33 Briarhill", employee.getAddress());
        assertEquals("NZ23AMZ3", employee.getPps());
        assertEquals(20000, employee.getSalary());
    }

    @DisplayName("Testing invalid salary entry")
    @Test
    void testingInvalidSalary() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> employee = new Employee("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,19, 2.111));
        assertEquals("Salary must be in decimal(0.00) format", e.getMessage());
    }

    @DisplayName("Testing invalid pps entry")
    @Test
    void testingInvalidPPS() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> employee = new Employee("Mr", "Ruandria", "NZ", "Contract", "94 Claremorris", 123456789,23, 2000));
        assertEquals("PPS must contain 8 characters", e.getMessage());
    }

    @DisplayName("Testing invalid type entry")
    @Test
    void testingInvalidType() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> employee = new Employee("Mr", "Ruairi Doherty", "NZ23AM23", "none", "69 GMIT", 123456789, 23, 2000));
        assertEquals("Must contain employment type", e.getMessage());
    }

    @DisplayName("Testing invalid age entry")
    @Test
    void testingInvalidAge() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> employee = new Employee("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,13, 2000));
        assertEquals("Employee age must be over 16 to work in the company", e.getMessage());
    }

}
