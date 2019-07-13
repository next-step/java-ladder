package ladder.utils;

import java.util.regex.Pattern;

public enum Validation {

    NAME_VALIDATE("^[a-zA-Z]*$");

    public boolean isInValid(String target) {
        return !Pattern.matches(this.regex, target);
    }

    Validation(String regex) {
        this.regex = regex;
    }

    private String regex;

}
