package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Line {

    private static final int MINIMUM_GAME_PEOPLE = 2;
    private static final int LAST_GAME_PERSION = 1;

    private List<Point> points = new ArrayList<>();
    private Random random = new Random();

    public Line(int countOfPerson) {
        if (countOfPerson < MINIMUM_GAME_PEOPLE) {
            throw new IllegalArgumentException("최소 " + MINIMUM_GAME_PEOPLE + "명 이상으로 게임을 진행해주세요.");
        }
        makePoints(countOfPerson, null);
    }

    private void makePoints(int countOfPerson, Point prevPoint) {
        if (countOfPerson == LAST_GAME_PERSION) {
            points.add(lastPoint(prevPoint));
            return;
        }

        Point nowPoint = makePoint(prevPoint);
        points.add(nowPoint);
        
        makePoints(countOfPerson - 1, nowPoint);
    }

    private Point makePoint(Point prevPoint) {
        Optional<Point> opPoint = Optional.ofNullable(prevPoint);
        if (!opPoint.isPresent()) {
            return firstPoint();
        }

        boolean nextPoint = opPoint.filter(Point::isNextPoint)
                .map(point -> false)
                .orElse(random.nextBoolean());

        return new Point(prevPoint.isNextPoint(), nextPoint);
    }

    private Point firstPoint() {
        return new Point(false, random.nextBoolean());
    }

    private Point lastPoint(Point prevPoint) {
        return new Point(prevPoint.isNextPoint(), false);
    }

    public List<Point> getPoints() {
        return points;
    }
}
