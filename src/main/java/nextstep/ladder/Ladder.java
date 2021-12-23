package nextstep.ladder;

import java.util.Objects;

public class Ladder {
    private final int height;

    public Ladder(int height) {
        this.height = height;
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
