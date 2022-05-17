package ladder.constant;

public enum Point {

    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean value;

    Point(boolean value) {
        this.value = value;
    }

    public boolean isConnect() {
        return this == CONNECTED;
    }
}
