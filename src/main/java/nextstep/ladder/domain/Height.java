package nextstep.ladder.domain;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Height {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String NOT_NUMBER = "입력값은 숫자 값이어야 합니다 -> %s";
    private static final String LESS_THAN_ONE = "높이는 0보다 커야 합니다 -> %s";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    private final int height;

    public Height(final String height) {
        validateHeight(height);
        this.height = Integer.parseInt(height);
    }

    public int getHeight() {
        return height;
    }

    public IntStream intStream() {
        return IntStream.range(0, height);
    }

    private void validateHeight(final String height) {
        requireNonNull(height);
        requireNumber(height);
        requireOverZero(Integer.parseInt(height));
    }

    private void requireOverZero(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(String.format(LESS_THAN_ONE, number));
        }
    }

    private void requireNumber(final String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(String.format(NOT_NUMBER, number));
        }
    }

    private void requireNonNull(final String height) {
        if (Objects.isNull(height)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }
}
