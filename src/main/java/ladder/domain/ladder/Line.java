package ladder.domain.ladder;

import ladder.domain.result.Movement;
import ladder.strategy.StepRandomStrategy;
import ladder.strategy.StepStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_COUNT_OF_LINE = 2;

    private List<Point> points = new ArrayList<>();
    private boolean beforeStep = false;

    private Line(int countOfUser) {
        this(countOfUser, new StepRandomStrategy());
    }

    private Line(int countOfUser, StepStrategy stepStrategy) {
        PointCreator pointCreator = new PointCreator(countOfUser - 1, stepStrategy);
        validate(countOfUser);

        IntStream.range(0, countOfUser)
                .forEach(i -> points.add(pointCreator.nextPoint(i)));
    }

    public static Line of(int countOfUser) {
        return new Line(countOfUser);
    }

    public static Line byStrategy(int countOfUser, StepStrategy stepStrategy) {
        return new Line(countOfUser, stepStrategy);
    }

    private void validate(int countOfUser) {
        if (countOfUser < MIN_COUNT_OF_LINE) {
            throw new IllegalArgumentException("Line을 생성할 수 없습니다.");
        }
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public Movement move(int index) {
        return points.get(index).move();
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
