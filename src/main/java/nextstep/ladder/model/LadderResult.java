package nextstep.ladder.model;

import java.util.Objects;

public final class LadderResult {

    private final String value;

    public LadderResult(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("전달된 사다리 결과가 null입니다.");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("전달된 사다리 결과가 비어있습니다.");
        }
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
