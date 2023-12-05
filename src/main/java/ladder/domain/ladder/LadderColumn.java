package ladder.domain.ladder;

import java.util.Objects;
import java.util.Optional;

import static ladder.domain.ladder.LadderConnection.LEFT;
import static ladder.domain.ladder.LadderConnection.RIGHT;

/**
 * 사다리의 한 포인트를 나타냅니다.
 * 개념적으로 |-|에서 | 부분들을 나타냅니다.
 * 불변 객체입니다.
 */
public class LadderColumn {
    private final int columnIndex;
    private final LadderConnection connection;

    public LadderColumn(int columnIndex, LadderConnection connection) {
        this.columnIndex = columnIndex;
        this.connection = connection;
    }

    /**
     * 우측으로 연결되어 있다면 true
     */
    public Boolean isConnectedRight() {
        return this.connection == RIGHT;
    }

    public boolean isConnectedLeft() {
        return this.connection == LEFT;
    }

    public boolean isNotConnectedLeft() {
        return !isConnectedLeft();
    }

    public boolean isNotConnectedRight() {
        return !isConnectedRight();
    }

    public boolean isConnectedSomewhere() {
        return this.connection != LadderConnection.NONE;
    }

    public boolean isNotConnected() {
        return this.connection == LadderConnection.NONE;
    }

    /**
     * 이 컬럼과 연결된 컬럼의 인덱스 번호를 반환합니다.
     * 연결 된 것이 없다면 자신의 인덱스 번호를 반환합니다.
     *
     * @return 연결된 컬럼 인덱스
     */
    public int connectedColumnIndex() {
        return this.connection.nextColumnOf(this.columnIndex);
    }

    /**
     * 이 컬럼의 인덱스가 주어진 인덱스와 일치하는지 확인합니다.
     *
     * @param columnIndex 검사할 컬럼
     * @return 일치하면 true
     */
    public boolean areYou(int columnIndex) {
        return this.columnIndex == columnIndex;
    }

    @Override
    public String toString() {
        return "LadderColumn{" +
                "columnIndex=" + columnIndex +
                ", connection=" + connection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderColumn that = (LadderColumn) o;
        return columnIndex == that.columnIndex && connection == that.connection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnIndex, connection);
    }

}
