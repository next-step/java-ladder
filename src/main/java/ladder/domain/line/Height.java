package ladder.domain.line;

import java.util.Objects;

public class Height {
    private static final int MIN_HEIGHT_SIZE = 1;
    private static final String MINIMUM_SIZE_MESSAGE = "최소값은 %d 입니다.";

    private final int size;

    public Height(int size) {
        validateMinimumSize(size);
        this.size = size;
    }

    public static Height of(int size) {
        return new Height(size);
    }

    private void validateMinimumSize(int size) {
        if(size < MIN_HEIGHT_SIZE) {
            throw new IllegalArgumentException(String.format(MINIMUM_SIZE_MESSAGE, MIN_HEIGHT_SIZE));
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height that = (Height) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
