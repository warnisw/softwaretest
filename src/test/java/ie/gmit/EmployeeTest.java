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
        Exception e = assertThrows(IllegalArgumentException.class, () -> employee = new Employee("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,19, -1));
        assertEquals("Salary must be a positive float", e.getMessage());
    }

}
