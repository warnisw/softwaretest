package ie.gmit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {
    Customer Customer;

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
        Customer = new Customer("Mr", "Ruairi Doherty", "NZ23AMZ3", "Contract", "33 Briarhill",123456789,23, 0);
        assertEquals("Mr", Customer.getTitle());
        assertEquals("Ruairi Doherty", Customer.getName());
        assertEquals(123456789, Customer.getPhone());
        assertEquals(23, Customer.getAge());
        assertEquals("Contract", Customer.getType());
        assertEquals("33 Briarhill", Customer.getAddress());
        assertEquals("NZ23AMZ3", Customer.getPps());
        assertEquals(0, Customer.getBalance());

    }

    @DisplayName("Testing invalid balance")
    @Test
    void testingInvalidHourRate() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Customer = new Customer("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,19, 20.112));
        assertEquals("Balance must be in decimal(0.00) format", e.getMessage());
    }


}
