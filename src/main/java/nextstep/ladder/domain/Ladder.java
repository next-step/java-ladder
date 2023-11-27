package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.lines.Lines;

public class Ladder {
    private final int width;
    private final Lines lines;

    public Ladder(List<String> names, Lines lines) {
        this.width = createWidthBy(names);
        this.lines = lines;
    }

    public Ladder(int width, Lines lines) {
        this.width = width;
        this.lines = lines;
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
        return width == ladder.width && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "width=" + width +
                ", lines=" + lines +
                '}';
    }
}
