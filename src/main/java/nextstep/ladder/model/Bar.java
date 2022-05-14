package nextstep.ladder.model;

import java.util.Objects;

public class Bar {
    private static final String STEP = "-";
    private static final String BLANK = " ";

    private final int count;
    private final boolean isMove;

    public Bar(int count, boolean isMove) {
        this.count = count;
        this.isMove = isMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return count == bar.count && isMove == bar.isMove;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, isMove);
    }

    @Override
    public String toString() {
        String repeat = STEP.repeat(count);
        if (isMove) {
            return repeat;
        }
        return repeat.replaceAll(STEP, BLANK);
    }
}
