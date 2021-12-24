package nextstep.ladder.domain;

import java.util.Objects;

public class Prize implements nextstep.ladder.engine.Prize {
    private final String result;

    private Prize(final String result) {
        this.result = result;
    }

    public static Prize of(final String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid result: cannot be null or empty");
        }
        return new Prize(result.trim());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize other = (Prize) o;
        return Objects.equals(result, other.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return result;
    }
}
