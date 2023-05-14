package nextstep.ladder.presentation;

import nextstep.ladder.domain.Connection;

public class ConnectionResultView {
    private static final String EMPTY_SPACE = " ";
    private static final String DASH = "-";
    private static final int CONNECTION_PRINT_LENGTH = 5;
    private final Connection connection;

    public ConnectionResultView(Connection connection) {
        this.connection = connection;
    }

    public String connection() {
        return connectionMark().repeat(CONNECTION_PRINT_LENGTH);
    }

    private String connectionMark() {
        if(connection.isConnected()) {
            return DASH;
        }

        return EMPTY_SPACE;
    }
}
