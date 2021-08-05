package ladder.util;

import java.util.Objects;
import java.util.function.Supplier;

public class StringLength {
    private final int minLength;
    private final int maxLength;

    public StringLength(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public void orThrow(String str, Supplier<RuntimeException> e) {
        if (Objects.nonNull(str)
                && str.length() >= minLength
                && str.length() <= maxLength) {
            return;
        }
        throw e.get();
    }
}
