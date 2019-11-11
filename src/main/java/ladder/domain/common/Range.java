package ladder.domain.common;

import java.util.Objects;

public class Range {
    private final int colRange;
    private final Height height;

    public Range(int colRange, Height height) {
        this.colRange = colRange;
        this.height = height;
    }

    private Range(Range range, Height nowHeight) {
        this.colRange = range.getColRange();
        this.height = nowHeight;
    }

    public static Range makeNowRange(Range range, int height) {
        return new Range(range, new Height(height));
    }

    public int getColRange() {
        return colRange;
    }

    public int getHeight() {
        return height.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return colRange == range.colRange &&
                Objects.equals(height, range.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colRange, height);
    }
}
