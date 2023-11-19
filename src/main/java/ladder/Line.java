package ladder;

import java.util.Objects;

class Line{
    private final boolean marked;

    Line(boolean marked) {
        this.marked = marked;
    }

    boolean isMarked() {
        return marked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return marked == line.marked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marked);
    }
}
