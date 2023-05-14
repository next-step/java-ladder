package nextstep.ladder.presentation;

public class ConnectionResultView {
    private static final String EMPTY_SPACE = " ";
    private static final String DASH = "-";
    private static final int CONNECTION_PRINT_LENGTH = 5;
    private final boolean connection;

    public ConnectionResultView(boolean connection) {
        this.connection = connection;
    }

    public String connection() {
        return connectionMark().repeat(CONNECTION_PRINT_LENGTH);
    }

    private String connectionMark() {
        if(connection) {
            return DASH;
        }

        return EMPTY_SPACE;
    }
}
