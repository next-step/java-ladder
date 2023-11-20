package ladder.domain;

import java.util.Objects;

public class Column {
    private final boolean marked;

    //TODO Line에 대해 Cache 처리

    Column(boolean marked) {
        this.marked = marked;
    }

    public boolean isMarked() {
        return marked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return marked == column.marked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marked);
    }
}
