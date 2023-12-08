package seungjun.ladder;

import ladder.LadderColumn;
import ladder.LadderConnection;

import java.util.Objects;

import static ladder.LadderConnection.LEFT;
import static ladder.LadderConnection.RIGHT;


public class SeungjunLadderColumn implements LadderColumn {
    private final int columnIndex;
    private final LadderConnection connection;

    public SeungjunLadderColumn(int columnIndex, LadderConnection connection) {
        this.columnIndex = columnIndex;
        this.connection = connection;
    }

    @Override
    public Boolean isConnectedRight() {
        return this.connection == RIGHT;
    }

    @Override
    public boolean isConnectedLeft() {
        return this.connection == LEFT;
    }

    @Override
    public int connectedColumnIndex() {
        return this.connection.nextColumnOf(this.columnIndex);
    }

    @Override
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
        SeungjunLadderColumn that = (SeungjunLadderColumn) o;
        return columnIndex == that.columnIndex && connection == that.connection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnIndex, connection);
    }

}
