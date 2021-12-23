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
}
