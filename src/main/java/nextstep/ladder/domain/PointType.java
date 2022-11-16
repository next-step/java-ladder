package nextstep.ladder.domain;

import java.util.Arrays;

public enum PointType {

    NODE(true),

    NOTHING(false);

    private final boolean value;

    PointType(final boolean value) {
        this.value = value;
    }

    public static PointType valueOf(final boolean value) {
        return Arrays.stream(values())
            .filter(result -> result.value == value)
            .findFirst()
            .orElse(PointType.NOTHING);
    }

    public boolean isNode() {
        return value;
    }

}
