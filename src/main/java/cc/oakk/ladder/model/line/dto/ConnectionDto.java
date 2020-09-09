package cc.oakk.ladder.model.line.dto;

import cc.oakk.ladder.model.line.Connection;

import java.util.Objects;

public class ConnectionDto {
    private final boolean connected;

    public ConnectionDto(boolean connected) {
        this.connected = connected;
    }

    public static ConnectionDto of(Connection connection) {
        return new ConnectionDto(connection.get());
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionDto that = (ConnectionDto) o;
        return connected == that.connected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connected);
    }
}
