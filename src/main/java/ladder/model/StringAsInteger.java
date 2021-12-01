package ladder.model;

import java.util.regex.Pattern;

public class StringAsInteger {

    private static final Pattern numberPattern = Pattern.compile("-?\\d+");
    private final String value;

    public StringAsInteger(String value) {
        checkValidation(value);
        this.value = value;
    }

    private void checkValidation(String value) {
        if(!numberPattern.matcher(value).matches()) {
            throw new IllegalArgumentException("값이 숫자가 아닙니다.");
        }
    }

    public int intValue() {
        return Integer.parseInt(this.value);
    }
}