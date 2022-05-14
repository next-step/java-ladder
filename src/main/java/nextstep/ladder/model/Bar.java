package nextstep.ladder.model;

import java.util.Objects;

public class Bar {
    private static final String STEP = "-";
    private static final String BLANK = " ";

    private final int count;
    private final boolean isActivate;

    public Bar(int count, boolean isActivate) {
        this.count = count;
        this.isActivate = isActivate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return count == bar.count && isActivate == bar.isActivate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, isActivate);
    }

    @Override
    public String toString() {
        String repeat = STEP.repeat(count);
        if (isActivate) {
            return repeat;
        }
        return repeat.replaceAll(STEP, BLANK);
    }
}
