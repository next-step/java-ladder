package cc.oakk.ladder.model.line;

import java.util.Objects;

public class Connection {
    public static final Connection TRUE = new Connection(true);
    public static final Connection FALSE = new Connection(false);

    protected boolean connected;

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
