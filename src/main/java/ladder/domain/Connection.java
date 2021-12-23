package ladder.domain;

import java.util.Objects;

public class Connection {
    private final Boolean connected;

    public Connection(Boolean connected) {
        this.connected = connected;
    }

    public Boolean getConnected() {
        return this.connected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(connected, that.connected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connected);
    }
}
