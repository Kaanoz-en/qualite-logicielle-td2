package PasswordValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {
    private final String SHORT_PASSWORD = "123";
    private final String VALID_PASSWORD = "1234Ab5678";
    private final String LOWERCASE_PASSWORD = "abcdefghikl";
    private final String UPPERCASE_PASSWORD = "ABCDEFGHIKL";
    private final String LETTERS_ONLY_PASSWORD = "OUAAIHDIOBQDOAdazfa";

    private PasswordValidator passwordValidator;

    @BeforeEach
    public void createPasswordValidator(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void givenAValidPassword_whenValid_thenTrue(){
        boolean isValid = passwordValidator.isValid(VALID_PASSWORD);
        assertTrue(isValid);
    }

    @Test
    public void givenPasswordWithLessThan8Characters_whenIsValid_thenReturnFasle(){
        boolean isValid = passwordValidator.isValid(SHORT_PASSWORD);

        assertEquals(isValid, false);
    }

    @Test
    public void givenPasswordWithNoUppercaseLetters_whenIsValid_thenReturnFalse(){
        boolean isValid = passwordValidator.isValid(LOWERCASE_PASSWORD);

        assertEquals(isValid, false);
    }

    @Test
    public void givenPasswordWithNoLowercaseLetters_whenIsValid_thenReturnFalse(){
        boolean isValid = passwordValidator.isValid(UPPERCASE_PASSWORD);

        assertEquals(isValid, false);
    }

    @Test
    public void givenPasswordWithNoNumericCharacters_whenIsValid_thenReturnFalse(){
        boolean isValid = passwordValidator.isValid(LETTERS_ONLY_PASSWORD);

        assertEquals(isValid, false);
    }

    @Test
    public void givenPasswordWithNoSpecialCharacters_whenIsValid_thenReturnFalse(){
        boolean isValid = passwordValidator.isValid(LETTERS_ONLY_PASSWORD);

        assertEquals(isValid, false);
    }
}
