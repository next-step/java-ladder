package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

public class Connection {
    private boolean connection;

    public Connection(boolean connection) {
        this.connection = connection;
    }

    public static Connection of(ConnectionStrategy connectionStrategy, Connection before) {
        if (before != null && before.isConnected()) {
            return new Connection(false);
        }
        return new Connection(connectionStrategy.create());
    }

    public boolean isConnected() {
        return this.connection;
    }
}
