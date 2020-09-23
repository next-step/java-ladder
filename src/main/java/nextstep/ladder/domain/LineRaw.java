package nextstep.ladder.domain;

import java.util.Arrays;

public enum LineRaw {
    DRAWN(true,  "-----|"),
    EMPTY(false, "     |");

    public final boolean isDrawn;
    public final String raw;

    LineRaw(boolean isDrawn, String raw) {
        this.isDrawn = isDrawn;
        this.raw = raw;
    }

    public static String getRawByIsDrawn(boolean isDrawn) {
        return Arrays.stream(values())
                .filter(e -> e.isDrawn == isDrawn)
                .map(e -> e.raw)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
