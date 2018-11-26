package net.chandol.domain.bridge;

import net.chandol.value.Positive;

import java.util.Objects;

import static net.chandol.value.Positive.ZERO;
import static net.chandol.value.Positive.pos;

public class Bridge {
    private Positive leftLineNumber;
    private Positive rightLineNumber;
    private Positive row;

    public Bridge(Positive leftLineNumber, Positive row) {
        this.leftLineNumber = leftLineNumber;
        this.rightLineNumber = leftLineNumber.increase();
        this.row = row;
    }

    public Positive getLeftLineNumber() {
        return leftLineNumber;
    }

    public Positive getRightLineNumber() {
        return rightLineNumber;
    }

    public Positive getRow() {
        return row;
    }

    public Bridge leftSiblingBridge() {
        if (leftLineNumber.equals(ZERO)) {
            return null;
        }

        return new Bridge(leftLineNumber.decrease(), row);
    }

    public Bridge rightSiblingBridge() {
        return new Bridge(leftLineNumber.increase(), row);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bridge bridge = (Bridge) o;

        if (!Objects.equals(leftLineNumber, bridge.leftLineNumber))
            return false;
        if (!Objects.equals(rightLineNumber, bridge.rightLineNumber))
            return false;
        return Objects.equals(row, bridge.row);
    }

    @Override
    public int hashCode() {
        int result = leftLineNumber != null ? leftLineNumber.hashCode() : 0;
        result = 31 * result + (rightLineNumber != null ? rightLineNumber.hashCode() : 0);
        result = 31 * result + (row != null ? row.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "leftLineNumber=" + leftLineNumber +
                ", row=" + row +
                '}';
    }

    public static Bridge of(Positive leftLineNumber, Positive row) {
        return new Bridge(leftLineNumber, row);
    }

    public static Bridge of(int leftLineNumber, int row) {
        return new Bridge(pos(leftLineNumber), pos(row));
    }
}
