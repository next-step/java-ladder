package nextstep.ladder.model;

public enum Point {

    CONNECTED, DISCONNECTED;

    public boolean isConnected() {
        return this == CONNECTED;
    }
}
