package nextstep.ladder.domain;

import java.util.Objects;

public class LineRange {
    private int left;
    private int right;

    public LineRange(int left) {
        this.left = left;
        this.right = left + 1;
    }

    void swap(Position position) {
        position.swap(left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LineRange that = (LineRange) o;
        return left == that.left && right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
