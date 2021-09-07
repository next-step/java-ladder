package laddergame.ladder;

import java.util.Arrays;

public enum Connection {
    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean isConnected;

    Connection(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Connection of(boolean isConnected) {
        return Arrays.stream(values())
                .filter(connection -> connection.isConnected == isConnected)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 타입입니다."));
    }
}
