package step03.domain;

import exception.InvalidPointsOfStepException;
import strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Step {
    private final List<Point> points;

    private Step(List<Point> points) {
        this.points = points;
    }

    public static Step of(List<Boolean> points) {
        validate(points);
        return new Step(
                points.stream()
                        .map(Point::of)
                        .collect(Collectors.toList())
        );
    }

    public static Step of(int countOfParticipants, PointStrategy pointStrategy) {
        return of(initStep(countOfParticipants - 1, pointStrategy));
    }

    private static List<Boolean> initStep(int countOfPoints, PointStrategy pointStrategy) {
        List<Boolean> points = new ArrayList<>();
        points.add(pointStrategy.hasPoint());

        for (int i = 1; i < countOfPoints; i++) {
            points.add(hasLine(points, pointStrategy));
        }

        return points;
    }

    private static Boolean hasLine(List<Boolean> points, PointStrategy pointStrategy) {
        return !points.get(points.size() - 1) && pointStrategy.hasPoint();
    }

    private static void validate(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1))
                .findAny()
                .ifPresent((i) -> {
                    throw new InvalidPointsOfStepException();
                });
    }

    public List<Boolean> getPoints() {
        return points.stream()
                .map(Point::hasLine)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return Objects.equals(points, step.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
