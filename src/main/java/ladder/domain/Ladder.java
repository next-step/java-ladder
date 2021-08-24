package ladder.domain;

import java.util.Objects;

public class Ladder {

    private final Width width;

    private final Height height;

    private final Lines lines;

    private Ladder(Width width, Height height) {
        this.width = width;
        this.height = height;
        this.lines = Lines.create(width, height);
    }

    public static Ladder create(Width width, Height height) {
        return new Ladder(width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(width, ladder.width) && Objects.equals(height, ladder.height) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, lines);
    }
}
