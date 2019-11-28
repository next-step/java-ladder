package ladder.structure.connection;

public class Connection {
    public static final Connection NOT_CONNECTED_BRIDGE = new Connection(false);
    public static final Connection CONNECTED_BRIDGE = new Connection(true);
    private final boolean connection;

    private Connection(boolean connection) {
        this.connection = connection;
    }

    public static Connection of(ConnectionStrategy connectionStrategy, Connection before) {
        if (before != null && before.isConnected()) {
            return NOT_CONNECTED_BRIDGE;
        }
        boolean connected = connectionStrategy.create();
        if (connected) {
            return CONNECTED_BRIDGE;
        }
        return NOT_CONNECTED_BRIDGE;
    }

    public boolean isConnected() {
        return this.connection;
    }
}
