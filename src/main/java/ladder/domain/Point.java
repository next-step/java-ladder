package ladder.domain;

public enum Point {
    CONNECT(true, "-----|"),
    DISCONNECT(false, "     |");

    private final boolean connection;
    private final String view;

    Point(boolean connection, String view) {
        this.connection = connection;
        this.view = view;
    }

    public static Point from(boolean connection) {
        if (connection) {
            return CONNECT;
        }
        return DISCONNECT;
    }

    public boolean getConnection() {
        return this.connection;
    }

    public String view() {
        return this.view;
    }
}
