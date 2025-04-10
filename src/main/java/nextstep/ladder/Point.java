package nextstep.ladder;

import java.util.Arrays;

public enum Point {
    HAS_LINE(true, "-----"),
    NO_LINE(false, "     ");

    private final boolean hasLine;
    private final String display;

    Point(boolean hasLine, String display) {
        this.hasLine = hasLine;
        this.display = display;
    }

    public static Point of(boolean hasLine) {
        return Arrays.stream(values())
                .filter(point -> point.hasLine == hasLine)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid point value: " + hasLine));
    }

    @Override
    public String toString() {
        return display;
    }
}
