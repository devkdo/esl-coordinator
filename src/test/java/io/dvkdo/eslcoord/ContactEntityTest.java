package io.dvkdo.eslcoord;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ContactEntityTest {

    @Test
    public void testToString() {
        ContactEntity testContact = new ContactEntity();
        testContact.setFirstname("John");
        testContact.setLastname("Doe");
        testContact.setEmail("jdoe@email.org");
        String expected = "{\"firstname\":\"John\",\"lastname\":\"Doe\",\"email\":\"jdoe@email.org\"}";
        assertEquals(expected, testContact.toString());
    }

    @Test @Disabled
    public void testIsPersistent() {
        ContactEntity testContact = new ContactEntity();
        testContact.setFirstname("John");
        testContact.setLastname("Doe");
        testContact.setEmail("jdoe@email.org");
        assertTrue(testContact.isPersistent());
    }
}
