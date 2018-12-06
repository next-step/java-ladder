package ladder.domain;

import ladder.strategy.Difficulty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {

    private List<Point> points;
    private Difficulty difficulty;

    private LadderLine(int sizeOfPerson, Difficulty difficulty) {
        this.difficulty = difficulty;
        this.points = init(sizeOfPerson);
    }

    public static LadderLine create(int sizeOfPerson) {
        return new LadderLine(sizeOfPerson, Difficulty.MIDDLE);
    }

    public static LadderLine create(int sizeOfPerson, Difficulty difficulty) {
        return new LadderLine(sizeOfPerson, difficulty);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> init(int sizeOfPerson) {
        points = new ArrayList<>();
        Point point = initFirst();
        point = initBody(sizeOfPerson, point);
        initLast(point);
        return points;
    }

    private Point initBody(int sizeOfPerson, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(difficulty);
            points.add(point);
        }
        return point;
    }

    private void initLast(Point point) {
        point = point.last();
        points.add(point);
    }

    private Point initFirst() {
        Point point = Point.first(difficulty.generate());
        points.add(point);
        return point;
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return points.stream().map(Point::toString).collect(Collectors.joining(""));
    }
}
