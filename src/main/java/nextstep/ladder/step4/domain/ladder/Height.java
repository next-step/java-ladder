package nextstep.ladder.step4.domain.ladder;

import java.util.Objects;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        valid(height);
        this.height = height;
    }

    public int height() {
        return height;
    }

    private void valid(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 최소 높이는 %d 입니다.", MINIMUM_HEIGHT));
        }
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
