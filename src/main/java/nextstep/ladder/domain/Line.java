package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Line {
    private List<Boolean> points = new ArrayList<>();

    private Line() {
    }

    public Line(List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line init(int sizeOfPerson) {
        List<Boolean> points = new ArrayList<>();

        firstPointInit(points);

        centerPointsInit(points, sizeOfPerson);

        lastPointInit(points);

        return new Line(points);
    }

    private static void firstPointInit(List<Boolean> points) {
        points.add(RandomBooleanGenerator.generate());
    }

    private static void centerPointsInit(List<Boolean> points, int sizeOfPerson) {
        for (int index = 1; index < sizeOfPerson -1; index++) {
            if (points.get(index - 1)) {
                points.add(false);
                continue;
            }

            points.add(RandomBooleanGenerator.generate());
        }
    }

    private static void lastPointInit(List<Boolean> points) {
        points.add(false);
    }

    public int size() {
        return this.points.size();
    }

    public Stream<Boolean> stream() {
        return this.points.stream();
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

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
