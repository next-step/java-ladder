package ladder.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class Height {
    private static final int MIN_COUNT = 1;
    private final int count;

    public Height(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MIN_COUNT) {
            throw new InputMismatchException("사다리 높이는 1개 이상이어야합니다.");
        }
    }

    public int find() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height count1 = (Height) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
