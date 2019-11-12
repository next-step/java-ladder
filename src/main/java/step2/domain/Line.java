package step2.domain;

import java.util.List;
import java.util.Objects;

public abstract class Line implements Printable {
    protected final List<Dot> dots;

    Line(final List<Dot> dots) {
        this.dots = dots;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        final Line line = (Line) o;
        return Objects.equals(dots, line.dots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dots);
    }
}
