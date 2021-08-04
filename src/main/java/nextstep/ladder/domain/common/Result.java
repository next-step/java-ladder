package nextstep.ladder.domain.common;

import nextstep.ladder.domain.common.exception.InvalidResultException;

public class Result {

    private final String value;

    public Result(final String value) {
        this.value = value;
    }

    public static Result of(final String value) {
        createValidation(value);
        return new Result(value);
    }

    private static void createValidation(final String value) {
        if (value.equals("꽝")) {
            return;
        }

        try {
            Integer.parseInt(value);
        } catch (final NumberFormatException ex) {
            throw new InvalidResultException();
        }
    }

    public String getValue() {
        return value;
    }
}
