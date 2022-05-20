package ladder.constant;

import java.util.stream.Stream;

public enum Point {

    CONNECTED(true, "-----"),
    DISCONNECTED(false, "     ");

    private final boolean value;
    private final String line;

    Point(boolean value, String line) {
        this.value = value;
        this.line = line;
    }

    public static Point valueOf(boolean value) {
        return Stream.of(values())
                .filter(point -> point.value == value)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isConnect() {
        return this == CONNECTED;
    }

    @Override
    public String toString() {
        return this.line;
    }
}
