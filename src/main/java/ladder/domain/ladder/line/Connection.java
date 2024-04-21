package ladder.domain.ladder.line;

import java.util.Objects;

public class Connection {

    private final boolean isLeftConnected;
    private final boolean isRightConnected;

    private Connection(final boolean isLeftConnected, final boolean isRightConnected) {
        validateNotAllConnected(isLeftConnected, isRightConnected);

        this.isLeftConnected = isLeftConnected;
        this.isRightConnected = isRightConnected;
    }

    private void validateNotAllConnected(final boolean isLeftConnected, final boolean isRightConnected) {
        if (isLeftConnected && isRightConnected) {
            throw new IllegalArgumentException("사다리 라인은 연속으로 연결될 수 없습니다.");
        }
    }

    public boolean isRightConnected() {
        return this.isRightConnected;
    }

    public Connection copyOf() {
        return new Connection(this.isLeftConnected, this.isRightConnected);
    }

    public int move(final int position) {
        final Direction direction = Direction.of(this.isLeftConnected, this.isRightConnected);

        return direction.move(position);
    }

    public Connection next(final boolean isNextConnected) {
        return new Connection(this.isRightConnected, isNextConnected);
    }

    public Connection last() {
        return new Connection(this.isRightConnected, false);
    }

    public static Connection first(final boolean isNextConnected) {
        return new Connection(false, isNextConnected);
    }

    @Override
    public boolean equals(final Object otherConnection) {
        if (this == otherConnection) {
            return true;
        }

        if (otherConnection == null || getClass() != otherConnection.getClass()) {
            return false;
        }

        final Connection that = (Connection)otherConnection;

        return this.isLeftConnected == that.isLeftConnected && this.isRightConnected == that.isRightConnected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isLeftConnected, this.isRightConnected);
    }
}
