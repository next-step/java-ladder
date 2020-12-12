package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line initLine(Users users) {
        List<Point> points = new ArrayList<>();
        Direction direction = null;

        int bound = users.getUsers().size();
        for (int number = ZERO; number < bound; number++) {
            int condition = minusIndex(number, bound);
            direction = Direction.decideDirection(direction, condition, new RandomDirectionStrategy());
            points.add(Point.from(number, direction));
        }

        return new Line(points);
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    private static int minusIndex(int number, int bound) {
        if(bound - ONE - number == ZERO) {
            return -ONE;
        }
        return number;
    }

    public int getNextIndex(int index) {
        return points.get(index).getNextPoint();
    }

    public List<Point> getPoints() {
        return points;
    }

}
