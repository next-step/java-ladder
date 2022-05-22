package ladder.constant;

import java.util.stream.Stream;

public enum Point {

    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean value;

    Point(boolean value) {
        this.value = value;
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
}
