package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.LadderLengthException;

public class Height {

    private static final int HEIGHT_MINIMUM_SIZE = 1;

    private final int height;

    public Height(int height) {
        valid(height);
        this.height = height;
    }

    private void valid(int height) {
        if (height < HEIGHT_MINIMUM_SIZE) {
            throw new LadderLengthException(HEIGHT_MINIMUM_SIZE);
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
