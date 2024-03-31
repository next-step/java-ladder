package laddergame.util;

import static java.util.Objects.nonNull;

public class Validator {
    public static boolean isNonBlank(String stringInput) {
        return nonNull(stringInput) && !stringInput.isBlank();
    }
}
