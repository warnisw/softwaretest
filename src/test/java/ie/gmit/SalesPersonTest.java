package ie.gmit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SalesPersonTest {
    SalesPerson salesPerson;

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
        salesPerson = new SalesPerson("Mr", "Ruairi Doherty", "NZ23AMZ3", "Contract", "33 Briarhill",123456789,23, 2000, 20, 50);
        assertEquals("Mr", salesPerson.getTitle());
        assertEquals("Ruairi Doherty", salesPerson.getName());
        assertEquals(123456789, salesPerson.getPhone());
        assertEquals(23, salesPerson.getAge());
        assertEquals("Contract", salesPerson.getType());
        assertEquals("33 Briarhill", salesPerson.getAddress());
        assertEquals("NZ23AMZ3", salesPerson.getPps());
        assertEquals(50000, salesPerson.getSalary());
        assertEquals(20, salesPerson.getHourRate());
        assertEquals(50, salesPerson.getHours());
    }

    @DisplayName("Testing invalid Hour Rate")
    @Test
    void testingInvalidHourRate() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> salesPerson = new SalesPerson("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,19, 2000, -10, 50));
        assertEquals("Hour Rate must be a positive float", e.getMessage());
    }

    @DisplayName("Testing invalid Hours")
    @Test
    void testingInvalidHours() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> salesPerson = new SalesPerson("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,19, 2000, 20, -50));
        assertEquals("Hours must be a positive float", e.getMessage());
    }
}
