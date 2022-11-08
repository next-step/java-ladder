package ladder.domain;

import java.util.Objects;

public class LadderResult {

    private final String value;

    public LadderResult(final String value) {
        validateOrThrow(value);

        this.value = value;
    }

    private void validateOrThrow(final String value) {
        if (Objects.isNull(value) || value.isBlank()) {
            throw new IllegalArgumentException("사다리 결과는 빈 문자열일 수 없습니다.");
        }
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
