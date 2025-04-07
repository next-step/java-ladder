package ladder.domain;

public enum Bridge {
    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean connected;

    Bridge(boolean connected) {
        this.connected = connected;
    }

    public static Bridge of(boolean connected) {
        return connected ? CONNECTED : DISCONNECTED;
    }
}

