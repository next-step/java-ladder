package ladder.domain.line;

public class ConnectionCount {

    static final int MINIMUM_CONNECTION_COUNT = 1;

    private final int count;

    private ConnectionCount(final int count) {
        validateConnectionCountIsNotLessThanMinimum(count);

        this.count = count;
    }

    int count() {
        return this.count;
    }

    private void validateConnectionCountIsNotLessThanMinimum(final int count) {
        if (count < MINIMUM_CONNECTION_COUNT) {
            throw new IllegalArgumentException("사다리 연결 개수는 최소 개수 이상이어야 합니다. 개수: " + count);
        }
    }

    public static ConnectionCount from(final int playersCount) {
        return new ConnectionCount(playersCount - 1);
    }
}
