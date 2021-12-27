package ladderstep4.ladder.domain;

import java.util.Objects;

public class Prize {
    public static final String INVALID_NAME_MESSAGE = "상은 1~5글자입니다.";

    private static final int MAX_LENGTH = 5;

    private final String value;

    public Prize(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty() || value.trim().length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.value = value.trim();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Prize prize = (Prize) o;

        return value != null ? value.equals(prize.value) : prize.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
