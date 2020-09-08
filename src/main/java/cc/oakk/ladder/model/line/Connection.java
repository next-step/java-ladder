package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.ConnectionDto;

import java.util.Objects;

public class Connection {
    public static final Connection TRUE = new Connection(true);
    public static final Connection FALSE = new Connection(false);

    private boolean connected;

    public Connection(boolean connected) {
        this.connected = connected;
    }
    
    public boolean get() {
        return connected;
    }

    public Connection set(boolean connected) {
        this.connected = connected;
        return this;
    }

    public ConnectionDto getDto() {
        return new ConnectionDto(connected);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Connection)) {
            return false;
        }
        Connection connection = (Connection) o;
        return connected == connection.connected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connected);
    }
}
