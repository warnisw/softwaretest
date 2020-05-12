package ie.gmit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {
    Manager manager;

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
        manager = new Manager("Mr", "Ruairi Doherty", "NZ23AMZ3", "Contract", "33 Briarhill",123456789,23, 2000, 24000);
        assertEquals("Mr", manager.getTitle());
        assertEquals("Ruairi Doherty", manager.getName());
        assertEquals(123456789, manager.getPhone());
        assertEquals(23, manager.getAge());
        assertEquals("Contract", manager.getType());
        assertEquals("33 Briarhill", manager.getAddress());
        assertEquals("NZ23AMZ3", manager.getPps());
        assertEquals(2000, manager.getSalary());
        assertEquals(24000, manager.getAnnualSalary());
    }

    @DisplayName("Testing invalid annual salary entry")
    @Test
    void testingInvalidAnnualSalary() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> manager = new Manager("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,19, 2000, -2));
        assertEquals("Annual Salary must be a positive float", e.getMessage());
    }
}