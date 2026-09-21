package PasswordValidator;

import java.util.Locale;

public class PasswordValidator {
    private int MINIMAL_LENGTH = 8;
    private String CONTAIN_NUMERICAL_CHARACTER_REGEX = ".*\\d.*";

    public boolean isValid(final String password){

        return hasMinimumLength(password) && containUppercaseLetter(password) && containLowercaseLetter(password)  && containNumericCharacters(password);
    }

    private boolean hasMinimumLength(final String password){
        return password.length() >= MINIMAL_LENGTH;
    }

    private boolean containUppercaseLetter(final String password){
        String lowerCasePassword = password.toLowerCase();
        return !lowerCasePassword.equals(password);
    }

    private boolean containLowercaseLetter(final String password){
        String upperCasePassword = password.toUpperCase();
        return !upperCasePassword.equals(password);
    }

    private boolean containNumericCharacters(final String password) {
        return password.matches(CONTAIN_NUMERICAL_CHARACTER_REGEX);
    }

}
