package nextstep.ladder.domain;

import nextstep.ladder.util.Utils;

import java.util.Arrays;

public enum PointRaw {
    EXIST(true, "-"),
    EMPTY(false, " ");

    private boolean isExist;
    private String raw;

    PointRaw(boolean isExist, String raw) {
        this.isExist = isExist;
        this.raw = raw;
    }

    public static String getPointRightRaw(Point point, int pointNumber) {
        return Arrays.stream(values())
                .filter(raw -> raw.isExist == point.isLeftDirectionExist())
                .map(e -> e.raw)
                .map(e -> Utils.repeat(e, pointNumber))
                .findFirst()
                .orElseThrow(AssertionError::new);
    }
}
