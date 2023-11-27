package ladder.domain.type;

/**
 * 사다리 라인에서 두 컬럼 간 연결 여부를 나타내는 enum 클래스
 */
public enum ColumnConnection {
    CONNECTED(true),
    NOT_CONNECTED(false);

    private final boolean isConnected;

    ColumnConnection(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static ColumnConnection of(boolean isConnected) {
        return isConnected ? CONNECTED : NOT_CONNECTED;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean isNotConnected() {
        return !isConnected;
    }
}