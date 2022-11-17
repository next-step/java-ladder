package ladder.domain;

import java.util.Objects;

public class Point {

    private final PositiveInt index;

    public Point(final PositiveInt index) {
        this.index = index;
    }

    public int getIndex() {
        return index.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Point)) {
            return false;
        }

        return this.index.equals(((Point) o).index);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.index);
    }
}
