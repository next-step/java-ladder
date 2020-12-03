package nextstep.ladder.domain;

import java.util.Objects;

public class Connection {
    private final boolean isConnected;

    public Connection(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Connection connected() {
        return new Connection(true);
    }

    public static Connection disConnected() {
        return new Connection(false);
    }

    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return isConnected == that.isConnected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isConnected);
    }
}
