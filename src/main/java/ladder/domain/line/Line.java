package ladder.domain.line;

import ladder.domain.Point;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final int MINIMUM_GAME_PEOPLE = 2;

    private int countOfPerson;
    private List<Point> points;

    private Line(int countOfPerson, List<Point> points) {
        this.countOfPerson = countOfPerson;
        this.points = points;
    }

    public static Line of(int countOfPerson, LineStrategy lineStrategy) {
        validationCountOfPerstion(countOfPerson);
        return new Line(countOfPerson, makeLine(countOfPerson, lineStrategy));
    }


    private static void validationCountOfPerstion(int countOfPerson) {
        if (countOfPerson < MINIMUM_GAME_PEOPLE) {
            throw new IllegalArgumentException("최소 " + MINIMUM_GAME_PEOPLE + "명 이상으로 게임을 진행해주세요.");
        }
    }

    private static List<Point> makeLine(int countOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(lineStrategy.makePoint(null, countOfPerson));
        IntStream.rangeClosed(1, countOfPerson - LineStrategy.LAST_VALUE)
                .forEach(i -> points.add(lineStrategy.makePoint(points.get(i - 1), countOfPerson - i)));
        return points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}