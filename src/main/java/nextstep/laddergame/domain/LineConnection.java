package nextstep.laddergame.domain;

public enum LineConnection {
    CONNECTED, UNCONNECTED;

    public boolean isConnected() {
        return this == CONNECTED;
    }

    public static LineConnection of(boolean isConnected) {
        return isConnected ? CONNECTED : UNCONNECTED;
    }

    public int move(int position, Direction direction) {
        if (this.isConnected()) {
            return direction.move(position);
        }
        return position;
    }
}
