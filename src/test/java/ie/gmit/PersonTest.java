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
        person = new Person("Mr", "Ruairi Doherty", "NZ23AMZ3", "Contract", "33 Briarhill",123456789,23);
        assertEquals("Mr", person.getTitle());
        assertEquals("Ruairi Doherty", person.getName());
        assertEquals(123456789, person.getPhone());
        assertEquals(23, person.getAge());
        assertEquals("Contract", person.getType());
        assertEquals("33 Briarhill", person.getAddress());
        assertEquals("NZ23AMZ3", person.getPps());
    }

    @DisplayName("Testing invalid title entry")
    @Test
    void testingInvalidTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("M", "Random Name", "NGGGGGGG", "Contract", "120 Roscam", 123456789,44));
        assertEquals("Invalid title provided", e.getMessage());
    }

    @DisplayName("Testing invalid name entry")
    @Test
    void testingInvalidName() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("Mr", "Ru", "NZ23AMZ23", "Contract", "130 Doughiska", 123456789,23));
        assertEquals("Name must contain 3 - 25 characters", e.getMessage());
    }

    @DisplayName("Testing invalid pps entry")
    @Test
    void testingInvalidPPS() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("Mr", "Ruandria", "NZ", "Contract", "94 Claremorris", 123456789,23));
        assertEquals("PPS must contain 8 characters", e.getMessage());
    }

    @DisplayName("Testing invalid type entry")
    @Test
    void testingInvalidType() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("Mr", "Ruairi Doherty", "NZ23AM23", "none", "69 GMIT", 123456789,23));
        assertEquals("Must contain employment type", e.getMessage());
    }

    @DisplayName("Testing invalid phone entry")
    @Test
    void testingInvalidPhone() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("Mr", "Ruairi Doherty", "NZ23AMZ3", "Part-time", "88 Ros Cah Hill", 1234569,23));
        assertEquals("Phone number must be 9 digits", e.getMessage());
    }

    @DisplayName("Testing invalid age entry")
    @Test
    void testingInvalidAge() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> person = new Person("Mr", "Ruairi Doherty", "NZ23AZ23", "Contract", "11 Salthill", 123456789,13));
        assertEquals("Employee age must be over 16 to work in the company", e.getMessage());
    }
}