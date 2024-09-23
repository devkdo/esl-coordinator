package io.dvkdo.eslcoord;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class DependencyUtilityTest {

    @Test
    public void testUsingEmailValidator() {
        String emailAddress = "username@domain.com";
        assertTrue(EmailValidator.getInstance()
                .isValid(emailAddress));
    }
}
