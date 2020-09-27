package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;

public enum PointRaw {
    EXIST(true, "-"),
    EMPTY(false, " ");

    private boolean isExist;
    private String raw;
    PointRaw(boolean isExist, String raw) {
        this.isExist = isExist;
        this.raw = raw;
    }

    public static String getRawByIsPointExist(Point point, int pointNumber) {
        return Arrays.stream(values())
                .filter(e -> e.isExist == point.isExist())
                .map(e -> e.raw)
                .map(e -> String.join("", Collections.nCopies(pointNumber, e)))
                .findFirst()
                .orElseThrow(AssertionError::new);
    }
}
