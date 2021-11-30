package nextstep.step2.vo;

import java.util.Objects;

public class Gift {
    private static final String NOT_NULL_OR_EMPTY_EXCEPTION_MESSAGE = "당첨선물은 빈 값이거나 null 일 수 없습니다.";

    private final String value;

    private Gift(String value) {
        this.value = value;
    }

    public static Gift of(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL_OR_EMPTY_EXCEPTION_MESSAGE);
        }

        return new Gift(value);
    }

    public String getValue() {
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
        Gift name = (Gift) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
