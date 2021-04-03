package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    public final static int START_INDEX = 1;
    public final static int MIN_PERSON = 2;
    private final ConditionStrategy conditionStrategy = () -> new Random().nextBoolean();

    private List<Point> points = new ArrayList<>();

    public Line (int countOfPlayers) {
        validation(countOfPlayers);
        create(countOfPlayers);
    }

    private void validation(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException("참여자는 최소 2명 이상이어야 합니다.");
        }
    }

    private void create(int countOfPlayers) {
        points.add(Point.first(conditionStrategy.randomBoolean()));

        IntStream.range(START_INDEX, countOfPlayers - 1)
                .forEach(i -> points.add(generatePoint(points.get(i - 1), conditionStrategy)));

        points.add(Point.last(points.get(points.size() - 1).current()));
    }

    private Point generatePoint(Point previous, ConditionStrategy conditionStrategy) {
        while (true) {
            boolean current = conditionStrategy.randomBoolean();
            if (isPass(previous.current(), current)) {
                return new Point(previous.current(), current);
            }
        }
    }

    private boolean isPass(boolean previous, boolean current) {
        return !(previous && current);
    }

    public int size() {
        return points.size();
    }

    public String toString() {
        return points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }
}
