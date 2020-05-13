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
        Customer = new Customer("Mr", "Ruairi Doherty", "33 Briarhill", "wow@gmail.com", 123456789, 2000,1000,4000);
        assertEquals("Mr", Customer.getTitle());
        assertEquals("Ruairi Doherty", Customer.getName());
        assertEquals(123456789, Customer.getPhone());
        assertEquals("33 Briarhill", Customer.getAddress());
        assertEquals(3000, Customer.getBalance());
        assertEquals("wow@gmail.com", Customer.getEmail());
        assertEquals(1000, Customer.getOrder());
        assertEquals(4000, Customer.getCredit());

    }

    @DisplayName("Testing invalid balance")
    @Test
    void testingInvalidBalance() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Customer = new Customer("Mr", "Ruairi Doherty", "NZ23AZ23", "wow@gmail.com", 123456789, 2.111,2000,4000));
        assertEquals("Balance must be in decimal(0.00) format", e.getMessage());
    }

    @DisplayName("Testing invalid credit")
    @Test
    void testingInvalidCredit() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Customer = new Customer("Mr", "Ruairi Doherty", "NZ23AZ23", "wow@gmail.com", 123456789, 2.11,2000,4000.111));
        assertEquals("Credit value must be in decimal(0.00) format", e.getMessage());
    }
    @DisplayName("Testing invalid order process")
    @Test
    void testingInvalidProcess() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Customer = new Customer("Mr", "Ruairi Doherty", "NZ23AZ23", "wow@gmail.com", 123456789, 2.11,2000,1000));
        assertEquals("Insuficient funds", e.getMessage());
    }
    @DisplayName("Testing invalid order ")
    @Test
    void testingInvalidOrder() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> Customer = new Customer("Mr", "Ruairi Doherty", "NZ23AZ23", "wow@gmail.com", 123456789, 2.11,2000.111,1000));
        assertEquals("Order value must be in decimal(0.00) format", e.getMessage());
    }



}
