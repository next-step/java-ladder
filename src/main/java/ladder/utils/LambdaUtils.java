package ladder.utils;

import ladder.error.ErrorMessage;

import java.util.function.BiPredicate;

public class LambdaUtils {

    private LambdaUtils() {
    }

    public static void validateLength(String name, int number, BiPredicate<String , Integer> predicate) {
        if (predicate.test(name, number)) {
            throw new IllegalArgumentException(ErrorMessage.ERR_OUT_OF_LENGTH.print());
        }
    }
}
