package ladder.domain;

import java.util.Objects;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        validateLength(height);
        this.height = height;
    }

    private void validateLength(int height) {
        if(height < MIN_HEIGHT) {
            throw new HeightLengthException();
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
