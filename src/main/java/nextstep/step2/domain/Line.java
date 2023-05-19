package nextstep.step2.domain;

import nextstep.step2.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfParticipant, BooleanGenerator generator) {
        IntStream.range(0, countOfParticipant - 1)
                .forEach(i -> this.add(i, generator.generator()));
    }

    private void add(int index, boolean generator) {
        if (existPoint(index)) {
            points.add(false);
            return;
        }

        points.add(generator);
    }

    private boolean existPoint(int index) {
        return index > 0 && points.get(index - 1);
    }

    public List<Boolean> points() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;

        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
