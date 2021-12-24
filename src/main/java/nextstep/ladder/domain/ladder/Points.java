package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.Strategy;

import java.util.List;
import java.util.Objects;

public class Points {
    private final List<Boolean> values;

    private Points(List<Boolean> points) {
        this.values = points;
    }

    public static Points from(List<Boolean> points) {
        return new Points(points);
    }

    public static Points of(int numberOfParticipants, Strategy strategy) {
        return new Points(strategy.points(numberOfParticipants));
    }

    public List<Boolean> values() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return Objects.equals(values, points.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Points{" +
                "values=" + values +
                '}';
    }
}
