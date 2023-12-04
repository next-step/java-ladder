package nextstep.ladder.domain.lines.position;

import java.util.Objects;

public class Height {

    private final int height;

    public Height(int height) {
        this.height = height;
    }

    public boolean isLessThan(int maxHeight) {
        return this.height < maxHeight;
    }

    public Height higherHeight() {
        return new Height(this.height + 1);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
