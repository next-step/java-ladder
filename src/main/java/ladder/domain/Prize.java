package ladder.domain;

import java.util.Objects;

public class Prize {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";

    private final String name;

    public Prize(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Prize)) {
            return false;
        }

        return this.name.equals(((Prize) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
