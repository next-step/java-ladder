package nextstep.ladder.domain;

import java.util.Objects;

public class Connection {
    private final boolean connection;

    public Connection(boolean connection) {
        this.connection = connection;
    }

    public boolean isConnected() {
        return connection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connection)) return false;
        Connection that = (Connection) o;
        return connection == that.connection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection);
    }
}
