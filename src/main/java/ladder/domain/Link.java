package ladder.domain;

public enum Link {
    OPEN,
    CLOSE;

    public boolean isClosed() {
        return this == CLOSE;
    }

    public boolean isOpened() {
        return this == OPEN;
    }
}
