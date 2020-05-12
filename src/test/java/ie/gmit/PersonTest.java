package ie.gmit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    Person person;

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
        person = new Person("Mr", "Ruairi Doherty", "33 Briarhill", 123456789);
        assertEquals("Mr", person.getTitle());
        assertEquals("Ruairi Doherty", person.getName());
        assertEquals(123456789, person.getPhone());
        assertEquals("33 Briarhill", person.getAddress());
    }

    @DisplayName("Testing invalid title entry")
    @Test
    void testingInvalidTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("M", "Random Name", "NGGGGGGG", 123456789));
        assertEquals("Invalid title provided", e.getMessage());
    }

    @DisplayName("Testing invalid name entry")
    @Test
    void testingInvalidName() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("Mr", "Ru", "NZ23AMZ23", 123456789));
        assertEquals("Name must contain 3 - 25 characters", e.getMessage());
    }

    @DisplayName("Testing invalid phone entry")
    @Test
    void testingInvalidPhone() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("Mr", "Ruairi Doherty", "NZ23AMZ3", 12345678));
        assertEquals("Phone number must be 9 digits", e.getMessage());
    }

}