package nextstep.ladder.domain;

import nextstep.ladder.util.Utils;

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

    public static String getRawByIsPointExist(Leg leg, int pointNumber) {
        return Arrays.stream(values())
                .filter(e -> e.isExist == leg.isExist())
                .map(e -> e.raw)
                .map(e -> Utils.repeat(e, pointNumber))
                .findFirst()
                .orElseThrow(AssertionError::new);
    }
}
