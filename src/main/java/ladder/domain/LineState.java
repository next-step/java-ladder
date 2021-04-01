package ladder.domain;

import java.util.Arrays;

public enum LineState {

    LINE(true, "-----"),
    NON_LINE(false, "     ");

    private final boolean isLine;
    private final String display;

    LineState(boolean isLine, String display) {
        this.isLine = isLine;
        this.display = display;
    }

    public static String state(Point point) {
        return Arrays.stream(values())
                .filter(value -> value.isLine == point.isPoint())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .display;
    }
}
