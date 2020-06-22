package ladder.domain.ladder;

import ladder.strategy.PointRandomStrategy;
import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_COUNT_OF_USER = 2;

    private List<Point> points = new ArrayList<>();

    private Line(int countOfUser) {
        this(countOfUser, new PointRandomStrategy(countOfUser));
    }

    private Line(int countOfUser, PointStrategy pointStrategy) {
        validate(countOfUser);

        IntStream.range(0, countOfUser)
                .forEach(i -> points.add(pointStrategy.nextPoint()));
    }

    public static Line of(int countOfUser) {
        return new Line(countOfUser);
    }

    public static Line byStrategy(int countOfUser, PointStrategy pointStrategy) {
        return new Line(countOfUser, pointStrategy);
    }

    private void validate(int countOfUser) {
        if (countOfUser < MIN_COUNT_OF_USER) {
            throw new IllegalArgumentException("Line을 생성할 수 없습니다.");
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
