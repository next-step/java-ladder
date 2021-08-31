package nextstep.ladders;

import java.util.Objects;

public class Ladder {

    private final Lines lines;

    public Ladder(final Lines lines) {
        this.lines = lines;
    }

    public Ladder(final Generator generator, final int height, final int numberOfPeople) {
        this(new Lines(generator, height, numberOfPeople));
    }

    public int start(final int index) {
        return lines.move(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
