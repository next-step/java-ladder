package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final int width;

    public Ladder(List<String> names) {
        width = createWidthBy(names);
    }

    public Ladder(int width) {
        this.width = width;
    }

    private int createWidthBy(List<String> names) {
        return names.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return width == ladder.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "width=" + width +
                '}';
    }
}
