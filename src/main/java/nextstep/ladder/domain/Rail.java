package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rail {
    private final Height height;
    private final List<Boolean> points;

    private Rail(final Height height, final List<Boolean> points) {
        this.height = height;
        this.points = Collections.unmodifiableList(points);
    }

    public static Rail of(final int height) {
        return Rail.of(Height.of(height));
    }

    public static Rail of(Height height) {
        if (height == null) {
            throw new IllegalArgumentException("invalid height: cannot be null.");
        }

        List<Boolean> points = new ArrayList<>(height.toInt());
        // todo generate via strategy
        Collections.fill(points, false);

        return new Rail(height, points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rail rail = (Rail) o;
        return Objects.equals(height, rail.height) &&
                Objects.equals(points, rail.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, points);
    }
}
