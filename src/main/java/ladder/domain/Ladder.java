package ladder.domain;

import java.util.Objects;

public class Ladder {

    private final int height;

    private Ladder(int height) {
        validate(height);
        this.height = height;
    }

    public static Ladder createWithHeight(int height) {
        return new Ladder(height);
    }

    private void validate(int height) {
        if(height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return height == ladder.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
