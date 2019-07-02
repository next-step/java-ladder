package ladder.enumSet;

import java.util.regex.Pattern;

public enum Validation {

    NAME_VALIDATE("^[a-zA-Z]*$"),
    LADDER_HEIGHT_VALIDATE("^[0-9]*$");

    public boolean isInValid(String target) {
        return !Pattern.matches(this.regex, target);
    }

    Validation(String regex) {
        this.regex = regex;
    }

    private String regex;

}
