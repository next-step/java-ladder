package nextstep.ladder.utils;

import java.text.MessageFormat;

public interface IntegerUtils {

    static int getNumberIfPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(
                MessageFormat.format("{0}은 양수가 아닙니다.", number)
            );
        }
        return number;
    }
}
